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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Booking;
import com.google.gson.Gson;

public class BookingsDataViewFragment extends Fragment {

    private SharedBookingModel sharedBookingModel;
    private EditText BookingId, BookingNo, BookingDate, BookingCustId, BookingTripTypeId, BookingPackageId, BookingTravelerCount;

    public static BookingsDataViewFragment newInstance() {
        return new BookingsDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.data_view_fragment_bookings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Edit Texts
        BookingId = view.findViewById(R.id.etBookingId);
        BookingNo = view.findViewById(R.id.etBookingNo);
        BookingDate = view.findViewById(R.id.etBookingDate);
        BookingCustId = view.findViewById(R.id.etBookingCustId);
        BookingTripTypeId = view.findViewById(R.id.etBookingTripTypeId);
        BookingPackageId = view.findViewById(R.id.etPackageId);
        BookingTravelerCount = view.findViewById(R.id.etTravelerCount);


        //Common Ones
        final CardView back = view.findViewById(R.id.cardBack);
        final Button btnSave = view.findViewById(R.id.btnSave);
        final Button btnDelete = view.findViewById(R.id.btnDelete);

        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_bookings));

        sharedBookingModel = new ViewModelProvider(requireActivity()).get(SharedBookingModel.class);
        sharedBookingModel.getBooking().observe(getViewLifecycleOwner(), booking -> updateUI(booking));
        btnSave.setOnClickListener(v -> {
            Booking booking = new Booking(
                    Integer.parseInt(BookingId.getText().toString()),
                    BookingDate.getText().toString(),
                    BookingNo.getText().toString(),
                    Integer.parseInt(BookingCustId.getText().toString()),
                    Integer.parseInt(BookingPackageId.getText().toString()),
                    Double.parseDouble(BookingTravelerCount.getText().toString()),
                    BookingTripTypeId.getText().toString()
            );
            Gson gson = new Gson();
            String json = gson.toJson(booking);
            Log.d("TAG", booking.toString());
            sharedBookingModel.EditBooking(booking);
            Navigation.findNavController(v).navigate(R.id.navigation_bookings);



        });
        btnDelete.setOnClickListener( v -> {
            int id = Integer.parseInt(BookingId.getText().toString());
            Log.d("TAG", String.valueOf(id));
            DeleteAskOption(id);
        });
    }


    private AlertDialog DeleteAskOption(int id) {
        AlertDialog deleteDialogBox = new AlertDialog.Builder(getContext())
                .setTitle("Delete")
                .setMessage("Do you want to Delete?")
                .setIcon(R.drawable.ic_warning_24px)
                .setPositiveButton("Delete", (dialog, which) -> {
                    sharedBookingModel.DeleteBooking(id);
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .create();
        Log.d("TAG", "ALERT");
        deleteDialogBox.show();
        return deleteDialogBox;
    }
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