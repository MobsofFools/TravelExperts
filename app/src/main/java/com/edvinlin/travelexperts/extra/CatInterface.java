package com.edvinlin.travelexperts.extra;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatInterface {
    @GET("fact?max_length=140")
    Call<Cat> getCatFact();

}
