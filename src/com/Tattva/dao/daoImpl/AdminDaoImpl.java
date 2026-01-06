package com.Tattva.dao.daoImpl;

import com.Tattva.dao.AdminDao;
import com.Tattva.dataSourceConfig.DataSourceConfig;
import com.Tattva.exception.InvalidInputException;
import com.Tattva.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean adminLogin(String adminNameInput, String passwordInput){
        boolean isLoggedIn = false;
        String query  = "SELECT admin_name, password FROM admins WHERE admin_name = ? AND password = ?";
        try(Connection con = DataSourceConfig.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,adminNameInput);
            ps.setString(2, passwordInput);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                isLoggedIn = true;
                String adminName = resultSet.getString("admin_name");
                String password = resultSet.getString("password");
                System.out.println("✅ Logged-in to Admin Mode");
                System.out.println("Welcome " + adminName);
                return true;
            }
            if (!isLoggedIn){
                System.out.println("🛑Failed to Login 🛑");
            }

        }catch(Exception e){
            throw new InvalidInputException("Invalid Credentials Operation Suspended!");
        }
        return false;
    }
    @Override
    public void addProductItem(Product product) {
        // query
        String addProductQuery = "INSERT INTO products " +
                "(product_id, product_name, product_description, available_quantity, price) " +
                "VALUES (?,?,?,?,?)";

        try(Connection con = DataSourceConfig.getConnection();
            PreparedStatement ps1 = con.prepareStatement(addProductQuery)){
            ps1.setInt(1, product.getProductId());
            ps1.setString(2,product.getProductName());
            ps1.setString(3,product.getProductDescription());
            ps1.setInt(4,product.getAvailableQuantity());
            ps1.setDouble(5,product.getPrice());

            int response = ps1.executeUpdate();
            if(response > 0){
                System.out.println("✅Product added successfully");
            }else{
                System.out.println("❌ Product didn't added to cart");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public double calculateBill(int userId) {
        double totalAmount = 0;
        // query
        String calculateBillQuery = "SELECT quantity, price FROM cart WHERE user_id = ?";
        try(Connection con = DataSourceConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(calculateBillQuery)){
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    totalAmount += quantity * price;
                }
            return totalAmount;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public void displayAmountToUser(int userId) {
        double amount = calculateBill(userId);
        System.out.println("Display the amount to End User >> " + amount);
    }

    @Override
    public void checkQuantity(int productId) {
        boolean isDataFound = false;
        // query
        String checkQuantityQuery = "SELECT available_quantity FROM products WHERE product_id = ?";
        try(Connection con = DataSourceConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(checkQuantityQuery)){
            ps.setInt(1,productId);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                isDataFound = true;
                int quantity = resultSet.getInt("available_quantity");
                System.out.println("Product ID :: " + productId);
                System.out.println("Quantity :: " + quantity);
            }
            if(!isDataFound){
                System.out.println("No data found for given Product Id");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean checkRegisteredUserList() {
        boolean isRegistedUserPresent = false;
        // query
        String checkRegisteredUserQuery = "SELECT user_id, user_name FROM registered_user_details ORDER BY user_id";

        try(Connection con = DataSourceConfig.getConnection();
            Statement stat = con.createStatement()){
            ResultSet resultSet = stat.executeQuery(checkRegisteredUserQuery);
            while(resultSet.next()){
                isRegistedUserPresent = true;
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                System.out.println("User Id >> " + userId  + " || User Name >> " + userName);

            }
            if(!isRegistedUserPresent){
                System.out.println("❌No Data Found for Registered User!");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return isRegistedUserPresent;
    }

    @Override
    public void checkParticularUserHistory(String username) {
        // query
        String checkParticularUserHistoryQuery =
                "SELECT * FROM orders_details WHERE user_name = ?";
        boolean isHistoryFound = false;
        try(Connection con = DataSourceConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(checkParticularUserHistoryQuery)){
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                isHistoryFound = true;
                int orderId = resultSet.getInt("order_id");
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int quantity = resultSet.getInt("quantity");
                double totalAmount = resultSet.getDouble("total_amount");
                String orderTimeAndDate = String.valueOf(resultSet.getTimestamp("order_timestamp"));

                System.out.println("👉USER HISTORY FOR USERNAME " + username + " 👈");
                System.out.println("Order ID >> " + orderId + "\n" +
                        "User ID >> "+ userId + "\n" +
                        "User Name >> " + userName + "\n" +
                        "Product ID >> " + productId + "\n" +
                        "Product Name >> " + productName + "\n" +
                        "Quantity >> " + quantity + "\n" +
                        "Total Amount >> "+ totalAmount + "\n" +
                        "Order Time and Date" + orderTimeAndDate + "\n" +
                        "====================================================="
                );
            }
            if(!isHistoryFound){
                System.out.println("❌ No History found for the given user name!");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
