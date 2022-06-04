package Codes.Model.utils.validation;

public class PasswordValidation {
    public static boolean Validation(String pass){
        final String required = "^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*)$";
        final String allowed = "[a-zA-Z0-9]+";
        if(pass.length() >=6 && pass.length() <= 20 && pass.matches(allowed) && pass.matches(required)){
            return true;
        }else{
            return false;
        }
    }
}
