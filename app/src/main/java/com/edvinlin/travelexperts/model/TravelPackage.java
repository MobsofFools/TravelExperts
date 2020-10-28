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
    private Integer PackageId;

    @SerializedName("pkgAgencyCommission")
    @Expose
    private Double PkgAgencyCommission;

    @SerializedName("pkgBasePrice")
    @Expose
    private Double PkgBasePrice;

    @SerializedName("pkgDesc")
    @Expose
    private String PkgDesc;

    @SerializedName("pkgName")
    @Expose
    private String PkgName;

    @SerializedName("pkgEndDate")
    @Expose
    private String PkgEndDate;

    @SerializedName("pkgStartDate")
    @Expose
    private String PkgStartDate;

    public TravelPackage(Integer packageId, Double pkgAgencyCommission, Double pkgBasePrice, String pkgDesc, String pkgName, String pkgEndDate, String pkgStartDate) {
        PackageId = packageId;
        PkgAgencyCommission = pkgAgencyCommission;
        PkgBasePrice = pkgBasePrice;
        PkgDesc = pkgDesc;
        PkgName = pkgName;
        PkgEndDate = pkgEndDate;
        PkgStartDate = pkgStartDate;
    }

    public Integer getPackageId() {
        return PackageId;
    }

    public void setPackageId(Integer packageId) {
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
