package com.Tattva.businessLogic;

import com.Tattva.dao.daoImpl.AdminDaoImpl;
import com.Tattva.dao.AdminDao;
import com.Tattva.exception.InvalidInputException;
import com.Tattva.models.Product;
import com.Tattva.utility.RoleRegulator;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;
public class AdminService implements RoleRegulator {


    @Override
    public boolean displayRoleSpecificOptions(int option) {
        AdminDaoImpl admin = new AdminDaoImpl();
        Scanner sc = new Scanner(System.in);
        switch (option){
            case 7:
                try {
                    System.out.print("Enter Admin Name :: ");
                    String adminName = sc.next();
                    System.out.print("Enter Password :: ");
                    String password = sc.next();
                    boolean loginResult = admin.adminLogin(adminName, password);
                    if (loginResult) {
                        Product product = new Product();
                        System.out.println("Enter Product Details");
                        System.out.print("Product ID >> ");
                        product.setProductId(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Product Name >> ");
                        product.setProductName(sc.nextLine());
                        System.out.print("Product Description >> ");
                        product.setProductDescription(sc.nextLine());
                        System.out.print("Product Quantity >> ");
                        product.setAvailableQuantity(sc.nextInt());
                        System.out.print("Product Price >> ");
                        product.setPrice(sc.nextDouble());
                        admin.addProductItem(product);
                    }
                    break;
                }catch (Exception e){
                    throw new InvalidInputException(e.getMessage());
                }
            case 8:
                try {
                    System.out.print("Enter Admin Name :: ");
                    String adminName = sc.next();
                    System.out.print("Enter Password :: ");
                    String password = sc.next();

                    boolean loginResult = admin.adminLogin(adminName, password);
                    if (loginResult) {
                        System.out.print("Enter User Id >> ");
                        double result = admin.calculateBill(sc.nextInt());
                        System.out.println("Total Bill >> " + result);
                    } else{
                        System.out.println("Invalid Credentials");
                    }
                    break;
                }catch (Exception e){
                    throw new InvalidInputException(e.getMessage());
                }

            case 9:
                try {
                    System.out.print("Enter Admin Name :: ");
                    String adminName = sc.next();
                    System.out.print("Enter Password :: ");
                    String password = sc.next();
                    boolean loginResult = admin.adminLogin(adminName, password);
                    if (loginResult) {
                        System.out.print("Enter User Id >> ");
                        admin.displayAmountToUser(sc.nextInt());
                    }
                    break;
                }catch (Exception e){
                    throw new InvalidInputException(e.getMessage());
                }

            case 10:
                try {
                    System.out.print("Enter Admin Name :: ");
                    String adminName = sc.next();
                    System.out.print("Enter Password :: ");
                    String password = sc.next();
                    boolean loginResult = admin.adminLogin(adminName, password);
                    if (loginResult) {
                        System.out.print("Enter Product Id >> ");
                        admin.checkQuantity(sc.nextInt());
                    }
                    break;
                }catch (Exception e){
                    throw new InvalidInputException(e.getMessage());
                }

            case 11:
                try {
                    System.out.print("Enter Admin Name :: ");
                    String adminName = sc.next();
                    System.out.print("Enter Password :: ");
                    String password = sc.next();
                    boolean loginResult = admin.adminLogin(adminName, password);
                    if (loginResult) {
                        System.out.println("👉Registered User List 👈");
                        admin.checkRegisteredUserList();
                    }
                    break;
                }catch (Exception e){
                    throw new InvalidInputException(e.getMessage());
                }

            case 12:
                try {
                    System.out.print("Enter Admin Name :: ");
                    String adminName = sc.next();
                    System.out.print("Enter Password :: ");
                    String password = sc.next();
                    boolean loginResult = admin.adminLogin(adminName, password);
                    if (loginResult) {
                        System.out.print("Enter Username >> ");
                        admin.checkParticularUserHistory(sc.next());
                    }
                    break;
                }catch (Exception e){
                    throw new InvalidInputException(e.getMessage());
                }
        }
        return false;
    }
}
