package com.edvinlin.travelexperts.model;
import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @SerializedName("bookingId")
    @Expose
    private Integer bookingId;
    @SerializedName("bookingDate")
    @Expose
    private String bookingDate;
    @SerializedName("bookingNo")
    @Expose
    private String bookingNo;
    @SerializedName("customerId")
    @Expose
    private Integer customerId;
    @SerializedName("packageId")
    @Expose
    private Integer packageId;
    @SerializedName("travelerCount")
    @Expose
    private Double travelerCount;
    @SerializedName("tripTypeId")
    @Expose
    private String tripTypeId;

    public Booking(Integer bookingId, String bookingDate, String bookingNo, Integer customerId, Integer packageId, Double travelerCount, String tripTypeId) {
        super();
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingNo = bookingNo;
        this.customerId = customerId;
        this.packageId = packageId;
        this.travelerCount = travelerCount;
        this.tripTypeId = tripTypeId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Double getTravelerCount() {
        return travelerCount;
    }

    public void setTravelerCount(Double travelerCount) {
        this.travelerCount = travelerCount;
    }

    public String getTripTypeId() {
        return tripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        this.tripTypeId = tripTypeId;
    }
}


