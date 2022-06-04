package Codes.View.configuration;

import java.util.InputMismatchException;
import java.util.Scanner;

import Codes.Model.entities.Singleton;
import Codes.View.design.ViewInterface;



public class ViewConfiguration {
    private static Scanner s = new Scanner(System.in);
    
    public static void Configuration(String userName, String password){
        System.out.println("\n");
        Singleton.getInstance();
        ViewInterface.configuration();
        int option = s.nextInt();
        
        while (option < 1 || option > 5) {
            System.out.println("Invalid option, choose a valid one");
            option = s.nextInt();
        }

        try{
            do{
                switch (option) {
                    case 1:
                        System.out.print("Tell your new Name: ");
                        String newName = s.next();
                        Singleton.EditAccount(newName, userName, password, option);
                        System.out.println("Name successfully changed");
                        break;
                    case 2:
                        System.out.print("Tell your new UserName: ");
                        String newUser = s.next();
                        Singleton.EditAccount(newUser, userName, password, option);
                        System.out.println("Username successfully changed");
                        break;
                    case 3:
                        System.out.print("Tell your new Password: ");
                        String newPass = s.next();
                        Singleton.EditAccount(newPass, userName, password, option);
                        System.out.println("Password successfully changed");
                        break;
                    case 4:
                        System.out.println("Are you sure you want to delete your account? s/n");
                        char op = s.next().charAt(0);
                        if(op == 's'){
                            Singleton.remove(userName);
                            System.out.println("Account deleted successfully!");
                        }else{
                            System.out.println("See ya");
                        }
                        break;
                    case 5:
                        break;
                }
            }while(option != 1 && option != 2 && option != 3 && option != 4 && option != 5);
        }catch(InputMismatchException ex){
            System.out.println("You have entered a different type of read");
            System.out.println("Critical error has occored");
            System.out.println(" :C ");
        }
        System.out.println("\n");
    }
}
