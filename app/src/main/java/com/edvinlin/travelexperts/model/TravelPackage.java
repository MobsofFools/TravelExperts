package com.edvinlin.travelexperts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

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

    @SerializedName("pkgEndDate")
    @Expose
    private String PkgEndDate;

    @SerializedName("pkgName")
    @Expose
    private String PkgName;

    @SerializedName("pkgStartDate")
    @Expose
    private String PkgStartDate;

    public TravelPackage(Integer packageId, Double pkgAgencyCommission, Double pkgBasePrice, String pkgDesc, String pkgEndDate, String pkgName, String pkgStartDate) {
        PackageId = packageId;
        PkgAgencyCommission = pkgAgencyCommission;
        PkgBasePrice = pkgBasePrice;
        PkgDesc = pkgDesc;
        PkgEndDate = pkgEndDate;
        PkgName = pkgName;
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
