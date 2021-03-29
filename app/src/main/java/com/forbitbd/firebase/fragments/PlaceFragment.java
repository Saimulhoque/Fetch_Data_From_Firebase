package com.forbitbd.firebase.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.firebase.ItemClickListener;
import com.forbitbd.firebase.R;
import com.forbitbd.firebase.adapter.PlaceAdapter;
import com.forbitbd.firebase.adapter.PoliceAdapter;
import com.forbitbd.firebase.model.News;
import com.forbitbd.firebase.model.Place;
import com.forbitbd.firebase.model.Police;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PlaceFragment extends Fragment {

    ArrayList<Place> placeList;
    PlaceAdapter adapter;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    public PlaceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        placeList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("place");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Place place = snapshot.getValue(Place.class);
                    placeList.add(place);
                }
                adapter = new PlaceAdapter(getContext(),placeList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;

    }
}