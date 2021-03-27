package com.forbitbd.firebase;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    Context context;
    List<User> userList;
    private ItemClickListener itemClickListener;

    public UserAdapter(Context context, List<User> userList, ItemClickListener itemClickListener) {
        this.context = context;
        this.userList = userList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
       return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
       User user = userList.get(position);
        holder.text1.setText(user.getName());
        holder.text2.setText(user.getEmail());
        holder.text3.setText(user.getPhone());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        TextView text1, text2, text3;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.name);
            text2 = itemView.findViewById(R.id.email);
            text3 = itemView.findViewById(R.id.phone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.OnItemClick(userList.get(getAdapterPosition()));
                }
            });
        }
    }
}
