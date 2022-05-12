package Codes.Controller;
import Codes.Model.Account;
import Codes.Model.DataBase;

public class DataBaseEdit {
    public boolean EditAccount(String edit, String user, String pass, int i, DataBase data){
        for (Account account: data.getAccounts()) {
            if (account.getUsername().equals(user) && account.getPassword().equals(pass)) {
                switch (i) {
                    case 1:
                        account.setName(edit);
                        System.out.println(account.getName());
                        break;
                    case 2:
                        account.setUsername(edit);
                        System.out.println(account.getUsername());
                        break;
                    case 3:
                        account.setPassword(edit);
                        System.out.println(account.getPassword());
                        break;
                }         
                return true;
            }
        }
        return false;
    }

}
