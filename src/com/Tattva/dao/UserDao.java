package com.Tattva.dao;

import com.Tattva.Models.User;

public interface UserDao {
    boolean userRegistration(User user);
    boolean userLogin(User user);
    void viewProductList();
    boolean addToCart(int user_id, int product_id, int quantity);
    void viewCart(int user_id);
    void purchaseItem();
}
