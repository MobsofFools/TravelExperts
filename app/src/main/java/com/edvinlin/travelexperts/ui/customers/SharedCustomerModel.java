package com.edvinlin.travelexperts.ui.customers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
    public final MutableLiveData<List<Customer>> mutableCustomerList = new MutableLiveData<>();
    public final MutableLiveData<Customer> mutableCustomer = new MutableLiveData<>();
    public List<Customer> customerList;
    public Customer testCustomer;


    public LiveData<List<Customer>> getCustomerList() {
        LoadCustomers();
        return mutableCustomerList;
    }

    public LiveData<Customer> getCustomer() {
        return mutableCustomer;
    }

    public void setCustomer(int position) {
        try {
            Customer customer = mutableCustomerList.getValue().get(position);
            mutableCustomer.setValue(customer);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void setCustomerAdded(Customer customer)
    {
        mutableCustomer.setValue(customer);
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
    public void AddCustomer(Customer customer, Context context) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Customer> call = apiService.createCustomerAPI(customer);
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                testCustomer = response.body();
                Log.d("TAG", "Response = " +testCustomer);
                mutableCustomer.postValue(testCustomer);
                Toast.makeText(context, "Customer Added", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
                Toast.makeText(context, "Add Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void EditCustomer(Customer customer, Context context) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Customer> call = apiService.updateCustomerAPI(customer);
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                testCustomer = response.body();
                Log.d("TAG", "Response = " +testCustomer);
                mutableCustomer.postValue(testCustomer);
                Toast.makeText(context, "Customer Saved", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
                Toast.makeText(context, "Save Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void DeleteCustomer(int id, Context context) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBody> call = apiService.deleteCustomerAPI(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("TAG", "Response + " + response);
                Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
                Toast.makeText(context, "Delete failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
