package org.androidtown.hello;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v) {
        Toast.makeText(getApplicationContext(), "NICE TO MEET YOU ", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }
    public void onButton2Clicked(View v) {
        Toast.makeText(getApplicationContext(), "전화걸러가자 ", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: 010-9851-0071"));
        startActivity(myIntent);
    }
    public void onButton3Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
    }
}
