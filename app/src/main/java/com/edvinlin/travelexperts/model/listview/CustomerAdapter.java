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

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.mViewHolder> implements Filterable {
    final OnRecyclerItemClickListener onItemClickListener;
    private final Context context;
    private List<Customer> customerList;
    private List<Customer> customerListFull;

    public void setCustomerListFull(List<Customer> customerListFull) {
        this.customerListFull = customerListFull;
    }

    public CustomerAdapter(Context context, List<Customer> list, OnRecyclerItemClickListener onItemClickListener) {
        this.context = context;
        this.customerList = list;
        this.onItemClickListener = onItemClickListener;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomerAdapter.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item,parent,false);
        return new CustomerAdapter.mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.customerName.setText(customerList.get(position).getCustFirstName() + " " +customerList.get(position).getCustLastName());
        holder.phoneNo.setText(customerList.get(position).getCustHomePhone());
    }

    @Override
    public int getItemCount() {
        if(customerList != null){
            return customerList.size();
        }
        return 0;
    }

    private final Filter myFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Customer> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(customerListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Customer customer : customerListFull) {
                    if (customer.getCustFirstName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(customer);
                    }
                    if (customer.getCustLastName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(customer);

                    }
                }
            }
                FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            customerList.clear();
            customerList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        setCustomerListFull(customerList);
        return myFilter;
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        final TextView customerName;
        final TextView phoneNo;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            customerName = itemView.findViewById(R.id.item1);
            phoneNo = itemView.findViewById(R.id.item2);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(getAdapterPosition()));

        }

    }
}
