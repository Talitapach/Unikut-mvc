package Codes.View.user;

import java.util.Scanner;

import Codes.Controller.Friend;
import Codes.Model.entities.Singleton;

public class ViewSearch {
    private static Scanner s = new Scanner(System.in);
    
    public static void search(String userName){
        System.out.println("\n");
        System.out.println("Enter the username you want to search");
        String userSearched = s.next();

        if(Singleton.searchUser(userSearched) == null){
            System.out.println("This user does not exist");
        }else if(userSearched.equals(userName)){
            System.out.println("you can't search yourself");
        }else{
            ViewPerfil.perfilUser(userSearched);
            System.out.println(" ");
            if(Friend.searchFriend(userName, userSearched)){
                System.out.println("you and " + userSearched + " are friends");
            }else{
                System.out.println("you and " + userSearched + " are not friends");
                System.out.println("do you want to be friends with " + userSearched + " ? yes/no");
                String acception = s.next();
                while (!acception.equals("yes") && !acception.equals("no")) {
                    System.out.println("Invalid option, choose a valid one");
                    acception = s.next();
                }
                if (acception.equalsIgnoreCase("yes")) {
                    boolean f = Friend.addRequest(userName, userSearched);
                    if (f) {
                        System.out.println("You have sent a request to " + userSearched);
                    }
                }else{
                    System.out.println("");
                }
            }
        }
    }
}
