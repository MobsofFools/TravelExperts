package com.edvinlin.travelexperts.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ProductId;
    private String ProdName;

    public Product(int productId, String prodName) {
        this.ProductId = productId;
        this.ProdName = prodName;
    }

    public int getProductId() {
        return this.ProductId;
    }

    public void setProductId(int productId) {
        this.ProductId = productId;
    }

    public String getProdName() {
        return this.ProdName;
    }

    public void setProdName(String prodName) {
        this.ProdName = prodName;
    }

    @Override
    public String toString() {
        return ProdName;
    }
}
