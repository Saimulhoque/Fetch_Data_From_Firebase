package com.forbitbd.firebase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.forbitbd.firebase.R;
import com.forbitbd.firebase.model.Hotel;
import com.forbitbd.firebase.model.Place;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelHolder> {

    Context context;
    List<Hotel> hotelList;

    public HotelAdapter() {
    }

    public HotelAdapter(Context context, List<Hotel> hotelList) {
        this.context = context;
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public HotelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new HotelAdapter.HotelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelHolder holder, int position) {
        Hotel hotel = hotelList.get(position);
        holder.text1.setText(hotel.getName());
        holder.text2.setText(hotel.getDescription());
        holder.text3.setText(hotel.getLocation());
        holder.text4.setText(hotel.getTime());
        Glide.with(holder.img.getContext()).load(hotel.getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public class HotelHolder extends RecyclerView.ViewHolder {
        TextView text1, text2, text3, text4;
        ImageView img;
        public HotelHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.name);
            text2 = itemView.findViewById(R.id.description);
            text3 = itemView.findViewById(R.id.address);
            text4 = itemView.findViewById(R.id.time);
            img = itemView.findViewById(R.id.image);
        }
    }
}
