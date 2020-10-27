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
import com.edvinlin.travelexperts.model.Booking;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class AddBooking extends Fragment {

    private SharedBookingModel sharedBookingModel;
    private EditText BookingNo, BookingDate, BookingCustId, BookingTripTypeId, TravelerCount, PackageId;

    public static AddBooking newInstance() {
        return new AddBooking();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_booking_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedBookingModel = new ViewModelProvider(requireActivity()).get(SharedBookingModel.class);
        //Edit Texts

        BookingNo = view.findViewById(R.id.etaBookingNo);
        BookingDate = view.findViewById(R.id.etaBookingDate);
        BookingCustId = view.findViewById(R.id.etaBookingCustId);
        BookingTripTypeId = view.findViewById(R.id.etaBookingTripTypeId);
        TravelerCount = view.findViewById(R.id.etaTravelerCount);
        PackageId = view.findViewById(R.id.etaPackageId);

        Date c = Calendar.getInstance().getTime();
        BookingDate.setText(c.toString());
        BookingNo.setText(generateBookingNo());

        //Common Ones
        final CardView back = view.findViewById(R.id.cardBack);
        final Button btnAdd = view.findViewById(R.id.btnAdd);

        back.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_bookings));
        btnAdd.setOnClickListener(v -> {
            Booking booking = new Booking(0,
                    BookingDate.getText().toString(),
                    BookingNo.getText().toString(),
                    Integer.parseInt(BookingCustId.getText().toString()),
                    Integer.parseInt(PackageId.getText().toString()),
                    Double.parseDouble(TravelerCount.getText().toString()),
                    BookingTripTypeId.getText().toString()
            );
            sharedBookingModel.AddBooking(booking);

        });
    }
    public String generateBookingNo() {
        int min = 1;
        int max = 4;
        int ran1 = ThreadLocalRandom.current().nextInt(min,max);
        String generatedString = RandomStringUtils.random(ran1, true, false);
        int x = RandomUtils.nextInt(1,9999);

        return generatedString.toUpperCase() + String.valueOf(x);

    }

}