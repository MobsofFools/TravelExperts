package com.edvinlin.travelexperts.model.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Customer;
import com.edvinlin.travelexperts.model.TravelPackage;

import java.util.ArrayList;
import java.util.List;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.mViewHolder> implements Filterable {

    OnRecyclerItemClickListener onRecyclerItemClickListener;
    private Context context;
    private List<TravelPackage> packageList;
    private List<TravelPackage> packageListFull;

    public PackageAdapter(Context context, List<TravelPackage> list, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.context = context;
        this.packageList = list;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public void setPackageListFull(List<TravelPackage> packageListFull) {
        this.packageListFull = packageListFull;
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
            itemView.setOnClickListener(v -> onRecyclerItemClickListener.onItemClick(getAdapterPosition()));

        }
    }
    @Override
    public Filter getFilter() {
        setPackageListFull(packageList);
        return myFilter;
    }
    private Filter myFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<TravelPackage> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(packageListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (TravelPackage travelPackage : packageListFull) {
                    if (travelPackage.getPkgName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(travelPackage);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            packageList.clear();
            packageList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}

