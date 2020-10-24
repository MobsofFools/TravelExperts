package com.edvinlin.travelexperts.ui.customers;

import androidx.cardview.widget.CardView;
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

public class AddCustomer extends Fragment {

    private AddCustomerViewModel addCustomerViewModel;

    public static AddCustomer newInstance() {
        return new AddCustomer();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        addCustomerViewModel = new ViewModelProvider(this).get(AddCustomerViewModel.class);
        View root = inflater.inflate(R.layout.data_view_fragment_customer, container, false);
        final CardView back = root.findViewById(R.id.cardBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigation_customers);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addCustomerViewModel = ViewModelProviders.of(this).get(AddCustomerViewModel.class);
        // TODO: Use the ViewModel
    }

}