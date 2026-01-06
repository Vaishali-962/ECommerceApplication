package com.Tattva.dataSourceConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.Tattva.exception.JDBCException;
public final class DataSourceConfig {
    // Fields
    private static final String URL = "jdbc:mysql://localhost:3306/e_commerce_app_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "SeetaRam@123";

    // static block
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            throw new JDBCException("Class not found!");
        }
    }
    // constructor
    private DataSourceConfig(){}

    // method
    public static Connection getConnection(){
        try{
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch(SQLException e){
            throw new JDBCException("Failed to connect with Database");
        }
    }
}
