package com.edvinlin.travelexperts.ui.customers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Customer;
import com.edvinlin.travelexperts.model.listview.CustomerAdapter;
import com.edvinlin.travelexperts.remote.ApiClient;
import com.edvinlin.travelexperts.remote.ApiInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomersFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Customer> customerList;
    CustomerAdapter customerAdapter;

    public static CustomersFragment newInstance() {
        return new CustomersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_customers, container, false);


        final FloatingActionButton addbtn = root.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addcustomer));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvList);

        initRecyclerView();

        getCustomerList();
    }

    //Methods

    private void getCustomerList() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Customer>> call = apiService.getCustomersAPI();
        call.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                customerList = response.body();
                Log.d("TAG","Response = " +customerList);
                customerAdapter.setBookingList(customerList);
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

    private void initRecyclerView() {
        // Setting up Recycler View
        customerList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        customerAdapter = new CustomerAdapter(getContext(),customerList);
        recyclerView.setAdapter(customerAdapter);
    }
}