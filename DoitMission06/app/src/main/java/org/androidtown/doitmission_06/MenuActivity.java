package org.androidtown.doitmission_06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 102;
    public static final String TAG = "NAME";
    Button button1, button2, button3;
    String id, pass, menu;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent passedIntent = getIntent();
        processIntent(passedIntent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    public void onButton2Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
        intent.putExtra("menu", "고객 관리");
        intent.putExtra("id", id);
        intent.putExtra("password", pass);
        startActivityForResult(intent, REQUEST_CODE);
        finish();
    }

    public void onButton3Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("password", pass);
        intent.putExtra("menu", "매출 관리");
        startActivityForResult(intent, REQUEST_CODE);
        finish();
    }

    public void onButton4Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
        intent.putExtra("menu", "상품 관리");
        intent.putExtra("id", id);
        intent.putExtra("password", pass);
        startActivityForResult(intent, REQUEST_CODE);
        finish();
    }

    public void processIntent(Intent intent) {
        if (intent != null) {
            id = intent.getStringExtra("id");
            pass = intent.getStringExtra("password");
            menu = intent.getStringExtra("menu");

            Toast.makeText(this, "menu class -> 아이디는 " + id + ",  비밀번호는 " + pass + ", 메뉴는 " + menu, Toast.LENGTH_LONG).show();
        }
    }
}