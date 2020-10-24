package com.edvinlin.travelexperts.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TravelPackage implements Serializable {
    private static final long serialVersionUID = 1L;

    private int PackageId;
    private String PkgName;
    private Date PkgStartDate;
    private Date PkgEndDate;
    private String PkgDesc;
    private BigDecimal PkgBasePrice;
    private BigDecimal PkgAgencyCommission;

    public TravelPackage(int packageId, String pkgName, Date pkgStartDate, Date pkgEndDate, String pkgDesc, BigDecimal pkgBasePrice, BigDecimal pkgAgencyCommission) {
        this.PackageId = packageId;
        this.PkgName = pkgName;
        this.PkgStartDate = pkgStartDate;
        this.PkgEndDate = pkgEndDate;
        this.PkgDesc = pkgDesc;
        this.PkgBasePrice = pkgBasePrice;
        this.PkgAgencyCommission = pkgAgencyCommission;
    }

    public int getPackageId() {
        return this.PackageId;
    }

    public void setPackageId(int packageId) {
        this.PackageId = packageId;
    }

    public String getPkgName() {
        return this.PkgName;
    }

    public void setPkgName(String pkgName) {
        this.PkgName = pkgName;
    }

    public Date getPkgStartDate() {
        return this.PkgStartDate;
    }

    public void setPkgStartDate(Date pkgStartDate) {
        this.PkgStartDate = pkgStartDate;
    }

    public Date getPkgEndDate() {
        return this.PkgEndDate;
    }

    public void setPkgEndDate(Date pkgEndDate) {
        this.PkgEndDate = pkgEndDate;
    }

    public String getPkgDesc() {
        return this.PkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
        this.PkgDesc = pkgDesc;
    }

    public BigDecimal getPkgBasePrice() {
        return this.PkgBasePrice;
    }

    public void setPkgBasePrice(BigDecimal pkgBasePrice) {
        this.PkgBasePrice = pkgBasePrice;
    }

    public BigDecimal getPkgAgencyCommission() {
        return this.PkgAgencyCommission;
    }

    public void setPkgAgencyCommission(BigDecimal pkgAgencyCommission) {
        this.PkgAgencyCommission = pkgAgencyCommission;
    }

    @Override
    public String toString() {
        return PkgName;
    }
}
