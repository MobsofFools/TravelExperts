package com.edvinlin.travelexperts.ui.customers;

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

public class AddCustomer extends Fragment {

    private AddCustomerViewModel addCustomerViewModel;
    private EditText CustAgentId, CustFirstName, CustLastName, CustAddress, CustCity, CustProv, CustPostal, CustCountry, CustHomePhone, CustEmail, CustBusPhone;

    public static AddCustomer newInstance() {
        return new AddCustomer();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.data_view_fragment_customer, container, false);

        //Edit Texts
        CustFirstName = root.findViewById(R.id.etaCustFirstName);
        CustLastName = root.findViewById(R.id.etaCustLastName);
        CustAddress = root.findViewById(R.id.etaCustAddress);
        CustCity = root.findViewById(R.id.etaCustCity);
        CustProv = root.findViewById(R.id.etaCustProv);
        CustPostal = root.findViewById(R.id.etaCustPostal);
        CustCountry = root.findViewById(R.id.etaCustCountry);
        CustHomePhone = root.findViewById(R.id.etaCustHomePhone);
        CustEmail = root.findViewById(R.id.etaCustEmail);
        CustBusPhone = root.findViewById(R.id.etaCustBusPhone);

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
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addCustomerViewModel = new ViewModelProvider(this).get(AddCustomerViewModel.class);
        // TODO: Use the ViewModel
    }

}