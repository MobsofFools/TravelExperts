package com.edvinlin.travelexperts.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TripType implements Serializable {

    @SerializedName("tripTypeId")
    @Expose
    private String tripTypeId;


    @SerializedName("TTName")
    @Expose
    private String TTName;

    public TripType(String tripTypeId, String TTName) {
        this.tripTypeId = tripTypeId;
        this.TTName = TTName;
    }

    public String getTripTypeId() {
        return tripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        this.tripTypeId = tripTypeId;
    }

    public String getTTName() {
        return TTName;
    }

    public void setTTName(String TTName) {
        this.TTName = TTName;
    }

    @NonNull
    @Override
    public String toString() {
        return getTripTypeId();
    }
}
