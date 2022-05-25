package com.fnma.appraisal.Entity;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String companyName;
    private String address;
    private String phone;
    private String email;
    private String userName;
    private String password;
    private String roll; //Bank or Appraiser
    private String authorities; //ROLE_BANK or ROLE_APPRAISER

    public User() {
    }

    public User(int userID, String companyName, String address, String phone, String email, String userName, String password, String roll, String authorities) {
        this.userID = userID;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.roll = roll;
        this.authorities = authorities;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
