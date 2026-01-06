package com.Tattva.businessLogic;
import com.Tattva.dao.daoImpl.UserDaoImpl;
import com.Tattva.utility.RoleRegulator;
import com.Tattva.Models.User;
import java.util.Scanner;


public class UserService implements RoleRegulator{
    @Override
    public boolean displayRoleSpecificOptions(int option) {
        Scanner sc = new Scanner(System.in);
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        User user = new User();
        switch(option){
            case 1 :
                System.out.println("Please Enter the following details for Sign Up");
                System.out.print("First Name :: " );
                user.setFirstName(sc.next());
                System.out.print("Last Name :: ");
                user.setLastName(sc.next());
                System.out.print("Username :: ");
                user.setUsername(sc.next());
                System.out.print("Password (must contain atleast 8 digits) :: ");
                user.setPassword(sc.next());
                System.out.print("City :: ");
                user.setCity(sc.next());
                System.out.print("Mail Id :: ");
                user.setMailId(sc.next());
                System.out.print("Mobile Number :: ");
                user.setMobileNumber(sc.next());

                // send this data to database

                boolean userRegistrationSuccess = userDaoImpl.userRegistration(user);
                return userRegistrationSuccess;

            case 2:
                User user1 = new User();
                System.out.println("Please enter valid credentials for Login");
                System.out.print("Username :: ");
                user1.setUsername(sc.next());
                System.out.print("Password :: ");
                user1.setPassword(sc.next());
                // call method
                userDaoImpl.userLogin(user1);
                break;
            case 3:
                System.out.println("----------------------------------------------------------------------------");
                userDaoImpl.viewProductList();
                System.out.println("----------------------------------------------------------------------------");


                break;

            case 4:
                System.out.println("Please provide following details");
                System.out.println("--------------------------------------");
                System.out.print("User Id :: ");
                int userId = sc.nextInt();
                System.out.print("Product Id :: ");
                int productId = sc.nextInt();
                System.out.print("Quantity :: ");
                int quantity = sc.nextInt();
                System.out.println("--------------------------------------");
                boolean addedToCart = userDaoImpl.addToCart(userId,productId,quantity);
                return addedToCart;

            case 5:
                System.out.print("Please provide your UserId :: ");
                userDaoImpl.viewCart(sc.nextInt());
                break;

            case 6:
                System.out.println("Please provide following details");
                System.out.print("User Id :: ");
                int userid = sc.nextInt();
                System.out.print("User Name :: ");
                String userName = sc.next();
                sc.nextLine();
                System.out.print("Address :: ");
                String address = sc.nextLine();
                userDaoImpl.purchaseItem(userid, userName, address);

        }

        return false;
    }

}
