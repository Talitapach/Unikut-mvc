package Codes.Model;
import Codes.Controller.DataBase;

public class AccountMessage {
    
    public boolean Message(Account acc, String User, DataBase data, String message){
        for (Account account : acc.getFriends()) {
            if (account.getUsername().equals(User)) {
                account.getMessagesAccounts().add(message);
                return true;
            }
        }
        return false;
    }

    public void ShowMessages(Account acc){
        for (String message: acc.getMessagesAccounts()) {
            System.out.println(message);
        }
    }
}
