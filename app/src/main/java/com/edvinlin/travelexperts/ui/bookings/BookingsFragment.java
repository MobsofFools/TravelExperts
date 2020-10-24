package com.edvinlin.travelexperts.ui.bookings;

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
import com.edvinlin.travelexperts.ui.customers.CustomersViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BookingsFragment extends Fragment {

    private BookingsViewModel bookingsViewModel;

    public static BookingsFragment newInstance() {
        return new BookingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        bookingsViewModel =  new ViewModelProvider(this).get(BookingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_customers, container, false);
        final FloatingActionButton addbtn = root.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigation_addbooking);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bookingsViewModel = ViewModelProviders.of(this).get(BookingsViewModel.class);
        // TODO: Use the ViewModel
    }

}