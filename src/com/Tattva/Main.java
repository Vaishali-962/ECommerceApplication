package com.Tattva;
import com.Tattva.businessLogic.AdminService;
import com.Tattva.businessLogic.UserService;
import com.Tattva.utility.initialMessage;
import com.Tattva.utility.Options;
import com.Tattva.businessLogic.GuestService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        startApplication();
    }


    private static void startApplication() {
        Scanner sc = new Scanner(System.in);
        GuestService guestService = new GuestService();
        AdminService adminService = new AdminService();
        UserService userLogic = new UserService();
        int input;

        try {
            initialMessage.initialMessage();
            Options.generalOptions();
            System.out.print("Enter Option :: ");
            input = sc.nextInt();
            while (input != 0 && !(input<0) && input<16 ) {
                switch (input) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        userLogic.displayRoleSpecificOptions(input);
                        input = getInput(sc);
                        break;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        adminService.displayRoleSpecificOptions(input);
                        input = getInput(sc);
                        break;
                    case 14:
                        System.out.println("🎉 Welcome to Guest Mode 🎉");
                        guestService.displayRoleSpecificOptions(14);
                        input = getInput(sc);
                        break;
                    case 15:
                        Options.adminOptions();
                        input = getInput(sc);
                        break;
                    default:
                        System.out.println("🛑 Please Provide Valid Details 🛑");
                        break;

                }
            }
            if(input == 0){
                System.out.println("🙏🏻 Thanks for Visiting Tattva 🙏🏻");
            }
            if(input > 15){
                System.out.println("🛑 Please Provide listed options 🛑");
            }
        }
        catch(InputMismatchException e){
                System.out.println("🛑 Please Provide Valid Input");
        }
    }

    private static int getInput(Scanner sc) {
        int input;
        System.out.print("ENTER Option :: ");
        input = sc.nextInt();
        return input;
    }
}
