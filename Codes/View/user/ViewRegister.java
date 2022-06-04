package Codes.View.user;

import java.util.Scanner;

import Codes.Model.entities.Singleton;
import Codes.Model.entities.User;
import Codes.Model.utils.validation.PasswordValidation;
import Codes.Model.utils.validation.UserNameValidation;

public class ViewRegister {
    private static Scanner s = new Scanner(System.in);

    public static void Register(){
        Singleton.getInstance();
        System.out.print("Create a Username: ");
        String userName = s.next();

        while(UserNameValidation.Validation(userName)){
            System.out.println("This username already exist, try a new one");
            userName = s.next();
        }
            
        System.out.print("Create a password: ");
        String password = s.next();
        while(PasswordValidation.Validation(password) == false){
            System.out.println("The password must contain an uppercase letter and a number");
            password = s.next();
        }
                    
                
        System.out.print("Tell your name: ");
        String name = s.next();

        Singleton.add(new User(name, userName, password));
        System.out.println("Account created!");
    }
}
