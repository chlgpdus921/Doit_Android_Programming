package org.androidtown.doitmission_11;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button colorBtn, widthBtn;
    RadioButton butt, round, square;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorBtn = (Button) findViewById(R.id.colorBtn);
        widthBtn = (Button) findViewById(R.id.widthBtn);
        butt = (RadioButton) findViewById(R.id.butt);
        round = (RadioButton) findViewById(R.id.round);
        square = (RadioButton) findViewById(R.id.square);
        textView = (TextView) findViewById(R.id.check);
        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ColorSelect.class);
                startActivity(intent);
            }
        });
        widthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Width.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 || resultCode == RESULT_OK) {
            int width = data.getIntExtra("width", -1);
            textView.setText(width + " ");
        }
    }
}
