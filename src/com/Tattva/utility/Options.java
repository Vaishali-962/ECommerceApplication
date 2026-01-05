package com.Tattva.utility;

public class Options {
    public static void generalOptions(){
        System.out.println("|-> UserLogic Registration >> Press 1");
        System.out.println("|-> UserLogic Login >> Press 2");
        System.out.println("|-> Guest Mode >> Press 14");
        System.out.println("|-> Exit >> Press 0");
    }
    public static void userOptions(){
        System.out.println("|-> Product List >> Press 3");
        System.out.println("|-> Buy Product >> Press 4");
        System.out.println("|-> View Cart >> Press 5");
        System.out.println("|-> Generate Bill >> Press 6");
        System.out.println("|-> Add New Product >> Press 7");
    }
    public static void adminOptions(){
        System.out.println("|-> Calculate the Bill >> Press 8");
        System.out.println("|-> Display Amount to EndUser >> Press 9");
        System.out.println("|-> Check Product Quantity >> Press 10");
        System.out.println("|-> See Registered UserLogic >> Press 11");
        System.out.println("|-> View UserLogic History by Username>> Press 12");

    }
    public static void guestOptions(){
        System.out.println("|-> View Products >> Press 13");
    }
}
