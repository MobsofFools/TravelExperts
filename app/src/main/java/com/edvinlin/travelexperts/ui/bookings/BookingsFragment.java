package com.edvinlin.travelexperts.ui.bookings;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Booking;
import com.edvinlin.travelexperts.model.listview.BookingAdapter;

import com.edvinlin.travelexperts.remote.ApiClient;
import com.edvinlin.travelexperts.remote.ApiInterface;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingsFragment extends Fragment implements BookingAdapter.OnItemClickListener{

    private SharedBookingModel sharedBookingModel;
    private RecyclerView recyclerView;
    private List<Booking> bookingList;
    private NavController navController;
    private BookingAdapter bookingAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_customers, container, false);
        recyclerView = root.findViewById(R.id.rvList);
        final FloatingActionButton addbtn = root.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addbooking));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        initRecyclerView();

        sharedBookingModel = new ViewModelProvider(requireActivity()).get(SharedBookingModel.class);
        sharedBookingModel.getBookingList().observe(getViewLifecycleOwner(), bookings -> {
            bookingList.clear();
            bookingList.addAll(bookings);
            bookingAdapter.notifyDataSetChanged();
        });
    }

    private void initRecyclerView() {
        // Setting up Recycler View
        bookingList = new ArrayList<>();
        bookingAdapter = new BookingAdapter(getContext(),bookingList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(bookingAdapter);
    }

    @Override
    public void onItemClick(int position) {
        sharedBookingModel.setBooking(position);
        navController.navigate(R.id.action_navigation_bookings_to_navigation_bookingsdataview);
    }
}
