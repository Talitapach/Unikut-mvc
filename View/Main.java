package View;

import java.util.Scanner;

import Model.User;

public class Main{
    public static void main(String[] args) {
        Access interfaceUnikut = new Access();
        int option, option2;
        Scanner s = new Scanner(System.in);
        interfaceUnikut.interfaceInicial();
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
                String name = s.nextLine();
                name = s.nextLine();
                User newUser = new User(username, password, name);
              break;
            default:
              // code block
          }
    }

}