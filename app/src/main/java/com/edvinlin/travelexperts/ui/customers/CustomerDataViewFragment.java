package com.edvinlin.travelexperts.ui.customers;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Customer;

public class CustomerDataViewFragment extends Fragment {


    private SharedCustomerModel sharedCustomerModel;
    private EditText CustId;
    private EditText CustFirstName;
    private EditText CustLastName;
    private EditText CustAddress;
    private EditText CustCity;
    private EditText CustProv;
    private EditText CustPostal;
    private EditText CustCountry;
    private EditText CustHomePhone;
    private EditText CustEmail;
    private EditText CustBusPhone;

    public static CustomerDataViewFragment newInstance() {
        return new CustomerDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.data_view_fragment_customer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //Edit Texts
        CustId = view.findViewById(R.id.etCustId);
        CustFirstName = view.findViewById(R.id.etCustFirstName);
        CustLastName = view.findViewById(R.id.etCustLastName);
        CustAddress = view.findViewById(R.id.etCustAddress);
        CustCity = view.findViewById(R.id.etCustCity);
        CustProv = view.findViewById(R.id.etCustProv);
        CustPostal = view.findViewById(R.id.etCustPostal);
        CustCountry = view.findViewById(R.id.etCustCountry);
        CustHomePhone = view.findViewById(R.id.etCustHomePhone);
        CustEmail = view.findViewById(R.id.etCustEmail);
        CustBusPhone = view.findViewById(R.id.etCustBusPhone);

        //Common Ones
        final CardView back = view.findViewById(R.id.cardBack);
        final Button btnSave = view.findViewById(R.id.btnSave);
        final Button btnDelete = view.findViewById(R.id.btnDelete);
        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_customers));
        
        sharedCustomerModel = new ViewModelProvider(requireActivity()).get(SharedCustomerModel.class);
        sharedCustomerModel.getCustomer().observe(getViewLifecycleOwner(), customer -> updateUI(customer));
        btnSave.setOnClickListener(v -> {
            Customer customer = new Customer (
                Integer.parseInt(CustId.getText().toString()),
                CustAddress.getText().toString(),
                CustBusPhone.getText().toString(),
                CustCity.getText().toString(),
                CustCountry.getText().toString(),
                CustEmail.getText().toString(),
                CustFirstName.getText().toString(),
                CustHomePhone.getText().toString(),
                CustLastName.getText().toString(),
                CustPostal.getText().toString(),
                CustProv.getText().toString()
                );
            sharedCustomerModel.EditCustomer(customer, getContext());
            Navigation.findNavController(v).navigate(R.id.navigation_customers);
        });
        btnDelete.setOnClickListener(v -> {
            int id = Integer.parseInt(CustId.getText().toString());
            Log.d("TAG", String.valueOf(id));
            DeleteAskOption(id);
        });

    }

    private void DeleteAskOption(int id) {
        new AlertDialog.Builder(getContext())
                .setTitle("Delete")
                .setMessage("Do you want to Delete?")
                .setIcon(R.drawable.ic_warning_24px)
                .setPositiveButton("Delete", (dialog, which) -> {
                    sharedCustomerModel.DeleteCustomer(id, getContext());
                    Navigation.findNavController(getView()).navigate(R.id.navigation_customers);
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .create();
    }

    private void updateUI(Customer customer) {
        CustId.setText(String.valueOf(customer.getCustomerId()));
        CustFirstName.setText(customer.getCustFirstName());
        CustLastName.setText(customer.getCustLastName());
        CustAddress.setText(customer.getCustAddress());
        CustCity.setText(customer.getCustCity());
        CustProv.setText(customer.getCustProv());
        CustCountry.setText(customer.getCustCountry());
        CustHomePhone.setText(customer.getCustHomePhone());
        CustBusPhone.setText(customer.getCustBusPhone());
        CustPostal.setText(customer.getCustPostal());
        CustEmail.setText(customer.getCustEmail());

    }
}