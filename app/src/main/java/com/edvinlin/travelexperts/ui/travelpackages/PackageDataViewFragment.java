package com.edvinlin.travelexperts.ui.travelpackages;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.TravelPackage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.Executors;

public class PackageDataViewFragment extends Fragment {
    EditText txtPackageId, txtPkgStartDate, txtPkgEndDate, txtPkgName,
            txtPkgBasePrice, txtPkgDesc, txtPkgAgencyCommission;

    private PackageDataViewViewModel packageDataViewViewModel;

    public static PackageDataViewFragment newInstance() {
        return new PackageDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        packageDataViewViewModel = new ViewModelProvider(this).get(PackageDataViewViewModel.class);
        View root = inflater.inflate(R.layout.data_view_fragment_package,container,false);

        //Edit Texts
        txtPackageId = root.findViewById(R.id.txtPackageId);
        txtPkgName = root.findViewById(R.id.txtPkgName);
        txtPkgStartDate = root.findViewById(R.id.txtPkgStartDate);
        txtPkgEndDate = root.findViewById(R.id.txtPkgEndDate);
        txtPkgDesc = root.findViewById(R.id.txtPkgDesc);
        txtPkgBasePrice = root.findViewById(R.id.txtPkgBasePrice);
        txtPkgAgencyCommission = root.findViewById(R.id.txtPkgAgencyCommission);

        //Common Ones
        final CardView back = root.findViewById(R.id.cardBack);
        final Button btnSave = root.findViewById(R.id.btnSave);
        final Button btnDelete = root.findViewById(R.id.btnDelete);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigation_packages);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TravelPackage travelPackage = new TravelPackage(0,
                        txtPkgName.getText().toString(),
                        ((Date) txtPkgStartDate.getText()),
                        ((Date) txtPkgEndDate.getText()),
                        txtPkgDesc.getText().toString(),
                        ((BigDecimal) txtPkgBasePrice.getText()),
                        ((BigDecimal) txtPkgAgencyCommission.getText())
                );
                //Executors.newSingleThreadExecutor().execute(new PostPackage(travelPackage));
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        packageDataViewViewModel = new ViewModelProvider(this).get(PackageDataViewViewModel.class);
        // TODO: Use the ViewModel
    }

}