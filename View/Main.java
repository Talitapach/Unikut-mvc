package View;

import java.util.Scanner;

import Model.User;

public class Main{
    public static void main(String[] args) {
        int option, option2;
        Scanner s = new Scanner(System.in);
        System.out.println("  _    _       _ _          _   \n" +
        " | |  | |     (_) |        | |  \n" +
        " | |  | |_ __  _| | ___   _| |_ \n" +
        " | |  | | '_ \\| | |/ / | | | __|\n" +
        " | |__| | | | | |   <| |_| | |_ \n" +
        "  \\____/|_| |_|_|_|\\_\\\\__,_|\\__|");
        System.out.println("");
        System.out.println("Wellcome :)");
        System.out.println("Please, choose a option");
        System.out.println("1 - Login");
        System.out.println("2 - Sign up");
        option = s.nextInt();
        switch(option) {
            case 1:
              System.out.println("login");
              break;
            case 2:
                System.out.println("Create a Username");
                String username = s.next();
                System.out.println("Create a password");
                String password = s.next();
                System.out.println("Type your name");
                String name = s.next();
                User newUser = new User(username, password, name);
              break;
            default:
              // code block
          }
    }

}