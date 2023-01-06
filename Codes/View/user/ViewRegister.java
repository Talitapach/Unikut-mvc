package Codes.View.user;

import java.util.Scanner;

import Codes.Model.entities.AdminUser;
import Codes.Model.entities.CommonUser;
import Codes.Model.entities.Singleton;
import Codes.Model.utils.validation.PasswordValidation;
import Codes.Model.utils.validation.UserNameValidation;

public class ViewRegister {
    private static Scanner s = new Scanner(System.in);

    public static void Register(){
        Singleton.getInstance();
        Singleton.getInstanceAdm();
        Singleton.getInstanceCommon();
        System.out.print("Create a Username: ");
        String userName = s.next().toLowerCase();

        while(UserNameValidation.Validation(userName)){
            System.out.println("This username already exist, try a new one");
            userName = s.next().toLowerCase();
        }
            
        System.out.print("Create a password: ");
        String password = s.next();
        while(PasswordValidation.Validation(password) == false){
            System.out.println("Must Have at least 6 characteres");
            System.out.println("The password must contain an uppercase letter, a number and a minimum number of 6 digits");
            password = s.next();
        }
                    
                
        System.out.print("Tell your name: ");
        String name = s.nextLine().toLowerCase();
        name = s.nextLine().toLowerCase();

        System.out.println("Are you an admin? ");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        int option;
        option = s.nextInt();
        if(option == 1){
          AdminUser user = new AdminUser(name, userName, password);
          Singleton.addAdm(user.getResult());
        }else {
          CommonUser user = new CommonUser(name, userName, password);
          Singleton.addCommonUser(user.getResult());
          // Singleton.addCommonUser(new Common(name, userName, password, false));
        }

        // Singleton.add(new User(name, userName, password));
        System.out.println("Account created!");
    }
}
