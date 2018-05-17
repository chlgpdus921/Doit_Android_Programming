package org.androidtown.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = getIntent();
        if (passedIntent != null) {
            String loginName = passedIntent.getStringExtra("name");
            String loginAge = passedIntent.getStringExtra("age");
            Toast.makeText(this, "Student info : " + loginName + "," + loginAge, Toast.LENGTH_LONG).show();
        }

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                finish();
            }
        });

    }
}
