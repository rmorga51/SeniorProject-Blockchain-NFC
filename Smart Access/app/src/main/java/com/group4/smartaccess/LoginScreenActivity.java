package com.group4.smartaccess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginScreenActivity extends AppCompatActivity {
    public static final String EMAIL_USED = "com.example.cmbhprototype.EMAIL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        setTitle("Login");
    }
    public void login (View view){
        Intent consumer = new Intent(this, ConsumerModeActivity.class);
        Intent kiosk = new Intent(this, KioskModeActivity.class);
        Intent admin = new Intent(this, AdminModeActivity.class);
        EditText email = (EditText) findViewById(R.id.email);
        String emailEntered = email.getText().toString();
        if(emailEntered.equals("consumer@consumer.com")){
            consumer.putExtra(EMAIL_USED, "Carter");
            startActivity(consumer);
        }
        else if(emailEntered.equals("kiosk@kiosk.com")){
            startActivity(kiosk);
        }
        else if(emailEntered.equals("admin@admin.com")){
            startActivity(admin);
        }
    }
}
