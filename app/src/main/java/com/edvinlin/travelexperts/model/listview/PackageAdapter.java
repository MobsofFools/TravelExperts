package com.edvinlin.travelexperts.model.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.TravelPackage;

import java.util.List;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.mViewHolder> {

    private Context context;
    private List<TravelPackage> packageList;

    public PackageAdapter(Context context, List<TravelPackage> list) {
        this.context = context;
        this.packageList = list;
    }

    public void setPackageList(List<TravelPackage> packageList) {
        this.packageList = packageList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PackageAdapter.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PackageAdapter.mViewHolder holder, int position) {
        holder.packageName.setText(packageList.get(position).getPkgName());
        holder.packageStartDate.setText(packageList.get(position).getPkgStartDate());

    }
    @Override
    public int getItemCount() {
        if(packageList != null){
            return packageList.size();
        }
        return 0;
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        TextView packageName;
        TextView packageStartDate;


        public mViewHolder(View itemView) {
            super(itemView);
            packageName = itemView.findViewById(R.id.item1);
            packageStartDate = itemView.findViewById(R.id.item2);

        }
    }
}

