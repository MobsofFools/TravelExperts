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
import com.edvinlin.travelexperts.model.Customer;

public class AddCustomer extends Fragment {

    private SharedCustomerModel sharedCustomerModel;
    private EditText CustFirstName, CustLastName, CustAddress, CustCity, CustProv, CustPostal, CustCountry, CustHomePhone, CustEmail, CustBusPhone;

    public static AddCustomer newInstance() {
        return new AddCustomer();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.add_customer_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedCustomerModel = new ViewModelProvider(requireActivity()).get(SharedCustomerModel.class);

        //Edit Texts
        CustFirstName = view.findViewById(R.id.etaCustFirstName);
        CustLastName = view.findViewById(R.id.etaCustLastName);
        CustAddress = view.findViewById(R.id.etaCustAddress);
        CustCity = view.findViewById(R.id.etaCustCity);
        CustProv = view.findViewById(R.id.etaCustProv);
        CustCountry = view.findViewById(R.id.etaCustCountry);
        CustHomePhone = view.findViewById(R.id.etaCustHomePhone);
        CustBusPhone = view.findViewById(R.id.etaCustBusPhone);
        CustPostal = view.findViewById(R.id.etaCustPostal);
        CustEmail = view.findViewById(R.id.etaCustEmail);
        ;

        //Common Ones
        final CardView back = view.findViewById(R.id.cardBack);
        final Button btnAdd = view.findViewById(R.id.btnAdd);

        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_customers));

        btnAdd.setOnClickListener(v -> {
            Customer customer = new Customer(0,
                    CustFirstName.getText().toString(),
                    CustLastName.getText().toString(),
                    CustAddress.getText().toString(),
                    CustCity.getText().toString(),
                    CustProv.getText().toString(),
                    CustCountry.getText().toString(),
                    CustHomePhone.getText().toString(),
                    CustBusPhone.getText().toString(),
                    CustEmail.getText().toString(),
                    CustPostal.getText().toString(),
                    "password"
            );
            sharedCustomerModel.AddCustomer(customer);
        });
    }
}