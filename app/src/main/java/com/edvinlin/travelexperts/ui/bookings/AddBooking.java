package com.edvinlin.travelexperts.ui.bookings;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.edvinlin.travelexperts.model.TripType;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AddBooking extends Fragment {

    private SharedBookingModel sharedBookingModel;
    private EditText BookingNo, BookingDate, BookingCustId, BookingTripTypeId, TravelerCount, PackageId;
    //Watches for onTextChanged in specified EditTexts
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String i1 = BookingDate.getText().toString();
            String i2 = BookingNo.getText().toString();
            String i3 = BookingCustId.getText().toString();
            String i4 = PackageId.getText().toString();
            String i5 = TravelerCount.getText().toString();
            String i6 = BookingTripTypeId.getText().toString();
            Button btnAdd = getView().findViewById(R.id.btnAdd);

            //Enables btnAdd when all fields contain something
            btnAdd.setEnabled(!i1.isEmpty() && !i2.isEmpty() && !i3.isEmpty()
                    && !i4.isEmpty() && !i5.isEmpty() && !i6.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_booking_fragment, container, false);
    }

    private List<TripType> tripTypeList;

    private String getCurrentDate() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date c = Calendar.getInstance().getTime();
        return simpleDateFormat.format(c);
    }

    //Randomly generate BookingNo
    public String generateBookingNo() {
        //Generates number between 1-4 for Alphabetical Part of Booking Number
        int min = 1;
        int max = 4;
        int ran1 = ThreadLocalRandom.current().nextInt(min, max);
        String generatedString = RandomStringUtils.random(ran1, true, false);

        //Generates random number between 1-9999
        int x = RandomUtils.nextInt(1, 9999);

        //Returns Booking No (ABC1234)
        return generatedString.toUpperCase() + x;

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


        //Generate current date
        String date = getCurrentDate();
        BookingDate.setText(date);
        //Randomly generate booking number
        BookingNo.setText(generateBookingNo());

        //Text watcher to enable add button when all fields are full
        BookingNo.addTextChangedListener(textWatcher);
        BookingDate.addTextChangedListener(textWatcher);
        BookingCustId.addTextChangedListener(textWatcher);
        BookingTripTypeId.addTextChangedListener(textWatcher);
        TravelerCount.addTextChangedListener(textWatcher);
        PackageId.addTextChangedListener(textWatcher);

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
                    Integer.parseInt(TravelerCount.getText().toString()),
                    BookingTripTypeId.getText().toString()
            );
            sharedBookingModel.AddBooking(booking, getContext());
            sharedBookingModel.setBookingAdded(booking);
            Log.d("TAG", booking.toString());
            Navigation.findNavController(view).navigate(R.id.navigation_bookings);

        });
    }
}