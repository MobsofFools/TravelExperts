package com.edvinlin.travelexperts.model.listview;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class ListViewBooking implements Serializable {
    private static final long serialVersionUID = 1L;

    private int BookingId;
    private String BookingNo;

    public ListViewBooking(int bookingId, String bookingNo) {
        this.BookingId = bookingId;
        this.BookingNo = bookingNo;
    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int bookingId) {
        BookingId = bookingId;
    }

    public String getBookingNo() {
        return BookingNo;
    }

    public void setBookingNo(String bookingNo) {
        BookingNo = bookingNo;
    }

    @NonNull
    @Override
    public String toString() {
        return BookingNo;
    }
}
