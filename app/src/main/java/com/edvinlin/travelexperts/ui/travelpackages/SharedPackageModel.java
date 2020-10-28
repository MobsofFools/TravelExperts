package com.edvinlin.travelexperts.ui.travelpackages;

import android.util.Log;
import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.edvinlin.travelexperts.model.TravelPackage;
import com.edvinlin.travelexperts.remote.ApiClient;
import com.edvinlin.travelexperts.remote.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharedPackageModel extends ViewModel {

    public static final String TAG = "SharedPackageModel";
    public MutableLiveData<List<TravelPackage>> mutablePackageList = new MutableLiveData<>();
    public MutableLiveData<TravelPackage> mutablePackage = new MutableLiveData<>();
    public List<TravelPackage> packageList;
    public TravelPackage testPackage;


    public LiveData<List<TravelPackage>> getPackageList() {
        LoadPackages();
        return mutablePackageList;
    }
    public LiveData<TravelPackage> getPackage() {
        return mutablePackage;
    }

    public void setPackage(int position) {
        try{
            TravelPackage travelPackage = mutablePackageList.getValue().get(position);
            mutablePackage.setValue(travelPackage);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void LoadPackages() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<TravelPackage>> call = apiService.getTravelPackagesAPI();
        call.enqueue(new Callback<List<TravelPackage>>() {
            @Override
            public void onResponse(Call<List<TravelPackage>> call, Response<List<TravelPackage>> response) {
                packageList = response.body();
                Log.d("TAG", "Response = "+ packageList);
                mutablePackageList.postValue(packageList);
            }

            @Override
            public void onFailure(Call<List<TravelPackage>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }
    public void AddPackage(TravelPackage travelPackage) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TravelPackage> call = apiService.createTravelPackageAPI(travelPackage);
        call.enqueue(new Callback<TravelPackage>() {
            @Override
            public void onResponse(Call<TravelPackage> call, Response<TravelPackage> response) {
                testPackage = response.body();
                Log.d("TAG", "Response = " +testPackage);

            }

            @Override
            public void onFailure(Call<TravelPackage> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });

    }
    public void EditPackage(TravelPackage travelPackage) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TravelPackage> call = apiService.updateTravelPackageAPI(travelPackage);
        call.enqueue(new Callback<TravelPackage>() {
            @Override
            public void onResponse(Call<TravelPackage> call, Response<TravelPackage> response) {
                testPackage = response.body();
                Log.d("TAG", "Response = " +testPackage);
            }

            @Override
            public void onFailure(Call<TravelPackage> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }
    public void DeletePackage(int id) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> call = apiService.deletePackageAPI(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("TAG", "Response + " + response);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }
}
