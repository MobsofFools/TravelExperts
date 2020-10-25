package com.edvinlin.travelexperts.ui.travelpackages;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.REST.TravelPackages.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TravelPackagesFragment extends Fragment {

    private TravelPackagesViewModel travelPackagesViewModel;
/*    private RecyclerView rvList;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager layoutManager;*/


    public static TravelPackagesFragment newInstance() {
        return new TravelPackagesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        travelPackagesViewModel = new ViewModelProvider(this).get(TravelPackagesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_travel_packages,container,false);
        final FloatingActionButton addbtn = root.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigation_addpackage);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        travelPackagesViewModel = new ViewModelProvider(this).get(TravelPackagesViewModel.class);
        // TODO: Use the ViewModel
    }

}