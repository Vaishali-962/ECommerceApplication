package com.Tattva;
import com.Tattva.Models.User;
import com.Tattva.businessLogic.UserLogic;
import com.Tattva.utility.initialMessage;
import com.Tattva.utility.Options;
import com.Tattva.businessLogic.Guest;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Guest guest = new Guest();
        User user1 = new User();
        boolean isLoggedIn = false;
        UserLogic userLogic = new UserLogic();
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
                    input = sc.nextInt();
                }
                if (input == 2){
                    userLogic.displayRoleSpecificOptions(2);
                    System.out.println("Choice Option from given list");
                    input = sc.nextInt();
                }
                if(input == 3){
                    userLogic.displayRoleSpecificOptions(3);
                    System.out.println("Add items to Cart >> Press 4");
                    System.out.println("To view the cart >> Press 5");
                    input = sc.nextInt();
                }
                if(input == 4){
                    userLogic.displayRoleSpecificOptions(4);
                    System.out.println("To view the cart >> Press 5");
                    input = sc.nextInt();
                }
                if(input == 5){
                    userLogic.displayRoleSpecificOptions(5);
                    break;
                }
            }
            if(input == 0){
                System.out.println("Thanks for Visiting Tattva");
            }

        }catch(InputMismatchException e){
                System.out.println("Please Provide Valid Input");
        }
    }
}
