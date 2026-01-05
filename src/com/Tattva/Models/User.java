package com.Tattva.Models;

public class User {
    // Fields
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String city;
    private String mailId;
    private String mobileNumber;
    // No-args Constructors
    public User() {}
    // Parameterized Constructors

    public User(int userId, String firstName, String lastName, String username, String password, String city, String mailId, String mobileNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.city = city;
        this.mailId = mailId;
        this.mobileNumber = mobileNumber;
    }

    // Getter and Setter Methods
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // Overridden toString() method


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", mailId='" + mailId + '\'' +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
