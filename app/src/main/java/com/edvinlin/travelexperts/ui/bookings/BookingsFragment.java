package com.edvinlin.travelexperts.ui.bookings;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

public class BookingsFragment extends Fragment {

    private BookingsViewModel bookingsViewModel;
    private RecyclerView recyclerView;
    private List<Booking> bookingList;
    BookingAdapter bookingAdapter;

    public static BookingsFragment newInstance() {
        return new BookingsFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_customers, container, false);

        recyclerView = root.findViewById(R.id.rvList);

        initRecyclerView();

        getBookingList();


        final FloatingActionButton addbtn = root.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addbooking));

        return root;
    }

    private void getBookingList() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Booking>> call = apiService.getBookings();
        call.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {
            bookingList = response.body();
            Log.d("TAG","Response = " +bookingList);
            bookingAdapter.setBookingList(bookingList);
            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

    private void initRecyclerView() {
        // Setting up Recycler View
        bookingList = new ArrayList<>();
        bookingAdapter = new BookingAdapter(getContext(),bookingList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(bookingAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bookingsViewModel = new ViewModelProvider(this).get(BookingsViewModel.class);
        // TODO: Use the ViewModel
/*        if (savedInstanceState !=null) {

        }*/
    }
}
