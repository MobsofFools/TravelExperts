package com.edvinlin.travelexperts.ui.bookings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
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

    private SharedBookingModel sharedBookingModel;
    private RecyclerView recyclerView;
    private List<Booking> bookingList;
    private NavController navController;
    private BookingAdapter bookingAdapter;
    private SearchView searchView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_customers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvList);
        navController = Navigation.findNavController(view);

/*        searchView = view.findViewById(R.id.etSearchBar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                bookingAdapter.getFilter().filter(newText);
                return false;
            }
        });*/

        final FloatingActionButton addbtn = view.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addbooking));

        initRecyclerView();

        sharedBookingModel = new ViewModelProvider(requireActivity()).get(SharedBookingModel.class);
        sharedBookingModel.getBookingList().observe(getViewLifecycleOwner(), bookings -> {
            bookingList.clear();
            bookingList.addAll(bookings);
            bookingAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onStart() {
        super.onStart();
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