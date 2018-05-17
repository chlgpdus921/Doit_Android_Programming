package org.androidtown.doitmission_06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 103;
Button button, button2;
    String menu, id, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        button = (Button)findViewById(R.id.menuro);
        button2= (Button)findViewById(R.id.loginro);

        Intent processIntent = getIntent();
        ProcessIntent(processIntent);

    }
    public void onButtonMenu(View v){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra("menu",menu);
        intent.putExtra("id",id);
        intent.putExtra("password",password);
        setResult(RESULT_OK, intent);
        startActivityForResult(intent, REQUEST_CODE);
        finish();
    }
    public void onButtonlogin(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("menu",menu);
        intent.putExtra("id",id);
        intent.putExtra("password",password);
        setResult(RESULT_OK, intent);
        startActivityForResult(intent, REQUEST_CODE);
        finish();
    }
    protected void onNewIntent(Intent intent){
        ProcessIntent(intent);
        super.onNewIntent(intent);
    }

    public void ProcessIntent(Intent intent){
        if(intent != null){
            menu = intent.getStringExtra("menu");
            id = intent.getStringExtra("id");
            password = intent.getStringExtra("password");
            Toast.makeText(this, "서브class -> " + "선택하신 메뉴는 "+ menu + ", id 는 " + id + ", 비밀번호는 "+ password, Toast.LENGTH_LONG).show();
        }
    }

}
