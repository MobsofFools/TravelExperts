package com.edvinlin.travelexperts.ui.travelpackages;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.edvinlin.travelexperts.model.TravelPackage;
import com.edvinlin.travelexperts.remote.ApiClient;
import com.edvinlin.travelexperts.remote.ApiInterface;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharedPackageModel extends ViewModel {

    public static final String TAG = "SharedPackageModel";
    public MutableLiveData<List<TravelPackage>> mutablePackageList = new MutableLiveData<>();
    public MutableLiveData<TravelPackage> mutablePackage = new MutableLiveData<>();
    public List<TravelPackage> packageList;
    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    public LiveData<List<TravelPackage>> getPackageList() {
        if (mutablePackageList.getValue() == null) {
            LoadPackages();
        }
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
        Call<TravelPackage> call = apiService.createTravelPackageAPI(travelPackage);
    }
    public void EditPackage(TravelPackage travelPackage) {
        Call<ResponseBody> call = apiService.updateTravelPackageAPI(travelPackage);
    }
    public void DeletePackage(int id) {
        Call<ResponseBody> call = apiService.deletePackageAPI(id);
    }
}
