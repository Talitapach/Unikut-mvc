package Codes.Controller;
import java.util.ArrayList;
import Codes.Model.Account;

public class DataBase {
    
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String accountName;
    
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    
    public void CreateAccount(Account account){
        getAccounts().add(account);
    }

    public void RemoveAccount(Account account){
        getAccounts().remove(account);
    }

    public void ShowAccounts(){
        for (Account account: getAccounts()) {
            System.out.println(account.getName());
        }
    }
}
