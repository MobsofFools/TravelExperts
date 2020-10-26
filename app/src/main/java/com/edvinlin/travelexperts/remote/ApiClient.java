package com.edvinlin.travelexperts.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String BASE_URL = "http://192.168.0.100:8081/TravelExpertsAPI/rs/api/";
    private static Retrofit retrofit;
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
