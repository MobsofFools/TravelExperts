package com.edvinlin.travelexperts.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @SerializedName("customerId")
    private Integer CustomerId;
    @SerializedName("custFirstName")
    private String CustFirstName;
    @SerializedName("custLastName")
    private String CustLastName;
    @SerializedName("custAddress")
    private String CustAddress;
    @SerializedName("custCity")
    private String CustCity;
    @SerializedName("custProv")
    private String CustProv;
    @SerializedName("custCountry")
    private String CustCountry;
    @SerializedName("custHomePhone")
    private String CustHomePhone;
    @SerializedName("custBusPhone")
    private String CustBusPhone;
    @SerializedName("custPostal")
    private String CustPostal;
    @SerializedName("custEmail")
    private String CustEmail;
    @SerializedName("custPassword")
    private String CustPassword;

    public Customer(Integer customerId, String custFirstName, String custLastName,
                    String custAddress, String custCity, String custProv, String custCountry,
                    String custHomePhone, String custBusPhone, String custPostal, String custEmail,
                    String custPassword) {
        this.CustomerId = customerId;
        this.CustFirstName = custFirstName;
        this.CustLastName = custLastName;
        this.CustAddress = custAddress;
        this.CustCity = custCity;
        this.CustProv = custProv;
        this.CustCountry = custCountry;
        this.CustHomePhone = custHomePhone;
        this.CustBusPhone = custBusPhone;
        this.CustPostal = custPostal;
        this.CustEmail = custEmail;
        this.CustPassword = custPassword;
    }

    public Integer getCustomerId() {
        return this.CustomerId;
    }

    public void setCustomerId(Integer customerId) {
        this.CustomerId = customerId;
    }

    public String getCustFirstName() {
        return this.CustFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.CustFirstName = custFirstName;
    }

    public String getCustLastName() {
        return this.CustLastName;
    }

    public void setCustLastName(String custLastName) {
        this.CustLastName = custLastName;
    }

    public String getCustAddress() {
        return this.CustAddress;
    }

    public void setCustAddress(String custAddress) {
        this.CustAddress = custAddress;
    }

    public String getCustCity() {
        return this.CustCity;
    }

    public void setCustCity(String custCity) {
        this.CustCity = custCity;
    }

    public String getCustProv() {
        return this.CustProv;
    }

    public void setCustProv(String custProv) {
        this.CustProv = custProv;
    }

    public String getCustCountry() {
        return this.CustCountry;
    }

    public void setCustCountry(String custCountry) {
        this.CustCountry = custCountry;
    }

    public String getCustHomePhone() {
        return this.CustHomePhone;
    }

    public void setCustHomePhone(String custHomePhone) {
        this.CustHomePhone = custHomePhone;
    }

    public String getCustBusPhone() {
        return this.CustBusPhone;
    }

    public void setCustBusPhone(String custBusPhone) {
        this.CustBusPhone = custBusPhone;
    }

    public String getCustEmail() {
        return this.CustEmail;
    }

    public void setCustEmail(String custEmail) {
        this.CustEmail = custEmail;
    }


    public String getCustPostal() {
        return CustPostal;
    }

    public void setCustPostal(String custPostal) {
        CustPostal = custPostal;
    }

    public String getCustPassword() {
        return CustPassword;
    }

    public void setCustPassword(String custPassword) {
        CustPassword = custPassword;
    }

    @Override
    public String toString() {
        return CustFirstName + ' ' + CustLastName;
    }
}
