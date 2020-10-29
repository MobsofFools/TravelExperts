package com.edvinlin.travelexperts.ui.chat;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.edvinlin.travelexperts.extra.Cat;
import com.edvinlin.travelexperts.extra.CatClient;
import com.edvinlin.travelexperts.extra.CatInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatViewModel extends ViewModel {
    public static final String TAG = "CAT";
    public final MutableLiveData<Cat> mutableCat = new MutableLiveData<>();
    public Cat cat;

    public LiveData<Cat> getCatFact() {
        catFactAPI();
        return mutableCat;
    }

    private void catFactAPI() {
        CatInterface catInterface = CatClient.getClient().create(CatInterface.class);
        Call<Cat> call = catInterface.getCatFact();
        call.enqueue(new Callback<Cat>() {
            @Override
            public void onResponse(Call<Cat> call, Response<Cat> response) {
                cat = response.body();
                mutableCat.postValue(cat);
                Log.d(TAG, response.toString());
            }

            @Override
            public void onFailure(Call<Cat> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });

    }

}