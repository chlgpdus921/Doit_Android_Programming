package org.androidtown.samplereceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {
    EditText content, number, time;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        content = (EditText) findViewById(R.id.content);
        number = (EditText) findViewById(R.id.number);
        time = (EditText) findViewById(R.id.time);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent passedIntent = getIntent();
        processedIntent(passedIntent);
    }

    public void onNewIntent(Intent intent) {
        processedIntent(intent);
        super.onNewIntent(intent);
    }

    private void processedIntent(Intent intent) {
        if (intent != null) {
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receivedDate = intent.getStringExtra("receivedDate");

            number.setText(sender);
            content.setText(contents);
            time.setText(receivedDate);
        }
    }
}
