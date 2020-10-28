package com.edvinlin.travelexperts.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.edvinlin.travelexperts.R;

public class DashboardFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        //Card 1 = Packages
        final CardView card1 = root.findViewById(R.id.card1);
        //Card 2 = Flights
        final CardView card2 = root.findViewById(R.id.card2);
        //Card 3 = Customers
        final CardView card3 = root.findViewById(R.id.card3);
        //Card 4 = Bookings
        final CardView card4 = root.findViewById(R.id.card4);
        //Card 5 = Products
        final CardView card5 = root.findViewById(R.id.card5);
        //Card6 = Suppliers
        final CardView card6 = root.findViewById(R.id.card6);


        card1.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_packages));

        card2.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_flights));

        card3.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_customers));

        card4.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_bookings));

        card5.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_products));

        card6.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_suppliers));

        return root;
    }
}