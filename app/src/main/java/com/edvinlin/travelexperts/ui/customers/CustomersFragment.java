package com.edvinlin.travelexperts.ui.customers;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edvinlin.travelexperts.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CustomersFragment extends Fragment {

    private CustomersViewModel customersViewModel;

    public static CustomersFragment newInstance() {
        return new CustomersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        customersViewModel =  new ViewModelProvider(this).get(CustomersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_customers, container, false);
        final FloatingActionButton addbtn = root.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigation_addcustomer);
            }
        });




        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        customersViewModel = ViewModelProviders.of(this).get(CustomersViewModel.class);
        // TODO: Use the ViewModel
    }

}