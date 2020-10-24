package com.edvinlin.travelexperts.model;
import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    private int BookingId;
    private Date BookingDate;
    private String BookingNo;
    private double TravelerCount;
    private int CustomerId;
    private String TripTypeId;

    public Booking(int bookingId, Date bookingDate, String bookingNo, double travelerCount, int customerId, String tripTypeId) {
        this.BookingId = bookingId;
        this.BookingDate = bookingDate;
        this.BookingNo = bookingNo;
        this.TravelerCount = travelerCount;
        this.CustomerId = customerId;
        this.TripTypeId = tripTypeId;
    }

    public int getBookingId() {
        return this.BookingId;
    }

    public void setBookingId(int bookingId) {
        this.BookingId = bookingId;
    }

    public Date getBookingDate() {
        return this.BookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.BookingDate = bookingDate;
    }

    public String getBookingNo() {
        return this.BookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.BookingNo = bookingNo;
    }

    public double getTravelerCount() {
        return this.TravelerCount;
    }

    public void setTravelerCount(double travelerCount) {
        this.TravelerCount = travelerCount;
    }

    public int getCustomerId() {
        return this.CustomerId;
    }

    public void setCustomerId(int customerId) {
        this.CustomerId = customerId;
    }

    public String getTripTypeId() {
        return this.TripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        this.TripTypeId = tripTypeId;
    }

    @Override
    public String toString() {
        return BookingNo.toString();
    }
}
