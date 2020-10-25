package com.edvinlin.travelexperts.model.listview;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class ListViewCustomer implements Serializable {
    private static final long serialVersionUID=1L;
    private int CustomerId;
    private String CustFirstName;
    private String CustLastName;

    public ListViewCustomer(int customerId, String custFirstName, String custLastName) {
        this.CustomerId = customerId;
        this.CustFirstName = custFirstName;
        this.CustLastName = custLastName;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getCustFirstName() {
        return CustFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        CustFirstName = custFirstName;
    }

    public String getCustLastName() {
        return CustLastName;
    }

    public void setCustLastName(String custLastName) {
        CustLastName = custLastName;
    }

    @NonNull
    @Override
    public String toString() {
        return CustFirstName + ' ' + CustLastName;
    }
}
