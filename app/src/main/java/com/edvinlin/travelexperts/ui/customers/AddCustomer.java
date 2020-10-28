package com.edvinlin.travelexperts.ui.customers;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
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

        CustFirstName.addTextChangedListener(textWatcher);
        CustLastName.addTextChangedListener(textWatcher);
        CustAddress.addTextChangedListener(textWatcher);
        CustCity.addTextChangedListener(textWatcher);
        CustProv.addTextChangedListener(textWatcher);
        CustCountry.addTextChangedListener(textWatcher);
        CustHomePhone.addTextChangedListener(textWatcher);
        CustBusPhone.addTextChangedListener(textWatcher);
        CustPostal.addTextChangedListener(textWatcher);
        CustEmail.addTextChangedListener(textWatcher);

        ;

        //Common Ones
        final CardView back = view.findViewById(R.id.cardBack);
        final Button btnAdd = view.findViewById(R.id.btnAdd);

        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_customers));

        btnAdd.setOnClickListener(v -> {
            Customer customer = new Customer(0,
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
            sharedCustomerModel.AddCustomer(customer);
            sharedCustomerModel.setCustomerAdded(customer);
            Navigation.findNavController(view).navigate(R.id.navigation_customers);
        });
    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String i1 = CustAddress.getText().toString();
            String i2 = CustBusPhone.getText().toString();
            String i3 = CustCity.getText().toString();
            String i4 = CustCountry.getText().toString();
            String i5 = CustEmail.getText().toString();
            String i6 = CustFirstName.getText().toString();
            String i7 = CustHomePhone.getText().toString();
            String i8 = CustLastName.getText().toString();
            String i9 = CustPostal.getText().toString();
            String i10 = CustProv.getText().toString();

            Button btnAdd = getView().findViewById(R.id.btnAdd);
            btnAdd.setEnabled(!i1.isEmpty() && !i2.isEmpty() && !i3.isEmpty()
                    && !i4.isEmpty() && !i5.isEmpty() && !i6.isEmpty() && !i7.isEmpty()
                    && !i8.isEmpty() && !i9.isEmpty() && !i10.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}