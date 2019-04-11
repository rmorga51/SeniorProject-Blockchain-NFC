package com.group4.smartaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RoomFragment extends Fragment {

    public RoomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        getActivity().setTitle("Rooms");
        View rooms = inflater.inflate(R.layout.fragment_room, container, false);
        View room322 = rooms.findViewById(R.id.textView10);
        View room455 = rooms.findViewById(R.id.textView11);
        room322.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewRoom(view);
            }
        });
        // Inflate the layout for this fragment
        return rooms;
    }

    public void viewRoom (View view){
        Intent viewRoom = new Intent(getActivity(), ViewRoomActivity.class);
        RoomFragment.this.startActivity(viewRoom);
    }
}
