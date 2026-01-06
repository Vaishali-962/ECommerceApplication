package com.Tattva.dao;
import com.Tattva.models.Product;
public interface AdminDao {
    boolean adminLogin(String adminNameInput, String passwordInput);
    void addProductItem(Product product);
    double calculateBill(int userId);
    void displayAmountToUser(int userId);
    void checkQuantity(int product_id);
    boolean checkRegisteredUserList();
    void checkParticularUserHistory(String username);

}
