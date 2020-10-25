package com.edvinlin.travelexperts.ui.bookings;

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

public class AddBooking extends Fragment {

    private AddBookingViewModel addBookingViewModel;
    private EditText BookingNo, BookingDate, BookingCustId, BookingTripTypeId;

    public static AddBooking newInstance() {
        return new AddBooking();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_booking_fragment, container, false);
        //Edit Texts

        BookingNo = root.findViewById(R.id.etaBookingNo);
        BookingDate = root.findViewById(R.id.etaBookingDate);
        BookingCustId = root.findViewById(R.id.etaBookingCustId);
        BookingTripTypeId = root.findViewById(R.id.etaBookingTripTypeId);

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
        addBookingViewModel = new ViewModelProvider(this).get(AddBookingViewModel.class);
        // TODO: Use the ViewModel
    }

}