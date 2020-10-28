package com.edvinlin.travelexperts.ui.bookings;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
    public Booking testBooking;


    public LiveData<List<Booking>> getBookingList() {
        LoadBookings();
        return mutableBookingList;
    }

    public LiveData<Booking> getBooking() {
        return mutableBooking;
    }

    public void setBooking(int position) {
        try {
            Booking booking = mutableBookingList.getValue().get(position);
            mutableBooking.setValue(booking);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void setBookingAdded(Booking booking) {
        mutableBooking.setValue(booking);
    }

    private void LoadBookings() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
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

    public void AddBooking(Booking booking, Context context) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Booking> call = apiService.createBookingAPI(booking);
        call.enqueue(new Callback<Booking>() {
            @Override
            public void onResponse(Call<Booking> call, Response<Booking> response) {
                testBooking = response.body();
                Log.d("TAG","Response = " +testBooking);
                mutableBooking.postValue(testBooking);
                Toast.makeText(context, "Booking Successful", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Booking> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
                Toast.makeText(context, "Add Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
    //Functional
    public void EditBooking(Booking booking, Context context) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Booking> call = apiService.updateBookingAPI(booking);
        call.enqueue(new Callback<Booking>() {
            @Override
            public void onResponse(Call<Booking> call, Response<Booking> response) {
                testBooking = response.body();
                Log.d("TAG","Response = " +testBooking);
                mutableBooking.postValue(testBooking);
                Toast.makeText(context, "Booking Saved", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Booking> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
                Toast.makeText(context, "Save Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void DeleteBooking(int id, Context context) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> call = apiService.deleteBookingAPI(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("TAG","Response = " + response);
                Toast.makeText(context, "Booking Deleted", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
                Toast.makeText(context, "Deleted Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

}


