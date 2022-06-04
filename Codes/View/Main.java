package Codes.View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Codes.Model.entities.Singleton;
import Codes.View.design.ViewInterface;
import Codes.View.user.ViewLogin;
import Codes.View.user.ViewRegister;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Singleton.getInstance();
        Singleton.getInstanceAdm();
        Singleton.getInstanceCommon();
        int option;
        try {
          do {
            ViewInterface.Login();
            option = s.nextInt();
            switch(option) {
                //LOGIN
                case 1:
                    ViewLogin.Login();
                    break;
                //REGISTER     
                case 2:
                    ViewRegister.Register();
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
