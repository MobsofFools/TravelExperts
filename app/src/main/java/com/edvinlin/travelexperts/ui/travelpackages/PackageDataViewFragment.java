package com.edvinlin.travelexperts.ui.travelpackages;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.TravelPackage;
import com.edvinlin.travelexperts.model.functions.myDateSetter;

public class PackageDataViewFragment extends Fragment {

    private SharedPackageModel sharedPackageModel;
    EditText PkgId, PkgStartDate, PkgEndDate, PkgName,
            PkgBasePrice, PkgDesc, PkgAgencyCommission;

    public static PackageDataViewFragment newInstance() {
        return new PackageDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.data_view_fragment_package,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Edit Texts
        PkgId = view.findViewById(R.id.etPkgId);
        PkgName = view.findViewById(R.id.etPkgName);
        PkgStartDate = view.findViewById(R.id.etPkgStartDate);
        PkgEndDate = view.findViewById(R.id.etPkgEndDate);
        PkgDesc = view.findViewById(R.id.etPkgDesc);
        PkgBasePrice = view.findViewById(R.id.etPkgBasePrice);
        PkgAgencyCommission = view.findViewById(R.id.etPkgAgencyCommission);

        //Common Ones
        final CardView back = view.findViewById(R.id.cardBack);
        final Button btnSave = view.findViewById(R.id.btnSave);
        final Button btnDelete = view.findViewById(R.id.btnDelete);
        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_packages));
        sharedPackageModel = new ViewModelProvider(requireActivity()).get(SharedPackageModel.class);
        sharedPackageModel.getPackage().observe(getViewLifecycleOwner(), travelPackage -> {
            updateUI(travelPackage);
        });
        btnSave.setOnClickListener(v -> {
            TravelPackage travelPackage = new TravelPackage(
                    Integer.parseInt(PkgId.getText().toString()),
                    Double.parseDouble(PkgAgencyCommission.getText().toString()),
                    Double.parseDouble(PkgBasePrice.getText().toString()),
                    PkgDesc.getText().toString(),
                    PkgEndDate.getText().toString(),
                    PkgName.getText().toString(),
                    PkgStartDate.getText().toString()
            );
            sharedPackageModel.EditPackage(travelPackage, getContext());
        });
        btnDelete.setOnClickListener(v -> DeleteAskOption());

        myDateSetter dateSetter = new myDateSetter();
        dateSetter.setDate(PkgStartDate, getContext());
        dateSetter.setDate(PkgStartDate,getContext());
    }

    private AlertDialog DeleteAskOption() {
        AlertDialog deleteDialogBox = new AlertDialog.Builder(getContext())
                .setTitle("Delete")
                .setMessage("Do you want to Delete?")
                .setIcon(R.drawable.ic_warning_24px)
                .setPositiveButton("Delete", (dialog, which) -> {
                    int id = Integer.parseInt(PkgId.getText().toString());
                    sharedPackageModel.DeletePackage(id, getContext());
                    Navigation.findNavController(requireView()).navigate(R.id.navigation_packages);
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .create();
        deleteDialogBox.show();
        return deleteDialogBox;
    }
    private void updateUI(TravelPackage travelPackage) {
        if (travelPackage.getPackageId() == null) PkgId.setText("");
        else PkgId.setText(String.valueOf(travelPackage.getPackageId()));

        if (travelPackage.getPkgName() == null) PkgName.setText("");
        else PkgName.setText(travelPackage.getPkgName());

        if (travelPackage.getPkgStartDate() == null) PkgStartDate.setText("");
        else PkgStartDate.setText(travelPackage.getPkgStartDate());

        if (travelPackage.getPkgEndDate() == null) PkgEndDate.setText("");
        else PkgEndDate.setText(travelPackage.getPkgEndDate());

        if (travelPackage.getPkgDesc() == null) PkgDesc.setText("");
        else PkgDesc.setText(travelPackage.getPkgDesc());

        if (travelPackage.getPkgBasePrice() == null) PkgBasePrice.setText("");
        else PkgBasePrice.setText(String.valueOf(travelPackage.getPkgBasePrice()));

        if (travelPackage.getPkgAgencyCommission() == null) PkgAgencyCommission.setText("");
        else PkgAgencyCommission.setText(String.valueOf(travelPackage.getPkgAgencyCommission()));
    }

}