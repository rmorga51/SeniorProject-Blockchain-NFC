package com.royce.nfcapp_04;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback {
    TextView textView;
    EditText editText;
    String message = "This is a display test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter == null){
            Toast.makeText(this, "NFC is not enabled! :(", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "NFC is enabled! :)", Toast.LENGTH_SHORT).show();
        }

        /*// Create some ndef records
        NdefRecord record1 = NdefRecord.createMime("application/vnd.com.royce.nfcapp_04", message.getBytes());
        NdefMessage msg = new NdefMessage(record1);*/

        /*// takes an NDEF message and an activity
        nfcAdapter.setNdefPushMessage(msg, this);*/

        // Set Callback
        nfcAdapter.setNdefPushMessageCallback( this, this);



    }

    public NdefMessage createNdefMessage(NfcEvent event){
        editText = findViewById(R.id.editText);
        String text = editText.getText().toString();

        // Create some NDEF records
        NdefRecord record1 = NdefRecord.createMime("application/vnd.com.royce.nfcapp_04", text.getBytes());
        NdefMessage msg = new NdefMessage(record1);
        return msg;

    }

    @Override
    protected void onResume() { // Foreground state
        super.onResume();

        if(NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())){
            processIntent(getIntent());
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        //super.onNewIntent(intent);
        setIntent(intent);
    }

    void processIntent(Intent intent){
        textView = findViewById(R.id.textView);
        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        // Only one message sent during the beam
        NdefMessage msg = (NdefMessage) rawMsgs[0];
        // Record 0 contains the MIME type, record 1 is the AAr, if present
        textView.setText(new String(msg.getRecords()[0].getPayload()));
    }
}
