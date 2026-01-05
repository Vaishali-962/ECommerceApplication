package com.Tattva.dao.daoImpl;

import com.Tattva.Exception.JDBCException;
import com.Tattva.Models.User;
import com.Tattva.dao.UserDao;
import com.Tattva.dataSourceConfig.DataSourceConfig;
import com.Tattva.utility.Options;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;


public class UserDaoImpl implements UserDao {
    // Queries
    // 1. UserLogic Registration Query
    public final String userRegistrationQuery =
            "INSERT INTO registered_user_details(first_name, last_name, user_name, password, city, mail_Id, mobileNumber) VALUES (?,?,?,?,?,?,?)";
    // 2. UserLogic Login Query
    public final String userLoginQuery = "SELECT user_id, user_name FROM registered_user_details WHERE user_name = ? AND password = ?";
    // 3. Product List Query
    public final String productListQuery = "SELECT * FROM products";

    // 5. viewCart
    public final String viewCartQuery = "SELECT * FROM cart WHERE user_id = ?";
    // 6. purchaseItem

    @Override
    public boolean userRegistration(User user) {
        try(Connection con = DataSourceConfig.getConnection(); PreparedStatement ps = con.prepareStatement(userRegistrationQuery)){
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getCity());
            ps.setString(6, user.getMailId());
            ps.setString(7, user.getMobileNumber());
            int result = ps.executeUpdate();
            if (result > 0){
            System.out.println("🎉User Registration is Successful 🎉");
            return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            throw new JDBCException("Failed to registration");
        }
    }

    @Override
    public boolean userLogin(User user) {
        try(Connection con = DataSourceConfig.getConnection(); PreparedStatement ps = con.prepareStatement(userLoginQuery)){
            ps.setString(1,user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                System.out.println("🎉 Logged-In Successful 🎉");
                int userId = resultSet.getInt("user_id");
                String username = resultSet.getString("user_name");

                System.out.println("****----****----****----****----****----****");
                System.out.println("🎊Welcome "+username+ " 🎊");
                System.out.println("📍 Your User ID is :: " + userId);
                System.out.println("****----****----****----****----****----****");
                System.out.println();
                Options.userOptions();
                return true;
            }else{
                System.out.println("Invalid Username and password!!");
                return false;
            }
        }catch(Exception e){
            System.out.println("Login failed due to system error" + e.getMessage());
        }
        return false;
    }

    @Override
    public void viewProductList() {
        try(Connection con = DataSourceConfig.getConnection(); PreparedStatement ps = con.prepareStatement(productListQuery)){
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()) {
            int productId = resultSet.getInt("product_id");
            String productName = resultSet.getString("product_name");
            String productDescription = resultSet.getString("product_description");
            int availableQuantity = resultSet.getInt("available_quantity");
            double price = resultSet.getDouble("price");

            System.out.println("Product Id >> " + productId);
            System.out.println("Product Name >> " + productName);
            System.out.println("Product Description >> " + productDescription);
            System.out.println("Available Quantity >> " + availableQuantity);
            System.out.println("Price >> @ ₹" + price);
            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        }
        }catch(SQLException e){
            throw new JDBCException("Oops!! Failed to featch product details!");
        }
    }

    @Override
    public boolean addToCart(int user_id, int product_id, int quantity) {
        String verifyUserId =
                "SELECT user_id FROM registered_user_details WHERE user_id = ?";
        String verifyProductIdAndAvailableQuantity =
                "SELECT product_id, product_name ,available_quantity FROM products WHERE product_id = ?";
        String addToCartQuery =
                "INSERT INTO cart (user_id, product_id, product_name ,quantity) VALUES (?,?,?,?)";

        try(Connection con = DataSourceConfig.getConnection();
            PreparedStatement ps1 = con.prepareStatement(verifyUserId);
            PreparedStatement ps2 = con.prepareStatement(verifyProductIdAndAvailableQuantity);
            PreparedStatement ps3 = con.prepareStatement(addToCartQuery)) {

            ps1.setInt(1, user_id);
            ResultSet resultSetForUserId = ps1.executeQuery();

            ps2.setInt(1, product_id);
            ResultSet resultSetForProductId = ps2.executeQuery();

            if(resultSetForUserId.next()){
                if(resultSetForProductId.next()){
                    int availableQuantity = resultSetForProductId.getInt("available_quantity");
                    if(availableQuantity >= quantity){
                        ps3.setInt(1,user_id);
                        ps3.setInt(2, product_id);
                        ps3.setString(3, resultSetForProductId.getString("product_name"));
                        ps3.setInt(4, quantity);
                        int resultForAddToCart = ps3.executeUpdate();
                        if(resultForAddToCart > 0){
                            System.out.println("Added to Cart ✅");
                            return true;
                        }else{
                            System.out.println("Failed to Add in cart");
                            return false;
                        }
                    }else if(availableQuantity< quantity){
                        ps3.setInt(1, user_id);
                        ps3.setInt(2, product_id);
                        ps3.setString(3, resultSetForProductId.getString("product_name"));
                        ps3.setInt(4, availableQuantity);
                        int resultSetIfAvailableQuantityIsLess = ps3.executeUpdate();
                        if(resultSetIfAvailableQuantityIsLess > 0){
                            System.out.println("We currently have only " + availableQuantity +
                                    " item(s) in stock. The available quantity has been added to your cart.");
                            return true;
                        }else {
                            System.out.println("Failed to Add in cart");
                            return false;
                        }
                    }else if(availableQuantity == 0){
                        System.out.println("Sorry! This product is currently out of stock.");
                    }
                }else{
                    System.out.println("Invalid Product ID. Please check and try again.");
                }
            }else{
                System.out.println("Invalid User ID. Please check and try again.");
            }
        }catch (SQLException e){
            System.out.println("Failed to add item in cart, Try Again!!");
        }
        return false;
    }

    @Override
    public void viewCart(int user_id) {
        try(Connection con = DataSourceConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(viewCartQuery)){
            ps.setInt(1, user_id);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int quantity = resultSet.getInt("quantity");

                System.out.println("Product Id :: " + productId);
                System.out.println("Product Name :: " + productName);
                System.out.println("Quantity :: " + quantity);
                System.out.println("****----****----****----****----****----****");
            }
        }catch(Exception e){
            throw new JDBCException("Failed to connect with database! Try Again!");
        }
    }

    @Override
    public void purchaseItem() {

    }
}
