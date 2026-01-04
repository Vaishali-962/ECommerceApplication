package com.Tattva;
import com.Tattva.Exception.InvalidInputException;
import com.Tattva.Models.Guest;
import com.Tattva.Models.User;
import com.Tattva.utility.initialMessage;
import com.Tattva.utility.Options;
import com.Tattva.dao.daoImpl.GuestDaoImpl;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Guest guest = new Guest();
        User user = new User();
        try{
            initialMessage.initialMessage();
            Options.generalOptions();
            System.out.print("Enter Option :: " );
            int input = sc.nextInt();
            if(input == 14){
                guest.displayRoleSpecificOptions(input);
            }
        }catch(InputMismatchException e){
            System.out.println("Please Provide Valid Input");
        }
    }
}
