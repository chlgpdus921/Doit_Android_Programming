package org.androidtown.lab3_2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Information extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.back);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String gender = intent.getExtras().getString("gender");
        String sms = intent.getExtras().getString("sms");
        String email = intent.getExtras().getString("email");
        if (email == null)
            textView.setText("성명    :" + name + "\n" + "성별    :" + gender + "\n수신여부  :" + sms + "\n");
        else if (sms == null)
            textView.setText("성명    :" + name + "\n" + "성별    :" + gender + "\n수신여부  :" + email + "\n");
        else
            textView.setText("성명    :" + name + "\n" + "성별    :" + gender + "\n수신여부  :" + sms + email + "\n");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
