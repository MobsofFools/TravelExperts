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

public class BookingsDataViewFragment extends Fragment {

    private BookingsDataViewViewModel bookingsDataViewViewModel;
    private EditText BookingId, BookingNo, BookingDate, BookingCustId, BookingTripTypeId;

    public static BookingsDataViewFragment newInstance() {
        return new BookingsDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.data_view_fragment_bookings, container, false);

        //Edit Texts
        BookingId = root.findViewById(R.id.etBookingId);
        BookingNo = root.findViewById(R.id.etBookingNo);
        BookingDate = root.findViewById(R.id.etBookingDate);
        BookingCustId = root.findViewById(R.id.etBookingCustId);
        BookingTripTypeId = root.findViewById(R.id.etBookingTripTypeId);

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
        bookingsDataViewViewModel = new ViewModelProvider(this).get(BookingsDataViewViewModel.class);
        // TODO: Use the ViewModel
    }

}