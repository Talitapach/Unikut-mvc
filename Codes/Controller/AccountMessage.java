package Codes.Controller;

import Codes.Model.Account;
import Codes.Model.DataBase;
import Codes.Model.Print;

public class AccountMessage implements Print<Account>{
    
    public boolean Message(Account acc, String User, DataBase data, String message){
        for (Account account : acc.getFriends()) {
            if (account.getUsername().equals(User)) {
                account.getMessagesAccounts().add(message);
                return true;
            }
        }
        return false;
    }

    @Override
    public void Show(Account acc){
        for (String message: acc.getMessagesAccounts()) {
            System.out.println(message);
        }
    }
}
