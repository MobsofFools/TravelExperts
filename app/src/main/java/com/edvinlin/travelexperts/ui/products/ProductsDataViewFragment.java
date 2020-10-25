package com.edvinlin.travelexperts.ui.products;

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

public class ProductsDataViewFragment extends Fragment {

    private ProductsDataViewViewModel productsDataViewViewModel;
    private EditText txtId, txtPkgName, txtPkgStartDate, txtPkgEndDate,
            txtPkgBasePrice, txtPkgDesc, txtPkgAgencyCommission;

    public static ProductsDataViewFragment newInstance() {
        return new ProductsDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.data_view_fragment_products, container, false);

        //Edit Texts
        txtId = root.findViewById(R.id.txtId);
        txtPkgName = root.findViewById(R.id.txtPkgName);
        txtPkgStartDate = root.findViewById(R.id.txtPkgStartDate);
        txtPkgEndDate = root.findViewById(R.id.txtPkgEndDate);
        txtPkgBasePrice = root.findViewById(R.id.txtPkgBasePrice);
        txtPkgDesc = root.findViewById(R.id.txtPkgDesc);
        txtPkgAgencyCommission = root.findViewById(R.id.txtPkgAgencyCommission);

        //Common Ones
        final CardView back = root.findViewById(R.id.cardBack);
        final Button btnSave = root.findViewById(R.id.btnSave);
        final Button btnDelete = root.findViewById(R.id.btnDelete);

        //Back Button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigation_packages);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        productsDataViewViewModel = new ViewModelProvider(this).get(ProductsDataViewViewModel.class);
        // TODO: Use the ViewModel
    }

}