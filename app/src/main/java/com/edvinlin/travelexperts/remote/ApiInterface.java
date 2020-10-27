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
    Call<List<Customer>> getCustomersAPI();
    //Get Single Customer
    @GET("getcustomer/{ customerId }")
    Call<Customer> getCustomer(@Path("customerId") int customerId);
    //Post Customer
    @POST("postcustomer")
    Call<Customer> createCustomerAPI(@Body Customer customer);
    //Put Customer
    @PUT("putcustomer")
    Call<ResponseBody> updateCustomerAPI(@Body Customer customer);
    //Delete Customer
    @DELETE("deletecustomer/{ customerId }")
    Call<ResponseBody> deleteCustomerAPI(@Path("customerId") int customerId);


    //Bookings
    //Get All Bookings
    @GET("getbookings")
    Call<List<Booking>> getBookingsAPI();
    //Get Specific Booking
    @GET("getbooking/{bookingId}")
    Call<Booking> getBookingAPI(@Path("bookingId") int bookingId);
    //Post Booking
    @POST("postbooking")
    Call<Booking> createBookingAPI(@Body Booking booking);
    //Put Booking
    @PUT("putbooking")
    Call<ResponseBody> updateBookingAPI(@Body Booking booking);
    //Delete Customer
    @DELETE("deletebooking/{ bookingId }")
    Call<ResponseBody> deleteBookingAPI(@Path("bookingId") int bookingId);


    //Travel Packages
    //Get Packages
    @GET("gettravelpackages/")
    Call<List<TravelPackage>> getTravelPackagesAPI();
    @GET("gettravelpackage/{packageId}")
    Call<TravelPackage> getPackageAPI(@Path("packageId") int packageId);
    //New Package
    @POST("posttravelpackage")
    Call<TravelPackage> createTravelPackageAPI(@Body TravelPackage travelPackage);
    //Update/Replace Package
//    @PUT("puttravelpackage")
//    Call<RequestBody> updateTravelPackageAPI(@Body TravelPackage travelPackage);
    //Delete Package
    @DELETE("deletetravelpackage/{ packageId }")
    Call<ResponseBody> deletePackageAPI(@Path("packageId") int packageId);



}
