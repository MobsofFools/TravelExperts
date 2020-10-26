package com.edvinlin.travelexperts.ui.customers;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private CustomersViewModel customersViewModel;
    private RecyclerView recyclerView;
    private List<Customer> customerList;
    private DividerItemDecoration dividerItemDecoration;
    CustomerAdapter customerAdapter;

    public static CustomersFragment newInstance() {
        return new CustomersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        customersViewModel =  new ViewModelProvider(this).get(CustomersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_customers, container, false);
        // Setting up Recycler View
        recyclerView = (RecyclerView) root.findViewById(R.id.rvList);
        customerList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);;
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        customerAdapter = new CustomerAdapter(getContext(),customerList);
        recyclerView.setAdapter(customerAdapter);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Customer>> call = apiService.getCustomers();
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

        final FloatingActionButton addbtn = root.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addcustomer));




        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        customersViewModel = new ViewModelProvider(this).get(CustomersViewModel.class);
        // TODO: Use the ViewModel
    }

}