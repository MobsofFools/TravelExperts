package com.edvinlin.travelexperts.ui.travelpackages;

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
import android.widget.Button;
import android.widget.EditText;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.TravelPackage;

import java.math.BigDecimal;
import java.util.Date;

public class AddTravelPackage extends Fragment {

    private AddTravelPackageViewModel addTravelPackageViewModel;

    public static AddTravelPackage newInstance() {
        return new AddTravelPackage();
    }
    EditText PkgName, PkgBasePrice, PkgAgencyCommission, PkgStartDate, PkgEndDate, PkgDesc;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        addTravelPackageViewModel = new ViewModelProvider(this).get(AddTravelPackageViewModel.class);
        View root = inflater.inflate(R.layout.add_travel_package_fragment,container,false);

        //Edit Texts
        PkgName = root.findViewById(R.id.etaPkgName);
        PkgStartDate = root.findViewById(R.id.etaPkgStartDate);
        PkgEndDate = root.findViewById(R.id.etaPkgEndDate);
        PkgDesc = root.findViewById(R.id.etaPkgDesc);
        PkgBasePrice = root.findViewById(R.id.etaPkgBasePrice);
        PkgAgencyCommission = root.findViewById(R.id.etaPkgAgencyCommission);

        //Common Ones
        final CardView back = root.findViewById(R.id.cardBack);
        final Button btnSave = root.findViewById(R.id.btnSave);
        final Button btnDelete = root.findViewById(R.id.btnDelete);
        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_packages));

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addTravelPackageViewModel = new ViewModelProvider(this).get(AddTravelPackageViewModel.class);
        // TODO: Use the ViewModel
    }

}