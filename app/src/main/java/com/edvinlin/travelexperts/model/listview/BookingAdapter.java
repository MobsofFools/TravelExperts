package com.edvinlin.travelexperts.model.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edvinlin.travelexperts.R;
import com.edvinlin.travelexperts.model.Booking;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.mViewHolder> {

    OnRecyclerItemClickListener onItemClickListener;
    private Context context;
    private List<Booking> bookingList;

    public BookingAdapter(Context context, List<Booking> list, OnRecyclerItemClickListener onItemClickListener) {
        this.context = context;
        this.bookingList = list;
        this.onItemClickListener = onItemClickListener;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookingAdapter.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_item,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookingAdapter.mViewHolder holder, int position) {
        holder.bookingNo.setText(bookingList.get(position).getBookingNo());

    }
    @Override
    public int getItemCount() {
        if(bookingList != null){
            return bookingList.size();
        }
        return 0;
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        TextView bookingNo;


        public mViewHolder(View itemView) {
            super(itemView);
            bookingNo = itemView.findViewById(R.id.item1);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(getAdapterPosition()));


        }
    }
}

