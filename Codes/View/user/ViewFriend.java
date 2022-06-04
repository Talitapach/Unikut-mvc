package Codes.View.user;

import java.util.InputMismatchException;
import java.util.Scanner;

import Codes.Controller.Friend;
import Codes.Model.entities.Singleton;
import Codes.Model.entities.User;
import Codes.View.design.ViewInterface;

public class ViewFriend {
    private static Scanner s = new Scanner(System.in);
    

    //HOME SCREEN FRIEND
    public static void homeScreenFriend(String userName){
        int option;
        System.out.println("\n");
        ViewInterface.homeFriends();
        option = s.nextInt();
        while (option < 1 || option > 4) {
            ViewInterface.homeFriends();
            option = s.nextInt();
        }
        try{
            switch (option) {
                case 1:
                    ViewFriend.addFriend(userName);
                    break;
                case 2:
                    ViewFriend.friendRemove(userName);
                    break;
                case 3:
                    ViewFriend.friendList(userName);
                    break;
                case 4:
                    break;
            }
        }catch(InputMismatchException ex){
            System.out.println("You have entered a different type of read");
            System.out.println("Critical error has occored");
            System.out.println(" :C ");
        }
    }




    //ADD FRIEND
    public static void addFriend(String userName){
        System.out.println("\n");
        if (Singleton.searchUser(userName).sizeFriends() > 24) {
            System.out.println("You have reached the limit of friends");
        }

        System.out.println("Tell the Username you want to add");
        String userToAdd = s.next();
        while (userToAdd.equals(userName) || Friend.searchFriend(userName, userToAdd)){
            if(Friend.searchFriend(userName, userToAdd)){
                System.out.println("You are already friends, write a valid user");
                userToAdd = s.next();  
            }else{
                System.out.println("You can't request yourself as a friend, write a valid user");
                userToAdd = s.next();  
            }
        }
        boolean f = Friend.addRequest(userName, userToAdd);
        if (f) {
            System.out.println("You have sent a request to " + userToAdd);
        }else{
            System.out.println("User does not exist");
        }           
    }




    //FRIEND REQUEST
    public static void friendsRequest(String userName){
        System.out.println("\n");
        System.out.println("REQUESTS");
        while (!Singleton.searchUser(userName).getFriendsRequest().isEmpty()){
            for (int i = 0; i < Singleton.searchUser(userName).getFriendsRequest().size(); i++) {
                User accountRequest = Singleton.searchUser(userName).getFriendsRequest().get(i); 
                System.out.println(accountRequest.getUserName() + " Has sent u a friend request");
                System.out.println("Do you want to accept " + accountRequest.getUserName() + " as your friend? yes/no");
                String acception = s.next();
                while (!acception.equals("yes") && !acception.equals("no")) {
                    System.out.println("Invalid option, choose a valid one");
                    acception = s.next();
                }
                if (acception.equalsIgnoreCase("yes") && Singleton.searchUser(userName).getFriends().size() > 24){
                    System.out.println("You can't accept because you have passed friend limit");
                    break;
                }else if (acception.equalsIgnoreCase("yes")) {
                    Friend.addFriend(accountRequest.getUserName(), userName);
                    System.out.println("Now you and " + accountRequest.getUserName() + " are friends");
                }else{
                    System.out.println("You have not accepted " + accountRequest.getUserName() + " request");
                } 
                Friend.removeRequest(accountRequest.getUserName(), userName);  
            } 
        }   
    }




    //FRIEND LIST
    public static void friendList(String userName){
        System.out.println("\n");
        System.out.println("FRIENDS");
        if (Singleton.searchUser(userName).getFriends().isEmpty()) {
            System.out.println("You have no friends");
        }else{
            Friend.Show(userName);
        }
    }




    //REMOVE A FRIEND
    public static void friendRemove(String userName){
        System.out.println("\n");
        if(Singleton.searchUser(userName).getFriends().isEmpty()) {
            System.out.println("You have no friends");
        }else{
            System.out.println("Tell the Username you want to remove");
            String userToRemove = s.next();
            while (userToRemove.equals(userName) || !Friend.searchFriend(userName, userToRemove)){
                if(!Friend.searchFriend(userName, userToRemove)){
                    System.out.println("You don't have this friend, write a valid user");
                    userToRemove = s.next();  
                }else{
                    System.out.println("You can't remove yourself as a friend, write a valid user");
                    userToRemove = s.next();  
                }
            }
            boolean f = Friend.removeFriend(userName, userToRemove);
            if (f) {
                System.out.println("You remove " + userToRemove);
            }else{
                System.out.println("User does not exist");
            }
        }
    }
}
