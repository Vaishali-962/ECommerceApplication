package com.Tattva;
import com.Tattva.Models.User;
import com.Tattva.businessLogic.UserService;
import com.Tattva.utility.initialMessage;
import com.Tattva.utility.Options;
import com.Tattva.businessLogic.GuestService;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GuestService guestService = new GuestService();
        User user1 = new User();
        boolean isLoggedIn = false;
        UserService userLogic = new UserService();
        int input;

        try {
            initialMessage.initialMessage();
            Options.generalOptions();
            System.out.print("Enter Option :: ");
            input = sc.nextInt();
            while(input != 0){
                if(input == 1){
                    userLogic.displayRoleSpecificOptions(1);
                    System.out.println("Login >> Press 2");
                    System.out.print("ENTER :: ");
                    input = sc.nextInt();
                }
                if (input == 2){
                    userLogic.displayRoleSpecificOptions(2);
                    System.out.println("Choice Option from given list");
                    System.out.print("ENTER :: ");
                    input = sc.nextInt();
                }
                if(input == 3){
                    userLogic.displayRoleSpecificOptions(3);
                    System.out.println("Add items to Cart >> Press 4");
                    System.out.println("To view the cart >> Press 5");
                    System.out.print("ENTER :: ");
                    input = sc.nextInt();
                }
                if(input == 4){
                    userLogic.displayRoleSpecificOptions(4);
                    System.out.println("To view the cart >> Press 5");
                    System.out.println("To exit the application >> Press 0");
                    System.out.print("ENTER :: ");
                    input = sc.nextInt();
                }
                if(input == 5){
                    userLogic.displayRoleSpecificOptions(5);
                    System.out.println("To View Product list >> Press 3");
                    System.out.println("To buy all products from cart :: Press 6");
                    System.out.println("To exit the application >> Press 0");
                    System.out.print("ENTER :: ");
                    input = sc.nextInt();
                }
                if(input == 6){
                    userLogic.displayRoleSpecificOptions(6);
                    System.out.println("To View Product list >> Press 3");
                    System.out.println("To exit the application >> Press 0");
                    System.out.print("ENTER :: ");
                    input = sc.nextInt();
                }
                if(input == 14){
                    guestService.displayRoleSpecificOptions(14);
                    System.out.print("ENTER :: ");
                    input = sc.nextInt();
                }
            }
            if(input == 0){
                System.out.println("🙏🏻 Thanks for Visiting Tattva 🙏🏻");
            }

        }catch(InputMismatchException e){
                System.out.println("🛑 Please Provide Valid Input");
        }
    }
}
