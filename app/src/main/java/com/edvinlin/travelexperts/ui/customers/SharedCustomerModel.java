package com.edvinlin.travelexperts.ui.customers;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.edvinlin.travelexperts.model.Customer;
import com.edvinlin.travelexperts.remote.ApiClient;
import com.edvinlin.travelexperts.remote.ApiInterface;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharedCustomerModel extends ViewModel {
    public static final String TAG = "SharedCustomerModel";
    public MutableLiveData<List<Customer>> mutableCustomerList = new MutableLiveData<>();
    public MutableLiveData<Customer> mutableCustomer = new MutableLiveData<>();
    public List<Customer> customerList;
    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    public LiveData<List<Customer>> getCustomerList() {
        if (mutableCustomerList.getValue() == null) {
            LoadCustomers();
        }
        return mutableCustomerList;
    }
    public LiveData<Customer> getCustomer() {return mutableCustomer;}

    public void setCustomer(int position) {
        try {
            Customer customer = mutableCustomerList.getValue().get(position);
            mutableCustomer.setValue(customer);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
    private void LoadCustomers() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Customer>> call = apiService.getCustomersAPI();
        call.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                customerList = response.body();
                Log.d("TAG","Response = " +customerList);
                mutableCustomerList.postValue(customerList);

            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }
    public void AddCustomer(Customer customer) {
        Call<Customer> call = apiService.createCustomerAPI(customer);
    }
    public void EditCustomer(Customer customer) {
        Call<ResponseBody> call = apiService.updateCustomerAPI(customer);
    }
    public void DeleteCustomer(int id) {
        Call<ResponseBody> call = apiService.deleteCustomerAPI(id);
    }
}
