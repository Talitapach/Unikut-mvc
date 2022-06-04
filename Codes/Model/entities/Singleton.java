package Codes.Model.entities;

import java.util.ArrayList;
import java.util.List;

public final class Singleton extends User{
    private static List<User> accounts;

   
    public Singleton(String name, String userName, String password, boolean admin) {
        super(name, userName, password, admin);
    }
    
    public static List<User> getAccounts() {
        return accounts;
    }


    public static boolean add(User user){
        return accounts.add(user);
    }

    public static boolean addFriends(User user){
        return accounts.add(user);
    }


    public static void remove(String userName){
        accounts.remove(searchUser(userName));
    } 

    public static boolean isEmpty(){
        return accounts.isEmpty();
    } 
    
    public static User searchUser(String userName){
        for(User user : accounts){
            if(userName.equals(user.getUserName())){
                return user;
            }
        }
        return null;
    } 

    public static List<User> getInstance() {
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        return accounts;
    }

    public static boolean EditAccount(String edit, String userName, String password, int i){
        getInstance();
        for (User user: Singleton.getAccounts()) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                switch (i) {
                    case 1:
                        user.setName(edit);
                        break;
                    case 2:
                        user.setUserName(edit);
                        break;
                    case 3:
                        user.setPassword(edit);
                        break;
                }         
                return true;
            }
        }
        return false;
    }

}
