package Codes.View.user;

import java.util.InputMismatchException;
import java.util.Scanner;

import Codes.Controller.Login;
import Codes.Model.entities.Singleton;
import Codes.View.configuration.ViewConfiguration;
import Codes.View.design.ViewInterface;

public class ViewLogin {
    private static Scanner s = new Scanner(System.in);
    public static void Login(){
        int option;

        System.out.print("Username: ");
        String userName = s.next();
        System.out.print("Password: ");
        String password = s.next();
        boolean b = Login.verificationLogin(userName, password);
        try{
            if (b) {
                System.out.println("\n");
                System.out.println("Wellcome back " + Singleton.searchUser(userName).getName() + "!");
                do{
                    if (!Singleton.searchUser(userName).getFriendsRequest().isEmpty()) {
                        System.out.println("You have some new requests, check your requests");
                    }
                    if (!Singleton.searchUser(userName).getMessages().isEmpty()) {
                        System.out.println("You have some new messages, check your messages");
                    }
                    ViewInterface.homeScreen();
                    option = s.nextInt();
                    while (option < 1 || option > 7) {
                        ViewInterface.homeScreen();
                        option = s.nextInt();
                    }
                    switch(option) {
                        case 1:
                            ViewConfiguration.Configuration(userName, password);
                            System.out.println("\n");
                            break;
                        case 2:    
                            ViewPerfil.perfilUser(userName);
                            System.out.println("\n");
                            break;
                        case 3:
                            ViewFriend.homeScreenFriend(userName);
                            System.out.println("\n");
                            break;
                        case 4:
                            ViewMessages.homeScreenMessages(userName);
                            System.out.println("\n");
                            break;
                        case 5:
                            ViewFriend.friendsRequest(userName);
                            System.out.println("\n");
                            break;
                        case 6:
                            ViewPosts.homeScreenPosts(userName);
                            System.out.println("\n");
                            break;
                        case 7:
                            break;

                    }
                }while(option != 7 && option != 1); 
            }else{
                System.out.println("You have entered a invalid username or password");
            }
        
        }catch(InputMismatchException ex){
            System.out.println("You have entered a different type of read");
            System.out.println("Critical error has occored");
            System.out.println(" :C ");
        }finally{
            System.out.println("See ya!");
        }
    }
}
