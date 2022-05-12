package Codes.Controller;
import Codes.Model.Account;
import Codes.Model.DataBase;

public class DataBaseLogin {
    
    public boolean Login(String user, String pass, DataBase data){
        for (Account account: data.getAccounts()) {
            if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                data.setAccountName(account.getName());
                return true;
            }
        }
        return false;
    }

    public Account getAccount(String user, String pass, DataBase data){
        for (Account account: data.getAccounts()) {
            if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                return account;
            }
        }
        return null;
    }

}
