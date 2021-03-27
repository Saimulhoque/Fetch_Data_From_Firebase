package com.forbitbd.firebase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> userList;
    UserAdapter adapter;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        userList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    userList.add(user);
                }

                adapter=new UserAdapter(getApplicationContext(), userList, new ItemClickListener() {
                    @Override
                    public void OnItemClick(User user) {
                        dialcall(user.getPhone());
                    }
                });
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




//        FirebaseRecyclerOptions<User> options =
//                new FirebaseRecyclerOptions.Builder<User>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("users"), User.class)
//                        .build();

//        adapter = new UserAdapter(options);
//        UserAdapter adapter = new UserAdapter(this,userList);
//        recyclerView.setAdapter(adapter);
//        DatabaseReference myDatabaseRef = FirebaseDatabase.getInstance().getReference().child("users");
//        myDatabaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                userList.clear();
//                for (DataSnapshot snapshot : dataSnapshot .getChildren()){
//                    userList.get(Integer.parseInt(snapshot.getValue().toString()));
//                }
//                adapter.notifyDataSetChanged();
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }

    private void dialcall(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:"+phone));
        startActivity(intent);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }
}