package com.fnma.appraisal.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int propertyID;
    private String ownerName;
    private String address;
    private String phone;
    private String email;
    private int numBeds;
    private int numBaths;
    private int sqrFeet;
    private float lotSize;
    private Date lastSaleDate;
    private int lastSalePrice;

    public Property() {
    }

    public Property(int propertyID, String ownerName, String address, String phone, String email, int numBeds, int numBaths, int sqrFeet, float lotSize, Date lastSaleDate, int lastSalePrice) {
        this.propertyID = propertyID;
        this.ownerName = ownerName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
        this.sqrFeet = sqrFeet;
        this.lotSize = lotSize;
        this.lastSaleDate = lastSaleDate;
        this.lastSalePrice = lastSalePrice;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public int getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    public int getNumBaths() {
        return numBaths;
    }

    public void setNumBaths(int numBaths) {
        this.numBaths = numBaths;
    }

    public int getSqrFeet() {
        return sqrFeet;
    }

    public void setSqrFeet(int sqrFeet) {
        this.sqrFeet = sqrFeet;
    }

    public float getLotSize() {
        return lotSize;
    }

    public void setLotSize(float lotSize) {
        this.lotSize = lotSize;
    }

    public Date getLastSaleDate() {
        return lastSaleDate;
    }

    public void setLastSaleDate(Date lastSaleDate) {
        this.lastSaleDate = lastSaleDate;
    }

    public int getLastSalePrice() {
        return lastSalePrice;
    }

    public void setLastSalePrice(int lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
    }
}
