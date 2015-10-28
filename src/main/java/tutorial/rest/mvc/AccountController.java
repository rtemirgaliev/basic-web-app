package tutorial.rest.mvc;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tutorial.core.models.entities.Account;
import tutorial.core.models.entities.Blog;
import tutorial.core.services.AccountService;
import tutorial.core.services.exceptions.AccountDoesNotExistException;
import tutorial.core.services.exceptions.AccountExistsException;
import tutorial.core.services.exceptions.BlogExistsException;
import tutorial.core.services.util.AccountList;
import tutorial.rest.exceptions.BadRequestException;
import tutorial.rest.exceptions.ConflictException;
import tutorial.rest.resources.AccountResource;
import tutorial.rest.resources.BlogResource;
import tutorial.rest.resources.asm.AccountResourceAsm;
import tutorial.rest.resources.asm.BlogResourceAsm;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/rest/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<AccountResource> findAllAccounts(@RequestParam(value = "name", required = false) String name) {

        AccountList list = null;

        if (name == null) {
            list = accountService.findAllAccounts();
        } else {
            Account account = accountService.findByAccountName(name);
            if (account == null) {
                list = new AccountList(new ArrayList<Account>());
            } else {
                list = new AccountList(Arrays.asList(account));
            }
        }
        //TODO


    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountResource> createAccount( @RequestBody AccountResource sentAccount) {

        try {
            Account createdAccount = accountService.createAccount(sentAccount.toAccount());

            AccountResource res = new AccountResourceAsm().toResource(createdAccount);

            HttpHeaders headers = new HttpHeaders();

            headers.setLocation(URI.create(res.getLink("self").getHref()));

            return new ResponseEntity<AccountResource>(res, headers, HttpStatus.CREATED);

        } catch (AccountExistsException exception) {

            throw new ConflictException(exception);
        }
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<AccountResource> getAccount( @PathVariable Long accountId ) {

        Account account = accountService.findAccount(accountId);

        if (account != null) {

            AccountResource res = new AccountResourceAsm().toResource(account);
            return new ResponseEntity<AccountResource>(res, HttpStatus.OK);

        } else {

            return new ResponseEntity<AccountResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{accountId}/blogs", method = RequestMethod.POST)
    public ResponseEntity<BlogResource> createBlog( @PathVariable Long accountId, @RequestBody BlogResource res ) {

        try {
            Blog createdBlog = accountService.createBlog(accountId, res.toBlog());

            BlogResource createdBlogRes = new BlogResourceAsm().toResource(createdBlog);

            HttpHeaders headers = new HttpHeaders();

            headers.setLocation(URI.create(createdBlogRes.getLink("self").getHref()));

            return new ResponseEntity<BlogResource>(createdBlogRes, headers, HttpStatus.CREATED);

        } catch (AccountDoesNotExistException exception) {
            throw new BadRequestException(exception);

        } catch (BlogExistsException exception) {
            throw new ConflictException(exception);
        }

    }





}














