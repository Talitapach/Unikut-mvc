package Codes.Controller;

import Codes.Model.entities.Singleton;
import Codes.Model.entities.User;

public class Login{
    public static boolean verificationLogin(String user, String password){
        Singleton.getInstance();
        for (User users: Singleton.getAccounts()) {
            if (users.getUserName().equalsIgnoreCase(user) && users.getPassword().equals(password)) {
                users.setName(users.getName());
                return true;
            }
        }
        return false;
    }

    public static User getUsers(String user, String password){
        Singleton.getInstance();
        for (User users: Singleton.getAccounts()) {
            if (users.getUserName().equals(user) && users.getPassword().equals(password)) {
                return users;
            }
        }
        return null;
    }
}
