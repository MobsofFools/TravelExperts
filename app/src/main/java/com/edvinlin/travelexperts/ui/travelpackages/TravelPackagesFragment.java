package com.edvinlin.travelexperts.ui.travelpackages;

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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.TravelPackage;
import com.edvinlin.travelexperts.model.listview.OnRecyclerItemClickListener;
import com.edvinlin.travelexperts.model.listview.PackageAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TravelPackagesFragment extends Fragment implements OnRecyclerItemClickListener {

    private SharedPackageModel sharedPackageModel;
    private RecyclerView recyclerView;
    private List<TravelPackage> packageList;
    private NavController navController;
    private PackageAdapter packageAdapter;
    private EditText searchBar;
    private ImageView ivRefresh;


    public static TravelPackagesFragment newInstance() {
        return new TravelPackagesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        sharedPackageModel = new ViewModelProvider(requireActivity()).get(SharedPackageModel.class);
        recyclerView = view.findViewById(R.id.rvList);
        navController = Navigation.findNavController(view);

        searchBar = view.findViewById(R.id.etSearch);

        ivRefresh = view.findViewById(R.id.ivRefresh);
        ivRefresh.setOnClickListener(v -> {
            loadPackages();
            searchBar.setText("");
        });

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (packageAdapter != null) {
                    packageAdapter.getFilter().filter(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final FloatingActionButton addBtn = view.findViewById(R.id.fabAdd);
        addBtn.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.navigation_addpackage));

        initRecyclerView();
        loadPackages();

    }


    @Override
    public void onStart() {
        super.onStart();
        sharedPackageModel = new ViewModelProvider(requireActivity()).get(SharedPackageModel.class);
        loadPackages();
    }

    private void loadPackages() {
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