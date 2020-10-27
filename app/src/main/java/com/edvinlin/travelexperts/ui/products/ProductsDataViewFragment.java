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

    private EditText ProductId, ProductName;

    public static ProductsDataViewFragment newInstance() {
        return new ProductsDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.data_view_fragment_products, container, false);

        //Edit Texts
        ProductId = root.findViewById(R.id.etProductId);
        ProductName = root.findViewById(R.id.etProductName);


        //Common Ones
        final CardView back = root.findViewById(R.id.cardBack);
        final Button btnSave = root.findViewById(R.id.btnSave);
        final Button btnDelete = root.findViewById(R.id.btnDelete);

        //Back Button
        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_packages));

        return root;
    }

}