package com.Tattva.utility;

public class Options {
    public static void generalOptions(){
        System.out.println("User Registration >> Press 1");
        System.out.println("User Login >> Press 2");
        System.out.println("Guest Mode >> Press 14");
        System.out.println("Admin Mode >> Press 15");
        System.out.println("Exit >> Press 0");
        System.out.println();
    }
    public static void userOptions(){
        System.out.println("Product List >> Press 3");
        System.out.println("Add to Cart >> Press 4");
        System.out.println("View Cart >> Press 5");
        System.out.println(" Purchase Items from Cart >> Press 6");
        System.out.println("Exit >> Press 0");
        System.out.println();
    }
    public static void adminOptions(){
        System.out.println("Add new product >> Press 7");
        System.out.println("Calculate the Bill using User ID >> Press 8");
        System.out.println("Display Amount to EndUser >> Press 9");
        System.out.println("Check Product Quantity >> Press 10");
        System.out.println("See Registered User >> Press 11");
        System.out.println("View History by Username>> Press 12");
        System.out.println("Exit >> Press 0");
        System.out.println();
    }
    public static void guestOptions(){
        System.out.println("View Products >> Press 13");
        System.out.println("Exit >> Press 0");
        System.out.println();
    }
}
