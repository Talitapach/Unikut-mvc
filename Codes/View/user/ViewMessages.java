package Codes.View.user;

import java.util.InputMismatchException;
import java.util.Scanner;

import Codes.Controller.Friend;
import Codes.Controller.Message;
import Codes.Model.entities.Comment;
import Codes.Model.entities.Singleton;
import Codes.Model.entities.User;
import Codes.Model.utils.date.Datee;
import Codes.View.design.ViewInterface;

public class ViewMessages {
    private static Scanner s = new Scanner(System.in);
    
    public static void sendMessages(String userName){
        System.out.println("\n");
        if(Singleton.searchUser(userName).getFriends().isEmpty()) {
            System.out.println("You have no friends to text");
        }else{
            System.out.println("Enter the username you want to send a message");
            String userSendMessage = s.next();
            while (userSendMessage.equals(userName) || Friend.searchFriend(userName, userSendMessage) == false){
                if(userSendMessage.equals(userName)){
                    System.out.println("you can't message yourself");
                    userSendMessage = s.next();  
                }else if(Friend.searchFriend(userName, userSendMessage) == false){
                    System.out.println(userSendMessage + " is not on your friends list, write a valid user");
                    userSendMessage = s.next();  
                }
            }
            addMessage(userName, userSendMessage);
        }
    }
    


    public static void addMessage(String userName, String userSendMessage){
            String date = Datee.calendar();
            System.out.println(date + "\n"+ "Type message");
            String message = s.nextLine();
            message = s.nextLine();
            message = date + "\n" +"  @" + userName + " : " + message;
    
            Comment comment = new Comment(message);
            Message.addMessage(userName, userSendMessage, comment);
            System.out.println("You've just sent a message to " + userSendMessage);
    }



    public static void viewMessages(String userName){
        System.out.println("\n");
        System.out.println("MESSAGES");
        System.out.println(" ");
        if(Singleton.searchUser(userName).getMessages().isEmpty()) {
            System.out.println("You have no messages");
        }else if(!Singleton.searchUser(userName).getMessages().isEmpty()){
            for (int i = 0; i < Singleton.searchUser(userName).getMessages().size(); i++) {
                User accountMessage = Singleton.searchUser(userName).getFriends().get(i);
                Comment comment = Singleton.searchUser(userName).getMessages().get(i); 
                System.out.println(comment);
            
            
                String message[] = comment.getText().split("@|\n|:");
            
                for(User friend: Singleton.searchUser(userName).getFriends()){
                    if(friend.equals(message[3])){
                        accountMessage = friend;
                    }
                }
                System.out.println("Do you want to respond " + accountMessage.getUserName() + " ? yes/no");
                String acception = s.next();
                while (!acception.equals("yes") && !acception.equals("no")) {
                    System.out.println("Invalid option, choose a valid one");
                    acception = s.next();
                }
                if (acception.equalsIgnoreCase("yes")) {
                    addMessage(userName, accountMessage.getUserName());
                }else{
                    System.out.println("finished conversation");
                } 
                Message.removeMessage(userName, accountMessage.getUserName(), comment);  
            }
        }
    }    


    public static void homeScreenMessages(String userName){
        int option;
        System.out.println("\n");
        ViewInterface.homeMessages();
        option = s.nextInt();
        
        while (option < 1 || option > 3) {
            ViewInterface.homeMessages();
            option = s.nextInt();
        }
        try{
            switch (option) {
                case 1:
                    ViewMessages.sendMessages(userName);
                    System.out.println("\n");
                    break;
                case 2:
                    ViewMessages.viewMessages(userName);
                    System.out.println("\n");
                    break;
                case 3:
                    break;
            }
         }catch(InputMismatchException ex){
            System.out.println("You have entered a different type of read");
            System.out.println("Critical error has occored");
            System.out.println(" :C ");
        }
    }
}
