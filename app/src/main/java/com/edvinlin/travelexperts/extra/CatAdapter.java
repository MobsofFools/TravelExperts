package com.edvinlin.travelexperts.extra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
    private final Context context;
    private List<Cat> catList;

    public CatAdapter(Context context, List<Cat> catList) {
        this.context = context;
        this.catList = catList;
    }

    public void setCatList(List<Cat> catList) {
        this.catList = catList;
    }

    @NonNull
    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.their_message, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.catFact.setText(catList.get(position).getFact());

    }

    @Override
    public int getItemCount() {
        if (catList != null) {
            return catList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView catFact;

        public ViewHolder(View itemView) {
            super(itemView);
            catFact = itemView.findViewById(R.id.message_body);

        }

    }
}
