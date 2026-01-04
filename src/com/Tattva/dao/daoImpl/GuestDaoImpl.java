package com.Tattva.dao.daoImpl;

import com.Tattva.Exception.InvalidInputException;
import com.Tattva.Exception.JDBCException;
import com.Tattva.dao.GuestDao;
import com.Tattva.dataSourceConfig.DataSourceConfig;

import java.sql.*;

public  class GuestDaoImpl implements GuestDao {
    final String QUERY = "SELECT * FROM products ORDER BY product_id asc" ;

    @Override
    public void viewProduct(int option) {
        try{
        if(option == 13){
            try(Connection con = DataSourceConfig.getConnection(); Statement stat = con.createStatement()){
                System.out.println("Product List");
                ResultSet result = stat.executeQuery(QUERY);

                while(result.next()){
                    int productId = result.getInt("product_id");
                    String productName = result.getString("product_name");
                    String productDescription = result.getString("product_description");
                    int availableQuantity = result.getInt("available_quantity");
                    double price = result.getDouble("price");

                    System.out.println("Product Id >> " + productId);
                    System.out.println("Product Name >> " + productName);
                    System.out.println("Product Description >> " + productDescription);
                    System.out.println("Available Quantity >> " + availableQuantity);
                    System.out.println("Price >> @ ₹" + price);
                    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
            }
            }catch(SQLException e){
                throw new JDBCException("Failed to fetch data from Database!");
            }
        }else if(option == 0){
            System.out.println("Thanks for the Visit 🙏🏻");
        }
        }catch(InvalidInputException e){
            throw new InvalidInputException(" ❌ Invalid Input! Please follow the given options");
        }
    }
}
