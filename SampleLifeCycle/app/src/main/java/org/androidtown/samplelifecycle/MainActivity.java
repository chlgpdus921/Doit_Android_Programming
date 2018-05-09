package org.androidtown.samplelifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText nameInput;
    public static final String KEY_SIMPLE_DATA = "data";
    public static final int REQUEST_CODE_MENU = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "OnCreate 호출됨", Toast.LENGTH_LONG).show();
        nameInput = (EditText)findViewById(R.id.nameInput);
    }

    public void onButton1Clicked(View v){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        SimpleData data = new SimpleData(100, "Hello hyeyeon");
        intent.putExtra(KEY_SIMPLE_DATA, data);
        startActivityForResult(intent ,REQUEST_CODE_MENU);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause 호출됨", Toast.LENGTH_LONG).show();
        saveState(); //현재상태저장
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume 호출됨", Toast.LENGTH_LONG).show();
        restoreState(); //다시시작. 데이터복원
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "OnDestroy 호출됨", Toast.LENGTH_LONG).show();
    }

  protected void restoreState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if(pref != null && pref.contains("pref")){
            String name = pref.getString("name", "");
            nameInput.setText(name);
        }
    }
    protected void saveState(){ //입력상자에 입력된 데이터 저장
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();//데이터를 저장할 수 있도록해줌.
        editor.putString("name", nameInput.getText().toString());
        editor.commit();
    }
    protected void clearMyPrefs(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
