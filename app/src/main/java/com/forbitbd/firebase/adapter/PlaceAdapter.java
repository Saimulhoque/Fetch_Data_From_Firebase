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
import com.forbitbd.firebase.model.Place;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder> {

    Context context;
    List<Place> placeList;

    public PlaceAdapter() {
    }

    public PlaceAdapter(Context context, List<Place> placeList) {
        this.context = context;
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new PlaceAdapter.PlaceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
        Place place = placeList.get(position);
        holder.text1.setText(place.getName());
        holder.text2.setText(place.getDescription());
        holder.text3.setText(place.getAddress());
        holder.text4.setText(place.getDfc());
        Glide.with(holder.img.getContext()).load(place.getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public class PlaceHolder extends RecyclerView.ViewHolder {

        TextView text1, text2, text3, text4;
        ImageView img;

        public PlaceHolder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.name);
            text2 = itemView.findViewById(R.id.description);
            text3 = itemView.findViewById(R.id.address);
            text4 = itemView.findViewById(R.id.time);
            img = itemView.findViewById(R.id.image);
        }
    }
}
