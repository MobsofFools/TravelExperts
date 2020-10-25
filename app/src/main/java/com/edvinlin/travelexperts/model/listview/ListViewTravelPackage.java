package com.edvinlin.travelexperts.model.listview;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class ListViewTravelPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    private int PackageId;
    private String PkgName;

    public ListViewTravelPackage(int packageId, String pkgName) {
        this.PackageId = packageId;
        this.PkgName = pkgName;
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

    @NonNull
    @Override
    public String toString() {
        return PkgName;
    }
}
