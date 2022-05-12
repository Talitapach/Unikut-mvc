package Codes.Model;
import java.util.ArrayList;


public class DataBase implements Runnable{
    
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String accountName;
    private Account acc;
    private DataBase data;
    
    public DataBase(Account acc, DataBase data){
        this.data = data;
        this.acc = acc;
    }

    public DataBase(){
    }

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
        data.getAccounts().add(account);
    }

    public void RemoveAccount(Account account){
        data.getAccounts().remove(account);
    }

    public void ShowAccounts(){
        for (Account account: getAccounts()) {
            System.out.println(account.getName());
        }
    }

    @Override
    public void run() {
        CreateAccount(this.acc);
    }
}
