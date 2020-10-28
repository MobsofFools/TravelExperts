package com.edvinlin.travelexperts.ui.travelpackages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.TravelPackage;
import com.edvinlin.travelexperts.model.listview.OnRecyclerItemClickListener;
import com.edvinlin.travelexperts.model.listview.PackageAdapter;
import com.edvinlin.travelexperts.remote.ApiClient;
import com.edvinlin.travelexperts.remote.ApiInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TravelPackagesFragment extends Fragment implements OnRecyclerItemClickListener {

    private SharedPackageModel sharedPackageModel;
    private RecyclerView recyclerView;
    private List<TravelPackage> packageList;
    private NavController navController;
    private PackageAdapter packageAdapter;


    public static TravelPackagesFragment newInstance() {
        return new TravelPackagesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_travel_packages,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvList);
        navController = Navigation.findNavController(view);
        final FloatingActionButton addbtn = view.findViewById(R.id.fabAdd);
        addbtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addpackage));
        initRecyclerView();

        sharedPackageModel = new ViewModelProvider(requireActivity()).get(SharedPackageModel.class);
        sharedPackageModel.getPackageList().observe(getViewLifecycleOwner(), travelPackages -> {
            packageList.clear();
            packageList.addAll(travelPackages);
            packageAdapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        sharedPackageModel = new ViewModelProvider(requireActivity()).get(SharedPackageModel.class);
        sharedPackageModel.getPackageList().observe(getViewLifecycleOwner(), travelPackages -> {
            packageList.clear();
            packageList.addAll(travelPackages);
            packageAdapter.notifyDataSetChanged();
        });
    }

    private void initRecyclerView()
    {
        // Setting up Recycler View
        packageList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        packageAdapter = new PackageAdapter(getContext(),packageList,this);
        recyclerView.setAdapter(packageAdapter);
    }

    @Override
    public void onItemClick(int position) {
        sharedPackageModel.setPackage(position);
        navController.navigate(R.id.action_navigation_packages_to_navigation_packagedataview);

    }

}