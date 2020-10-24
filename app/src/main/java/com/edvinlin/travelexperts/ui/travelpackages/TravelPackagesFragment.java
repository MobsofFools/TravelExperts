package com.edvinlin.travelexperts.ui.travelpackages;

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

public class TravelPackagesFragment extends Fragment {

    private TravelPackagesViewModel travelPackagesViewModel;

    public static TravelPackagesFragment newInstance() {
        return new TravelPackagesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        travelPackagesViewModel = ViewModelProviders.of(this).get(TravelPackagesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_travel_packages,container,false);
        final FloatingActionButton addbtn = root.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigation_addpackage);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        travelPackagesViewModel = ViewModelProviders.of(this).get(TravelPackagesViewModel.class);
        // TODO: Use the ViewModel
    }

}