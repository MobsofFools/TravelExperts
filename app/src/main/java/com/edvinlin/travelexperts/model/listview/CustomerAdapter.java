package com.edvinlin.travelexperts.model.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Customer;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.mViewHolder> {
    OnRecyclerItemClickListener onItemClickListener;
    private Context context;
    private List<Customer> customerList;


    public CustomerAdapter(Context context, List<Customer> list, OnRecyclerItemClickListener onItemClickListener) {
        this.context = context;
        this.customerList = list;
        this.onItemClickListener = onItemClickListener;
    }

    public void setBookingList(List<Customer> customerList) {
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

    public class mViewHolder extends RecyclerView.ViewHolder{
        TextView customerName;
        TextView phoneNo;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            customerName= itemView.findViewById(R.id.item1);
            phoneNo = itemView.findViewById(R.id.item2);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(getAdapterPosition()));

        }

    }
}
