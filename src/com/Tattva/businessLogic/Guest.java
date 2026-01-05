package com.Tattva.businessLogic;

import com.Tattva.Exception.InvalidInputException;
import com.Tattva.dao.daoImpl.GuestDaoImpl;
import com.Tattva.utility.Options;
import com.Tattva.utility.RoleRegulator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Guest extends RoleRegulator {
    @Override
    public boolean displayRoleSpecificOptions(int option) {
        try {
            Scanner sc = new Scanner(System.in);
            GuestDaoImpl guestObj = new GuestDaoImpl();
            if (option == 14) {
                Options.guestOptions();
                System.out.print("Enter Option :: ");
                int input = sc.nextInt();
                guestObj.viewProduct(input);
                System.out.println("To buy products, please do UserLogic registration");
            }
        }
        catch(InputMismatchException e){
            throw new InvalidInputException("Please provide valid input from the above list");
        }
        return false;
    }
}
