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

    private Context context;
    private List<Customer> customerList;
    private OnListListener mOnListListener;

    public CustomerAdapter(Context context, List<Customer> list, OnListListener onListListener) {
        this.context = context;
        this.customerList = list;
        this.mOnListListener = onListListener;
    }

    public void setBookingList(List<Customer> customerList) {
        this.customerList = customerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomerAdapter.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item,parent,false);
        return new CustomerAdapter.mViewHolder(view, mOnListListener);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.customerName.setText(customerList.get(position).toString());
        holder.phoneNo.setText(customerList.get(position).getCustHomePhone());
    }

    @Override
    public int getItemCount() {
        if(customerList != null){
            return customerList.size();
        }
        return 0;
    }

    public class mViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView customerName;
        TextView phoneNo;
        OnListListener onListListener;
        public mViewHolder(@NonNull View itemView, OnListListener onListListener) {
            super(itemView);
            customerName= itemView.findViewById(R.id.item1);
            phoneNo = itemView.findViewById(R.id.item2);
            this.onListListener = onListListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListListener.onListClick(getAdapterPosition());

        }
    }
    public interface OnListListener {
        void onListClick(int position);

    }
}
