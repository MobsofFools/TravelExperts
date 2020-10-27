package com.edvinlin.travelexperts.ui.customers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Customer;
import com.edvinlin.travelexperts.model.listview.CustomerAdapter;
import com.edvinlin.travelexperts.model.listview.OnRecyclerItemClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CustomersFragment extends Fragment implements OnRecyclerItemClickListener {

    private SharedCustomerModel sharedCustomerModel;
    private RecyclerView recyclerView;
    private List<Customer> customerList;
    private NavController navController;
    private CustomerAdapter customerAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_customers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvList);
        navController = Navigation.findNavController(view);
        final FloatingActionButton addbtn = view.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addcustomer));

        initRecyclerView();

        sharedCustomerModel = new ViewModelProvider(requireActivity()).get(SharedCustomerModel.class);
        sharedCustomerModel.getCustomerList().observe(getViewLifecycleOwner(), customers -> {
            customerList.clear();
            customerList.addAll(customers);
            customerAdapter.notifyDataSetChanged();
        });
    }

    private void initRecyclerView() {
        // Setting up Recycler View
        customerList = new ArrayList<>();
        customerAdapter = new CustomerAdapter(getContext(),customerList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customerAdapter);
    }

    @Override
    public void onItemClick(int position) {
        sharedCustomerModel.setCustomer(position);
        navController.navigate(R.id.action_navigation_customers_to_navigation_customerdataview);
    }
}