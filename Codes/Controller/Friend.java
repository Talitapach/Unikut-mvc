package Codes.Controller;

import java.util.Comparator;
import java.util.List;

import Codes.Model.entities.Singleton;
import Codes.Model.entities.User;

public class Friend extends User{

    public Friend(String name, String userName, String password){
        super(name, userName, password);
    }
    
    @Override
    public List<User> getFriends() {
        return super.getFriends();
    }
    @Override
    public List<User> getFriendsRequest() {
        return super.getFriendsRequest();
    }

    public static boolean addFriend(String userName, String userName2){
        Singleton.searchUser(userName).getFriends().add(Singleton.searchUser(userName2));
        Singleton.searchUser(userName2).getFriends().add(Singleton.searchUser(userName));
        return true;
    }
    
    public static boolean removeFriend(String userName, String userName2){
        for (User user : Singleton.getAccounts()) {
            if (user.getUserName().equals(userName)) {
                Singleton.searchUser(userName).getFriends().remove(Singleton.searchUser(userName2));
                Singleton.searchUser(userName2).getFriends().remove(Singleton.searchUser(userName));
                return true;
            }
        }
        return false;
    }

    public static boolean addRequest(String userName, String userName2){
        for (User user : Singleton.getAccounts()) {
            if (user.getUserName().equals(userName2)) {
                Singleton.searchUser(userName2).getFriendsRequest().add(Singleton.searchUser(userName));
                return true;
            }
        }
        return false;
    }

    public static boolean removeRequest(String userName, String userName2){
        for (User user : Singleton.getAccounts()) {
            if (user.getUserName().equals(userName)) {
                Singleton.searchUser(userName2).getFriendsRequest().remove(Singleton.searchUser(userName));
                return true;
            }
        }
        return false;
    }

    public static void Show(String userName){
        Comparator<User> comp = (u1, u2) -> u1.getName().toUpperCase().compareTo(u2.getName().toUpperCase());
        User user = Singleton.searchUser(userName);
        Singleton.searchUser(userName).getFriends().sort(comp);
        
        for (User userr : user.getFriends()) {
            System.out.println(userr.getName() + ": @" + userr.getUserName());      
        }
    }

    public static boolean searchFriend(String userName, String userName2){
        for(User user : Singleton.searchUser(userName).getFriends()){
            if(userName2.equals(user.getUserName())){
                return true;
            }
        }
        return false; 
    }
}
