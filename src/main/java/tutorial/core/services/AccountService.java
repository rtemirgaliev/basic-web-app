package tutorial.core.services;

import tutorial.core.models.entities.Account;
import tutorial.core.models.entities.Blog;
import tutorial.core.services.util.AccountList;
import tutorial.core.services.util.BlogList;

public interface AccountService {

    public Account findAccount(Long id);

    public Account createAccount(Account data);

    public Blog createBlog(Long accountId, Blog data);

    public BlogList findBlogsByAccount(Long accountId);

    public AccountList findAllAccounts();

    public Account findByAccountName(String name);

}
