package Codes.View.design;

import Codes.Model.utils.date.Datee;

public class ViewInterface {
    public static void Login(){
        System.out.println("  _    _       _ _          _   \n" +
        " | |  | |     (_) |        | |  \n" +
        " | |  | |_ __  _| | ___   _| |_ \n" +
        " | |  | | '_ \\| | |/ / | | | __|\n" +
        " | |__| | | | | |   <| |_| | |_ \n" +
        "  \\____/|_| |_|_|_|\\_\\\\__,_|\\__|");
        System.out.println("");
        System.out.println("Wellcome");
        System.out.println("Please, choose a option");
        System.out.println("1 - Login");
        System.out.println("2 - Sign up");
        System.out.println("3 - Finish Program");
    }


    public static void homeScreen(){
        System.out.println(Datee.calendar());
        System.out.println("1 - Configurations");
        System.out.println("2 - Perfil");
        System.out.println("3 - Friends");
        System.out.println("4 - Messages");
        System.out.println("5 - Requests");
        System.out.println("6 - Posts");
        System.out.println("7 - Log out");
    }

    public static void homeFriends(){
        System.out.println(Datee.calendar());
        System.out.println("1 - Add a new friend");
        System.out.println("2 - Remove a friend");
        System.out.println("3 - FriendList");
        System.out.println("4 - EXIT");
    }

    public static void homeMessages(){
        System.out.println(Datee.calendar());
        System.out.println("1 - Send message");
        System.out.println("2 - View messages");
        System.out.println("3 - EXIT");
    }

    public static void homePosts(){
        System.out.println(Datee.calendar());
        System.out.println("1 - Create post");
        System.out.println("2 - Delete post");
        System.out.println("3 - EXIT");
    }

    public static void configuration(){
        System.out.println("Menu Configuration");
        System.out.println("1 - Change your Name");
        System.out.println("2 - Change Your UserName");
        System.out.println("3 - Chage your Password");
        System.out.println("4 - Delete your Account");
        System.out.println("5 - EXIT");
    }
}
