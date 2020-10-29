package com.edvinlin.travelexperts.ui.bookings;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Booking;
import com.edvinlin.travelexperts.model.listview.BookingAdapter;
import com.edvinlin.travelexperts.model.listview.OnRecyclerItemClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class BookingsFragment extends Fragment implements OnRecyclerItemClickListener {

    //Declare Items
    private SharedBookingModel sharedBookingModel;
    private RecyclerView recyclerView;
    private List<Booking> bookingList;
    private BookingAdapter bookingAdapter;
    private EditText searchBar;
    private ImageView ivRefresh;
    private FloatingActionButton addBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Show Action Bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        //Hide <- Arrow
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        //Instantiate Shared View Model
        sharedBookingModel = new ViewModelProvider(requireActivity()).get(SharedBookingModel.class);

        //Link to UI Item
        recyclerView = view.findViewById(R.id.rvList);
        searchBar = view.findViewById(R.id.etSearch);
        ivRefresh = view.findViewById(R.id.ivRefresh);
        addBtn = view.findViewById(R.id.fabAdd);

        //Set On Click Listener to reload Bookings, and reset search bar text
        ivRefresh.setOnClickListener(v -> {
            loadBookings();
            searchBar.setText("");
        });

        //Navigate to Add Booking Fragment
        addBtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addbooking));

        //Call RecyclerView Initialization Method
        initRecyclerView();

        //Call getBookingList API call from Shared View Model
        loadBookings();

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (bookingAdapter != null) {
                    bookingAdapter.getFilter().filter(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    //On navigation back to page, reload bookings
    @Override
    public void onStart() {
        super.onStart();
        loadBookings();
    }

    //On recyclerview item click, set MutableLiveData and navigate to dataview
    @Override
    public void onItemClick(int position) {
        sharedBookingModel.setBooking(position);
        Navigation.findNavController(getView()).navigate(R.id.action_navigation_bookings_to_navigation_bookingsdataview);
    }

    private void loadBookings() {
        //Uses getBookingList function to set MutableLiveData
        sharedBookingModel.getBookingList().observe(getViewLifecycleOwner(), bookings -> {
            //Clears existing list to prevent duplication
            bookingList.clear();
            //Gets from MutableLiveData mutableBookingList
            bookingList.addAll(bookings);
            bookingAdapter.notifyDataSetChanged();
        });
    }

    private void initRecyclerView() {
        bookingList = new ArrayList<>();
        //Instantiates Booking Adapter
        bookingAdapter = new BookingAdapter(getContext(),bookingList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(bookingAdapter);
    }


}