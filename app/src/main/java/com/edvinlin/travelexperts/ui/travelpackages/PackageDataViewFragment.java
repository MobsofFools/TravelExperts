package com.edvinlin.travelexperts.ui.travelpackages;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

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

public class PackageDataViewFragment extends Fragment {
    EditText PkgId, PkgStartDate, PkgEndDate, PkgName,
            PkgBasePrice, PkgDesc, PkgAgencyCommission;

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
        PkgId = root.findViewById(R.id.etPkgId);
        PkgName = root.findViewById(R.id.etPkgName);
        PkgStartDate = root.findViewById(R.id.etPkgStartDate);
        PkgEndDate = root.findViewById(R.id.etPkgEndDate);
        PkgDesc = root.findViewById(R.id.etPkgDesc);
        PkgBasePrice = root.findViewById(R.id.etPkgBasePrice);
        PkgAgencyCommission = root.findViewById(R.id.etPkgAgencyCommission);

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
        packageDataViewViewModel = new ViewModelProvider(this).get(PackageDataViewViewModel.class);
        // TODO: Use the ViewModel
    }

}