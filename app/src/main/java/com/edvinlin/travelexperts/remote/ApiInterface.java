package com.edvinlin.travelexperts.remote;

import com.edvinlin.travelexperts.model.Booking;
import com.edvinlin.travelexperts.model.Customer;
import com.edvinlin.travelexperts.model.TravelPackage;

import java.util.List;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    //Customers
    //Get All Customers
    @GET("getcustomers")
    Call<List<Customer>> getCustomers();
    //Get Single Customer
    @GET("getcustomer/{ customerId }")
    Call<List<Customer>> getCustomer(@Path("customerId") int customerId);
    //Post Customer
    @POST("postcustomer")
    Call<Customer> createCustomer(@Body Customer customer);
    //Put Customer
//    @PUT("putcustomer")
//    Call<ResponseBody> updateCustomer(@Body Customer customer);
    //Delete Customer
    @DELETE("deletecustomer/{ customerId }")
    Call<ResponseBody> deleteCustomer(@Path("customerId") int customerId);


    //Bookings
    //Get All Bookings
    @GET("getbookings")
    Call<List<Booking>> getBookings();
    //Get Specific Booking
    @GET("getbooking/{bookingId}")
    Call<List<Booking>> getBooking(@Path("bookingId") int bookingId);
    //Post Booking
    @POST("postbooking")
    Call<Booking> createBooking(@Body Booking booking);
    //Put Booking
//    @PUT("putbooking")
//    Call<ResponseBody> updateBooking(@Body Booking booking);
    //Delete Customer
    @DELETE("deletebooking/{ bookingId }")
    Call<ResponseBody> deleteBooking(@Path("bookingId") int bookingId);


    //Travel Packages
    //Get Packages
    @GET("gettravelpackages/")
    Call<List<TravelPackage>> getTravelPackages();
    //New Package
    @POST("posttravelpackage")
    Call<TravelPackage> createTravelPackage(@Body TravelPackage travelPackage);
    //Update/Replace Package
//    @PUT("puttravelpackage")
//    Call<RequestBody> updateTravelPackage(@Body TravelPackage travelPackage);
    //Delete Package
    @DELETE("deletetravelpackage/{ packageId }")
    Call<ResponseBody> deletePackage(@Path("packageId") int packageId);



}
