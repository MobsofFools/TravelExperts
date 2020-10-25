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

public class CustomerDataViewFragment extends Fragment {

    private CustomerDataViewViewModel customerDataViewViewModel;
    private EditText CustId, CustAgentId, CustFirstName, CustLastName, CustAddress, CustCity, CustProv, CustPostal, CustCountry, CustHomePhone, CustEmail, CustBusPhone;

    public static CustomerDataViewFragment newInstance() {
        return new CustomerDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        customerDataViewViewModel = new ViewModelProvider(this).get(CustomerDataViewViewModel.class);
        View root = inflater.inflate(R.layout.data_view_fragment_customer, container, false);

        //Edit Texts
        CustId = root.findViewById(R.id.etCustId);
        CustAgentId = root.findViewById(R.id.etCustAgentId);
        CustFirstName = root.findViewById(R.id.etCustFirstName);
        CustLastName = root.findViewById(R.id.etCustLastName);
        CustAddress = root.findViewById(R.id.etCustAddress);
        CustCity = root.findViewById(R.id.etCustCity);
        CustProv = root.findViewById(R.id.etCustProv);
        CustPostal = root.findViewById(R.id.etCustPostal);
        CustCountry = root.findViewById(R.id.etCustCountry);
        CustHomePhone = root.findViewById(R.id.etCustHomePhone);
        CustEmail = root.findViewById(R.id.etCustEmail);
        CustBusPhone = root.findViewById(R.id.etCustBusPhone);

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
        customerDataViewViewModel = new ViewModelProvider(this).get(CustomerDataViewViewModel.class);
        // TODO: Use the ViewModel
    }

}