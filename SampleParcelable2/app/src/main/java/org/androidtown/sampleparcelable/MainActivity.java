package org.androidtown.sampleparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        SimpleData data = new SimpleData(100, "Hello android!");
        intent.putExtra(KEY_SIMPLE_DATA, data); //putExtra를 사용해 simpledata를 부가데이터로 추가함. -> 객체꺼내서 사용가능.
        startActivityForResult(intent, REQUEST_CODE_MENU);

    }
}
