package com.edvinlin.travelexperts.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TravelPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @SerializedName("packageId")
    @Expose
    private int PackageId;
    @SerializedName("pkgName")
    @Expose
    private String PkgName;
    @SerializedName("pkgStartDate")
    @Expose
    private String PkgStartDate;
    @SerializedName("pkgEndDate")
    @Expose
    private String PkgEndDate;
    @SerializedName("pkgDesc")
    @Expose
    private String PkgDesc;
    @SerializedName("pkgBasePrice")
    @Expose
    private Double PkgBasePrice;
    @SerializedName("pkgAgencyCommission")
    @Expose
    private Double PkgAgencyCommission;

    public TravelPackage(int packageId, String pkgName, String pkgStartDate, String pkgEndDate, String pkgDesc, Double pkgBasePrice, Double pkgAgencyCommission) {
        PackageId = packageId;
        PkgName = pkgName;
        PkgStartDate = pkgStartDate;
        PkgEndDate = pkgEndDate;
        PkgDesc = pkgDesc;
        PkgBasePrice = pkgBasePrice;
        PkgAgencyCommission = pkgAgencyCommission;
    }

    public int getPackageId() {
        return PackageId;
    }

    public void setPackageId(int packageId) {
        PackageId = packageId;
    }

    public String getPkgName() {
        return PkgName;
    }

    public void setPkgName(String pkgName) {
        PkgName = pkgName;
    }

    public String getPkgStartDate() {
        return PkgStartDate;
    }

    public void setPkgStartDate(String pkgStartDate) {
        PkgStartDate = pkgStartDate;
    }

    public String getPkgEndDate() {
        return PkgEndDate;
    }

    public void setPkgEndDate(String pkgEndDate) {
        PkgEndDate = pkgEndDate;
    }

    public String getPkgDesc() {
        return PkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
        PkgDesc = pkgDesc;
    }

    public Double getPkgBasePrice() {
        return PkgBasePrice;
    }

    public void setPkgBasePrice(Double pkgBasePrice) {
        PkgBasePrice = pkgBasePrice;
    }

    public Double getPkgAgencyCommission() {
        return PkgAgencyCommission;
    }

    public void setPkgAgencyCommission(Double pkgAgencyCommission) {
        PkgAgencyCommission = pkgAgencyCommission;
    }
}
