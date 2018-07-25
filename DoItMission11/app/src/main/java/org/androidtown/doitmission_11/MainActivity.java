package org.androidtown.doitmission_11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
Button colorBtn, widthBtn;
RadioButton butt, round, square;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorBtn = (Button)findViewById(R.id.colorBtn);
        widthBtn = (Button)findViewById(R.id.widthBtn);
        butt = (RadioButton)findViewById(R.id.butt);
        round = (RadioButton)findViewById(R.id.round);
        square = (RadioButton)findViewById(R.id.square);

        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intent = new Intent(getApplicationContext(), ColorSelect.class);
startActivity(intent);
            }
        });
    }
}
