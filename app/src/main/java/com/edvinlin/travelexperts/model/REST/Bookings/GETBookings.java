package com.edvinlin.travelexperts.model.REST.Bookings;

public class GETBookings implements Runnable{

    @Override
    public void run() {
       String host = "http://localhost:8081";
       String API = "TravelExperts/rs/api";
       String action = "getbookings";

        StringBuffer buffer = new StringBuffer();
        String url = "'" + host + "/" + API + "/" + action + "'";
    }
}
