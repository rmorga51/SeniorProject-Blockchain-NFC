package com.group4.smartaccess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RoomsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        setTitle("Rooms");
    }
    public void viewRoom (View view){
        Intent viewRoom = new Intent(this, ViewRoomActivity.class);
        startActivity(viewRoom);
    }
}
