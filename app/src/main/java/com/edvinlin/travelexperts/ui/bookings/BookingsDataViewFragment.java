package com.edvinlin.travelexperts.ui.bookings;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edvinlin.travelexperts.R;

public class BookingsDataViewFragment extends Fragment {

    private BookingsDataViewViewModel mViewModel;

    public static BookingsDataViewFragment newInstance() {
        return new BookingsDataViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.data_view_fragment_bookings, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BookingsDataViewViewModel.class);
        // TODO: Use the ViewModel
    }

}