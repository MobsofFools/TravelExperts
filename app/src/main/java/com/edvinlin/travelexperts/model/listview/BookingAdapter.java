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
import com.edvinlin.travelexperts.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.mViewHolder> implements Filterable {

    final OnRecyclerItemClickListener onItemClickListener;
    private final Context context;
    private List<Booking> bookingList;
    private List<Booking> bookingListFull;


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
// Filter Start
    public void setBookingListFull(List<Booking> bookingListFull) {
        this.bookingListFull = bookingListFull;
    }

    private final Filter myFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Booking> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(bookingListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Booking booking : bookingListFull) {
                    if (booking.getBookingNo().toLowerCase().contains(filterPattern)) {
                        filteredList.add(booking);
                    }

                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            bookingList.clear();
            bookingList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        setBookingListFull(bookingList);
        return myFilter;
    }
//Filter End

    //Set View Holder
    public class mViewHolder extends RecyclerView.ViewHolder {
        //Number of items in recyclerview item
        final TextView bookingNo;


        public mViewHolder(View itemView) {
            super(itemView);
            bookingNo = itemView.findViewById(R.id.item1);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(getAdapterPosition()));


        }
    }
}

