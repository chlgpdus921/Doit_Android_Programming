package org.androidtown.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    CheckBox sms, email;
    RadioButton boy, girl;
    Button button;
    String n, b, s, e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        boy = (RadioButton) findViewById(R.id.boy);
        girl = (RadioButton) findViewById(R.id.girl);
        sms = (CheckBox) findViewById(R.id.sms);
        email = (CheckBox) findViewById(R.id.email);
        button = (Button) findViewById(R.id.button);

        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boy.isChecked()) {
                    b = boy.getText().toString();
                } else {
                }
            }
        });
        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (girl.isChecked()) {
                    b = girl.getText().toString();
                } else {
                }
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sms.isChecked()) {
                    s = sms.getText().toString();
                } else {
                    s = null;
                }
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.isChecked()) {
                    e = email.getText().toString();
                } else {
                    e = null;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Information.class);
                n = name.getText().toString();
                intent.putExtra("name", n);
                intent.putExtra("gender", b);
                intent.putExtra("sms", s);
                intent.putExtra("email", e);
                startActivity(intent);

            }
        });

    }
}
