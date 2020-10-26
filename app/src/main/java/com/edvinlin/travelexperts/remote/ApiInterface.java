package com.edvinlin.travelexperts.remote;

import com.edvinlin.travelexperts.model.Booking;
import com.edvinlin.travelexperts.model.Customer;
import com.edvinlin.travelexperts.model.TravelPackage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("getbookings/")
    Call<List<Booking>> getBookings();

    @GET("getcustomers/")
    Call<List<Customer>> getCustomers();

    @GET("gettravelpackages/")
    Call<List<TravelPackage>> getTravelPackages();

}
