package com.edvinlin.travelexperts.ui.travelpackages;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.telecom.Call;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Booking;
import com.edvinlin.travelexperts.model.TravelPackage;
import com.edvinlin.travelexperts.ui.bookings.SharedBookingModel;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddTravelPackage extends Fragment {

    private SharedPackageModel sharedPackageModel;
    private EditText PkgName, PkgBasePrice, PkgAgencyCommission, PkgStartDate, PkgEndDate, PkgDesc;
    public static AddTravelPackage newInstance() {
        return new AddTravelPackage();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.add_travel_package_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPackageModel = new ViewModelProvider(requireActivity()).get(SharedPackageModel.class);

        //Edit Texts
        PkgName = view.findViewById(R.id.etaPkgName);
        PkgStartDate = view.findViewById(R.id.etaPkgStartDate);
        PkgEndDate = view.findViewById(R.id.etaPkgEndDate);
        PkgDesc = view.findViewById(R.id.etaPkgDesc);
        PkgBasePrice = view.findViewById(R.id.etaPkgBasePrice);
        PkgAgencyCommission = view.findViewById(R.id.etaPkgAgencyCommission);

        PkgName.addTextChangedListener(textWatcher);
        PkgStartDate.addTextChangedListener(textWatcher);
        PkgEndDate.addTextChangedListener(textWatcher);
        PkgDesc.addTextChangedListener(textWatcher);
        PkgBasePrice.addTextChangedListener(textWatcher);
        PkgAgencyCommission.addTextChangedListener(textWatcher);

        myDateSetter dateSetter = new myDateSetter();

        dateSetter.setDate(PkgStartDate,getContext());
        dateSetter.setDate(PkgEndDate,getContext());

        //Common Ones
        final CardView back = view.findViewById(R.id.cardBack);
        final Button btnAdd = view.findViewById(R.id.btnAdd);

        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_packages));
        btnAdd.setOnClickListener(v -> {
            TravelPackage travelPackage = new TravelPackage(0,
                    Double.parseDouble(PkgAgencyCommission.getText().toString()),
                    Double.parseDouble(PkgBasePrice.getText().toString()),
                    PkgDesc.getText().toString(),
                    PkgEndDate.getText().toString(),
                    PkgName.getText().toString(),
                    PkgStartDate.getText().toString()
                    );
            sharedPackageModel.AddPackage(travelPackage);
        });

    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String i1 = PkgName.getText().toString();
            String i2 = PkgStartDate.getText().toString();
            String i3 = PkgEndDate.getText().toString();
            String i4 = PkgDesc.getText().toString();
            String i5 = PkgBasePrice.getText().toString();
            String i6 = PkgAgencyCommission.getText().toString();

            Button btnAdd = getView().findViewById(R.id.btnAdd);
            btnAdd.setEnabled(!i1.isEmpty() && !i2.isEmpty() && !i3.isEmpty()
                    && !i4.isEmpty() && !i5.isEmpty() && !i6.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}