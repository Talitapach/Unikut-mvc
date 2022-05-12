package Codes.View;
import java.util.InputMismatchException;
import java.util.Scanner;

import Codes.Controller.AccountFriends;
import Codes.Controller.AccountMessage;
import Codes.Controller.DataBaseEdit;
import Codes.Controller.DataBaseLogin;
import Codes.Model.Account;
import Codes.Model.DataBase;

public class Main{
    public static void main(String[] args) {
        
        //Objects
        Design interfaceUnikut = new Design();
        DataBase data = new DataBase();
        DataBaseLogin login = new DataBaseLogin();
        DataBaseEdit edit = new DataBaseEdit();
        AccountFriends friends = new AccountFriends();
        AccountMessage messages = new AccountMessage(); 

        int option, option2;
        Scanner s = new Scanner(System.in);
        try {
          do {
            interfaceUnikut.interfaceInicial();
            option = s.nextInt();
            switch(option) {
                case 1:
                while (data.getAccounts().isEmpty()) {
                  interfaceUnikut.interfaceInicial();
                  option = s.nextInt();
                }
                System.out.print("Username: ");
                String user = s.next();
                System.out.print("Password: ");
                String pass = s.next();
                boolean b = login.Login(user, pass, data);
                Account acc = login.getAccount(user, pass, data);
                if (b) {
                    System.out.println("Welcome back " + data.getAccountName() + " :D");
                    do{
                        if (!acc.getFriendsRequest().isEmpty()) {
                            System.out.println("You have some new friend requests check your requests");
                        }
                        if (!acc.getMessagesAccounts().isEmpty()) {
                            System.out.println("You have some new messages");
                        }
                        interfaceUnikut.interfaceLogin();
                        option2 = s.nextInt();
                        while (option2 < 1 || option2 > 8) {
                            interfaceUnikut.interfaceLogin();
                            option2 = s.nextInt();
                        }
                        switch (option2) {
                            case 1:
                                System.out.println("What do you want to change");
                                System.out.println("1 - Name | 2- Username | 3 - Password ");
                                int option3 = s.nextInt();
                                while (option3 < 1 || option3 > 3) {
                                    System.out.println("Invalid option, choose a valid one");
                                    System.out.println("1 - Name | 2- Username | 3 - Password ");
                                    option3 = s.nextInt();
                                }
                                if (option3 == 1) {
                                    System.out.println("Tell your new name");
                                    String newName = s.next();
                                    System.out.println(edit.EditAccount(newName, user, pass, option3, data));
                                }else if (option3 == 2) {
                                    System.out.println("Tell your new User");
                                    String newUser = s.next();
                                    System.out.println(edit.EditAccount(newUser, user, pass, option3, data));
                                }else if (option3 == 3) {
                                    System.out.println("Tell your new pass");
                                    String newPass = s.next();
                                    System.out.println(edit.EditAccount(newPass, user, pass, option3, data));
                                }
                                break;
                            case 2:    
                                if (acc.getFriends().size() > 24) {
                                    System.out.println("You have reached the limit of friends");
                                    break;
                                }
                                System.out.println("Tell the Username you want to add");
                                String userToAdd = s.next();
                                while (userToAdd.equals(acc.getUsername())) {
                                    System.out.println("You can't request yourself as a friend, write a valid user");
                                    userToAdd = s.next();
                                }
                                boolean f = friends.Request(acc, userToAdd, data);
                                if (f) {
                                    System.out.println("You have sent a request to " + userToAdd);
                                }else{
                                    System.out.println("User does not exist");
                                }
                                break;
                            case 3:
                                if (acc.getFriends().isEmpty()) {
                                    System.out.println("You have no friends to text");
                                }else{
                                    System.out.println("Enter the username you want to send a message");
                                    String userSendMessage = s.next();
                                    System.out.println("Type message");
                                    String message = s.nextLine();
                                    message = s.nextLine();
                                    message = message + " sent by " + acc.getUsername();
                                    Boolean m = messages.Message(acc, userSendMessage, data, message);
                                    if(m){
                                        System.out.println("You've just sent a message"); 
                                    }
                                    break;
                            }
                            case 4:
                                if (acc.getMessagesAccounts().isEmpty()) {
                                    System.out.println("You have no messages");
                                }else{
                                    messages.Show(acc);
                                    acc.getMessagesAccounts().clear();
                                }
                                break; 
                            case 5:
                                while (!acc.getFriendsRequest().isEmpty()) {
                                    Account accountRequest = new Account();
                                    for (int i = 0; i < acc.getFriendsRequest().size(); i++) {
                                        accountRequest = acc.getFriendsRequest().get(i); 
                                        System.out.println(accountRequest.getUsername() + " Has sent u a friend request");
                                        System.out.println("Do you want to accept " + accountRequest.getUsername() + " as your friend? yes/no");
                                        String acception = s.next();
                                        while (!acception.equals("yes") && !acception.equals("no")) {
                                            System.out.println("Invalid option, choose a valid one");
                                            acception = s.next();
                                        }
                                        if (acception.equals("yes") && acc.getFriends().size()> 24){
                                            System.out.println("You can't accept because you have passed friend limit");
                                            break;
                                        }else if (acception.equals("yes")) {
                                            friends.addFriend(accountRequest, acc);
                                            System.out.println("Now you and " + accountRequest.getUsername() + " are friends");
                                        }else{
                                            System.out.println("You have not accepted " + accountRequest.getUsername() + " request");
                                        } 
                                        friends.removeRequest(acc, accountRequest.getUsername(), data);  
                                    }
                                    
                                }   
                                break;
                            case 6:
                                if (acc.getFriends().isEmpty()) {
                                    System.out.println("You can't delete if you don't have any added friends");
                                    break;
                                }
                                System.out.println("Tell the user you want to delete");
                                String userToDelete = s.next();
                                friends.removeFriend(acc, userToDelete);
                                break;
                            case 7:   
                                if (acc.getFriends().isEmpty()) {
                                    System.out.println("You have no friends");
                                }else{
                                    friends.Show(acc);
                                }
                                break; 
                            case 8:
                                System.out.println("See ya :D"); 
                        }
                    }while (option2 != 8);
                }else{
                    System.out.println("You have entered a invalid username or password");
                    
                }
                break;
                
                case 2:
                    System.out.println("Create a Username");
                    String username = s.next();
                    if (!data.getAccounts().isEmpty()){
                      for (Account ac : data.getAccounts()) {
                          while (ac.getUsername().equals(username)) {
                              System.out.println("This username already exist, try a new one");
                              username = s.next();
                          }
                      }
                    }
                    System.out.println("Create a password");
                    String password = s.next();
                    System.out.println("Type your name");
                    String name = s.nextLine();
                    name = s.nextLine();
                    Account newAccount = new Account (username, password, name);
                    Thread a = new Thread(new DataBase(newAccount, data));
                    a.start();
                    try {
                        a.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                  break;

              case 3: 
              break;
            }
          } while (option != 3);

        }catch(InputMismatchException ex){
          System.out.println("You have entered a different type of read");
          System.out.println("Critical error has occored");
          System.out.println(" :C ");
      }
      finally{
          s.close();
          System.out.println("Finishing program, please restart it");
      }
    }

}