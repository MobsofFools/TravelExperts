package com.edvinlin.travelexperts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @SerializedName("customerId")
    @Expose
    private Integer CustomerId;

    @SerializedName("custAddress")
    @Expose
    private String CustAddress;

    @SerializedName("custBusPhone")
    @Expose
    private String CustBusPhone;

    @SerializedName("custCity")
    @Expose
    private String CustCity;

    @SerializedName("custCountry")
    @Expose
    private String CustCountry;

    @SerializedName("custEmail")
    @Expose
    private String CustEmail;

    @SerializedName("custFirstName")
    @Expose
    private String CustFirstName;

    @SerializedName("custHomePhone")
    @Expose
    private String CustHomePhone;

    @SerializedName("custLastName")
    @Expose
    private String CustLastName;

    @SerializedName("custPostal")
    @Expose
    private String CustPostal;

    @SerializedName("custProv")
    @Expose
    private String CustProv;


    public Customer(Integer customerId, String custAddress, String custBusPhone, String custCity, String custCountry, String custEmail, String custFirstName, String custHomePhone, String custLastName, String custPostal, String custProv) {
        CustomerId = customerId;
        CustAddress = custAddress;
        CustBusPhone = custBusPhone;
        CustCity = custCity;
        CustCountry = custCountry;
        CustEmail = custEmail;
        CustFirstName = custFirstName;
        CustHomePhone = custHomePhone;
        CustLastName = custLastName;
        CustPostal = custPostal;
        CustProv = custProv;
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


}
