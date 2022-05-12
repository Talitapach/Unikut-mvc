package Codes.Controller;

import Codes.Model.Account;
import Codes.Model.DataBase;
import Codes.Model.Print;

public class AccountFriends implements Print<Account>{
   
    public boolean Request(Account acc, String User, DataBase data){
        for (Account account : data.getAccounts()) {
            if (account.getUsername().equals(User)) {
                account.getFriendsRequest().add(acc);
                return true;
            }
        }
        return false;
    }

    public boolean removeRequest(Account acc, String User, DataBase data){
        for (Account account : data.getAccounts()) {
            if (account.getUsername().equals(User)) {
                acc.getFriendsRequest().remove(account);
                return true;
            }
        }
        return false;
    }

    public boolean addFriend(Account acc, Account acc2){
        acc2.getFriends().add(acc);
        acc.getFriends().add(acc2);
        return true;
    }
    
    public boolean removeFriend(Account acc, String User){
        for (Account account : acc.getFriends()) {
            if (account.getUsername().equals(User)) {
                acc.getFriends().remove(account);
                account.getFriends().remove(acc);
                return true;
            }
        }
        return false;
    }

    @Override
    public void Show(Account acc){
        for (int index = 0; index < acc.getFriends().size(); index++) {
            Account account = acc.getFriends().get(index);
            System.out.println(index + " - " + account.getName() + ": @" + account.getUsername());      
        }
    }
}
