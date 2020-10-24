package com.edvinlin.travelexperts.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private int CustomerId;
    private String CustFirstName;
    private String CustLastName;
    private String CustAddress;
    private String CustCity;
    private String CustProv;
    private String CustCountry;
    private String CustHomePhone;
    private String CustBusPhone;
    private String CustEmail;
    private int AgentId;

    public Customer(int customerId, String custFirstName, String custLastName, String custAddress, String custCity, String custProv, String custCountry, String custHomePhone, String custBusPhone, String custEmail, int agentId) {
        this.CustomerId = customerId;
        this.CustFirstName = custFirstName;
        this.CustLastName = custLastName;
        this.CustAddress = custAddress;
        this.CustCity = custCity;
        this.CustProv = custProv;
        this.CustCountry = custCountry;
        this.CustHomePhone = custHomePhone;
        this.CustBusPhone = custBusPhone;
        this.CustEmail = custEmail;
        this.AgentId = agentId;
    }

    public int getCustomerId() {
        return this.CustomerId;
    }

    public void setCustomerId(int customerId) {
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

    public int getAgentId() {
        return this.AgentId;
    }

    public void setAgentId(int agentId) {
        this.AgentId = agentId;
    }

    @Override
    public String toString() {
        return CustFirstName + ' ' + CustLastName;
    }
}
