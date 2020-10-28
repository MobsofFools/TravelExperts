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

    private SharedPackageModel sharedPackageModel;
    private EditText PkgName, PkgBasePrice, PkgAgencyCommission, PkgStartDate, PkgEndDate, PkgDesc;
    public static AddTravelPackage newInstance() {
        return new AddTravelPackage();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.add_travel_package_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Edit Texts
        PkgName = view.findViewById(R.id.etaPkgName);
        PkgStartDate = view.findViewById(R.id.etaPkgStartDate);
        PkgEndDate = view.findViewById(R.id.etaPkgEndDate);
        PkgDesc = view.findViewById(R.id.etaPkgDesc);
        PkgBasePrice = view.findViewById(R.id.etaPkgBasePrice);
        PkgAgencyCommission = view.findViewById(R.id.etaPkgAgencyCommission);

        //Common Ones
        final CardView back = view.findViewById(R.id.cardBack);
        final Button btnAdd = view.findViewById(R.id.btnAdd);

        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_packages));
        btnAdd.setOnClickListener(v -> {
            TravelPackage travelPackage = new TravelPackage(0,
                    Double.parseDouble(PkgAgencyCommission.getText().toString()),
                    Double.parseDouble(PkgBasePrice.getText().toString()),
                    PkgDesc.getText().toString(),
                    PkgEndDate.getText().toString(),
                    PkgName.getText().toString(),
                    PkgStartDate.getText().toString()
                    );
            sharedPackageModel.AddPackage(travelPackage);
        });

    }
}