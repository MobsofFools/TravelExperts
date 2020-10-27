package com.edvinlin.travelexperts.ui.bookings;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.edvinlin.travelexperts.model.Booking;
import com.edvinlin.travelexperts.remote.ApiClient;
import com.edvinlin.travelexperts.remote.ApiInterface;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharedBookingModel extends ViewModel {

    private static final String TAG = "SharedBookingModel";
    public MutableLiveData<List<Booking>> mutableBookingList = new MutableLiveData<>();
    public MutableLiveData<Booking> mutableBooking = new MutableLiveData<>();
    public List<Booking> bookingList;
    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    public LiveData<List<Booking>> getBookingList() {
        if (mutableBookingList.getValue() == null) {
            LoadBookings();
        }
        return mutableBookingList;
    }

    public LiveData<Booking> getBooking() {
        return mutableBooking;
    }

    public void setBooking(int position) {
        try {
            Booking booking = mutableBookingList.getValue().get(position);
            mutableBooking.setValue(booking);
        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    private void LoadBookings() {
        Call<List<Booking>> call = apiService.getBookingsAPI();
        call.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {
                bookingList = response.body();
                Log.d("TAG","Response = " +bookingList);
                mutableBookingList.postValue(bookingList);
            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });

    }
    public void AddBooking(Booking booking) {
        Call<Booking> call = apiService.createBookingAPI(booking);
    }
    public void EditBooking(Booking booking) {
        Call<ResponseBody> call = apiService.updateBookingAPI(booking);
    }
    public void DeleteBooking(int id) {
        Call<ResponseBody> call = apiService.deleteBookingAPI(id);
    }

}


