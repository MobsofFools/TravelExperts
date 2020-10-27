package com.edvinlin.travelexperts.ui.travelpackages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.TravelPackage;
import com.edvinlin.travelexperts.model.listview.PackageAdapter;
import com.edvinlin.travelexperts.remote.ApiClient;
import com.edvinlin.travelexperts.remote.ApiInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TravelPackagesFragment extends Fragment {

    private TravelPackagesViewModel travelPackagesViewModel;
    private RecyclerView recyclerView;
    private List<TravelPackage> packageList;
    PackageAdapter packageAdapter;


    public static TravelPackagesFragment newInstance() {
        return new TravelPackagesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_travel_packages,container,false);
        recyclerView = root.findViewById(R.id.rvList);
        initRecyclerView();
        getPackageList();
        final FloatingActionButton addbtn = root.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addpackage));

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        travelPackagesViewModel = new ViewModelProvider(this).get(TravelPackagesViewModel.class);
        // TODO: Use the ViewModel
    }
    private void initRecyclerView()
    {
        // Setting up Recycler View
        packageList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        packageAdapter = new PackageAdapter(getContext(),packageList);
        recyclerView.setAdapter(packageAdapter);
    }
    private void getPackageList() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<TravelPackage>> call = apiService.getTravelPackages();
        call.enqueue(new Callback<List<TravelPackage>>() {
            @Override
            public void onResponse(Call<List<TravelPackage>> call, Response<List<TravelPackage>> response) {
                packageList = response.body();
                Log.d("TAG","Response = " +packageList);
                packageAdapter.setPackageList(packageList);
            }

            @Override
            public void onFailure(Call<List<TravelPackage>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

}