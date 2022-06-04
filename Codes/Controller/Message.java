package Codes.Controller;

import Codes.Model.entities.Comment;
import Codes.Model.entities.Singleton;
import Codes.Model.entities.User;

public class Message extends Comment{

    public static void addMessage(String userName, String userName2, Comment message){
        for (User user : Singleton.searchUser(userName).getFriends()) {
            if (user.getUserName().equals(userName2)) {
                Singleton.searchUser(userName2).getMessages().add(message);
            }
        }
    }

    public static void removeMessage(String userName, String userName2, Comment message){
        for (User user : Singleton.searchUser(userName).getFriends()) {
            if (user.getUserName().equals(userName2)) {
                Singleton.searchUser(userName).getMessages().remove(message);
            }
        }
    }
}
