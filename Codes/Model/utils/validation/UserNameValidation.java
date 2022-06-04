package Codes.Model.utils.validation;

import Codes.Model.entities.Singleton;
import Codes.Model.entities.User;

public class UserNameValidation {
    public static boolean Validation(String userName){
        if (!Singleton.isEmpty()){
            for (User user : Singleton.getAccounts()) {
                if(user.getUserName().equalsIgnoreCase(userName)){
                    return true;
                }
            }
        }
        return false;
    }
}
