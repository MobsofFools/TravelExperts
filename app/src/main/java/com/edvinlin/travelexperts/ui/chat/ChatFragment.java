package com.edvinlin.travelexperts.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.extra.Cat;
import com.edvinlin.travelexperts.extra.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private ChatViewModel chatViewModel;
    private RecyclerView recyclerView;
    private List<Cat> catList;
    private CatAdapter catAdapter;
    private ImageView ivSend;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        chatViewModel = new ViewModelProvider(requireActivity()).get(ChatViewModel.class);
        recyclerView = view.findViewById(R.id.messages_view);
        ivSend = view.findViewById(R.id.ivSend);
        ivSend.setOnClickListener(v -> loadCatFact());

        initRecyclerView();
        loadCatFact();
    }


    private void loadCatFact() {
        chatViewModel.getCatFact().observe(getViewLifecycleOwner(), cat1 -> {
            catList.clear();
            catList.add(cat1);
            catAdapter.notifyDataSetChanged();
        });

    }

    private void initRecyclerView() {
        catList = new ArrayList<>();
        catAdapter = new CatAdapter(getContext(), catList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(catAdapter);
    }
}