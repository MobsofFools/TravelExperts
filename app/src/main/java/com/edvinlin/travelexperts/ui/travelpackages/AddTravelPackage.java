package com.edvinlin.travelexperts.ui.travelpackages;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edvinlin.travelexperts.R;

public class AddTravelPackage extends Fragment {

    private AddTravelPackageViewModel mViewModel;

    public static AddTravelPackage newInstance() {
        return new AddTravelPackage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_travel_package_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddTravelPackageViewModel.class);
        // TODO: Use the ViewModel
    }

}