package tutorial.core.services.util;

import tutorial.core.models.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountList {

    private List<Account> accounts = new ArrayList<Account>();

    public AccountList(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
