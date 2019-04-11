package com.group4.smartaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class ConsumerModeActivity extends AppCompatActivity {


    private TextView mTextMessage;
    final Fragment bookFragment = new BookFragment();
    final Fragment roomFragment = new RoomFragment();
    final Fragment reservationFragment = new ReservationFragment();
    final Fragment accountFragment = new AccountFragment();
    final FragmentManager manager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_mode);
        getSupportActionBar().hide();
        Intent login = getIntent();
        String name = login.getStringExtra(LoginScreenActivity.EMAIL_USED);
        TextView nameText = findViewById(R.id.textView6);
        nameText.setText(name);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_book:
                    manager.beginTransaction().replace(R.id.consumer_container, bookFragment, "book").commit();
                    return true;
                case R.id.navigation_reservations:
                    manager.beginTransaction().replace(R.id.consumer_container, reservationFragment, "reserve").commit();
                    return true;
                case R.id.navigation_room:
                    manager.beginTransaction().replace(R.id.consumer_container, roomFragment, "room").commit();
                    return true;
                case R.id.navigation_account:
                    manager.beginTransaction().replace(R.id.consumer_container, accountFragment, "account").commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent consumer = new Intent(this, ConsumerModeActivity.class);
        startActivity(consumer);
        finish();
    }
}
