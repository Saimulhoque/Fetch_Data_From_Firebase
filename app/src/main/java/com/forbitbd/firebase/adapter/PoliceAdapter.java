package com.forbitbd.firebase.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.firebase.ItemClickListener;
import com.forbitbd.firebase.R;
import com.forbitbd.firebase.model.Police;

import java.util.List;

public class PoliceAdapter extends RecyclerView.Adapter<PoliceAdapter.UserHolder> {

    Context context;
    List<Police> policeList;
    private ItemClickListener itemClickListener;

    public PoliceAdapter() {
    }

    public PoliceAdapter(Context context, List<Police> policeList, ItemClickListener itemClickListener) {
        this.context = context;
        this.policeList = policeList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_police,parent,false);
       return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
       Police police = policeList.get(position);
        holder.text1.setText(police.getName());
        holder.text2.setText(police.getDesignation());
        holder.text3.setText(police.getPhone());
    }

    @Override
    public int getItemCount() {
        return policeList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        TextView text1, text2, text3;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.name);
            text2 = itemView.findViewById(R.id.designation);
            text3 = itemView.findViewById(R.id.phone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.OnItemClick(policeList.get(getAdapterPosition()));
                }
            });
        }
    }
}
