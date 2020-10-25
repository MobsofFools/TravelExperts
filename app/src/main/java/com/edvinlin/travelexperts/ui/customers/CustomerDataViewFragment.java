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
import android.widget.EditText;

import com.edvinlin.travelexperts.R;

public class CustomerDataViewFragment extends Fragment {

    private CustomerDataViewViewModel customerDataViewViewModel;
    private EditText n;

    public static CustomerDataViewFragment newInstance() {
        return new CustomerDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        customerDataViewViewModel = new ViewModelProvider(this).get(CustomerDataViewViewModel.class);
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
        customerDataViewViewModel = ViewModelProviders.of(this).get(CustomerDataViewViewModel.class);
        // TODO: Use the ViewModel
    }

}