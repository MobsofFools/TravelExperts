package com.edvinlin.travelexperts.ui.bookings;

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
import com.edvinlin.travelexperts.model.Booking;

public class BookingsDataViewFragment extends Fragment {

    private SharedBookingModel sharedBookingModel;
    private EditText BookingId, BookingNo, BookingDate, BookingCustId, BookingTripTypeId, BookingPackageId, BookingTravelerCount;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.data_view_fragment_bookings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Hide <- in action bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        //Edit Texts
        BookingId = view.findViewById(R.id.etBookingId);
        BookingNo = view.findViewById(R.id.etBookingNo);
        BookingDate = view.findViewById(R.id.etBookingDate);
        BookingCustId = view.findViewById(R.id.etBookingCustId);
        BookingTripTypeId = view.findViewById(R.id.etBookingTripTypeId);
        BookingPackageId = view.findViewById(R.id.etPackageId);
        BookingTravelerCount = view.findViewById(R.id.etTravelerCount);


        //Common Items
        final CardView back = view.findViewById(R.id.cardBack);
        final Button btnSave = view.findViewById(R.id.btnSave);
        final Button btnDelete = view.findViewById(R.id.btnDelete);

        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_bookings));

        //Instantiate Shared View Model
        sharedBookingModel = new ViewModelProvider(requireActivity()).get(SharedBookingModel.class);

        sharedBookingModel.getBooking().observe(getViewLifecycleOwner(), booking -> updateUI(booking));

        //Pull Data from EditText fields to make booking object (In same order as API JSON Structure)
        btnSave.setOnClickListener(v -> {
            Booking booking = new Booking(
                    Integer.parseInt(BookingId.getText().toString()),
                    BookingDate.getText().toString(),
                    BookingNo.getText().toString(),
                    Integer.parseInt(BookingCustId.getText().toString()),
                    Integer.parseInt(BookingPackageId.getText().toString()),
                    Integer.parseInt(BookingTravelerCount.getText().toString()),
                    BookingTripTypeId.getText().toString()
            );

            //Call EditBooking function from shared view model
            sharedBookingModel.EditBooking(booking, getContext());
            //Navigate back to main list
            Navigation.findNavController(v).navigate(R.id.navigation_bookings);


        });

        btnDelete.setOnClickListener(v -> {
            //get id for {bookingId} in api call
            int id = Integer.parseInt(BookingId.getText().toString());
            Log.d("TAG", String.valueOf(id));
            //Call popup function
            DeleteAskOption(id);
        });
    }

    //Pop confirmation function
    private void DeleteAskOption(int id) {
        AlertDialog deleteDialogBox = new AlertDialog.Builder(getContext())
                .setTitle("Delete")
                .setMessage("Do you want to Delete?")
                .setIcon(R.drawable.ic_warning_24px)
                .setPositiveButton("Delete", (dialog, which) -> {
                    //Delete function
                    sharedBookingModel.DeleteBooking(id, getContext());
                    //Navigate back to bookings
                    Navigation.findNavController(getView()).navigate(R.id.navigation_bookings);
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .create();
        Log.d("TAG", "ALERT");
        deleteDialogBox.show();
    }

    //Perhaps redundant if/else statements, sets EditText fields
    private void updateUI(Booking booking) {
        if (booking.getBookingId() == null) BookingId.setText("");
        else BookingId.setText(String.valueOf(booking.getBookingId()));

        if (booking.getBookingNo() == null) BookingNo.setText("");
        else BookingNo.setText(booking.getBookingNo());

        if (booking.getBookingDate() == null ) BookingDate.setText("");
        else BookingDate.setText(booking.getBookingDate());

        if (booking.getCustomerId() == null) BookingCustId.setText("");
        else BookingCustId.setText(String.valueOf(booking.getCustomerId()));

        if (booking.getTripTypeId() == null) BookingTripTypeId.setText("");
        else BookingTripTypeId.setText(booking.getTripTypeId());

        if (booking.getPackageId() == null) BookingPackageId.setText("");
        else BookingPackageId.setText(String.valueOf(booking.getPackageId()));

        if (booking.getTravelerCount() == null) BookingTravelerCount.setText("");
        else BookingTravelerCount.setText(String.valueOf(booking.getTravelerCount()));

    }
}