package Codes.View;

import java.util.Calendar;
import java.util.Date;

public class Design {
    
    public void interfaceInicial(){
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
        System.out.println("3 - Finish Program");
    }

    public void interfaceLogin(){
        Date data = new Date();
        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        if (hora >= 6 && hora <= 12) {
            System.out.println("Morning! :D");
        }
        if (hora > 12 && hora < 18) {
            System.out.println("Good evening! :D");
        }
        if (hora >= 18 && hora < 6) {
            System.out.println("Night! :D");
        }   
        System.out.println(data);
        System.out.println("1 - Edit your account");
        System.out.println("2 - Add a new friend");
        System.out.println("3 - Send message");
        System.out.println("4 - View messages");
        System.out.println("5 - Requests");
        System.out.println("6 - Remove a friend");
        System.out.println("7 - FriendList");
        System.out.println("8 - Log out");
    }
}
