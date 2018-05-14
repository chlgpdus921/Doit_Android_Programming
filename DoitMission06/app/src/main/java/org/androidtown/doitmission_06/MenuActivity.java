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
    String id, pass, menu; int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("menu", "고객 관리");
                intent.putExtra("id", id);
                intent.putExtra("password", pass);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("password", pass);
                intent.putExtra("menu", "매출 관리");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("menu", "상품 관리");
                intent.putExtra("id", id);
                intent.putExtra("password", pass);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode == 103){
           Toast.makeText(this, "103" + pass, Toast.LENGTH_LONG).show();
       }
       else if(requestCode ==101)
           Toast.makeText(this, "101" + pass, Toast.LENGTH_LONG).show();
       else {
           Toast.makeText(this, "없어" + pass, Toast.LENGTH_LONG).show();
       }
    }
   /* protected void onNewIntent(Intent intent){
        processIntent(intent);
        super.onNewIntent(intent);
    }*/

    public void processIntent(Intent intent) {
        if (value ==1) {
            if (intent != null) {
                 id = intent.getStringExtra("id");
                 pass = intent.getStringExtra("password");
                Toast.makeText(this, "아이디는 " + id + ",  비밀번호는 " + pass, Toast.LENGTH_LONG).show();
            }
        }
        else if (value ==2) {
            if (intent != null) {
                 id = intent.getStringExtra("id");
                 pass = intent.getStringExtra("password");
                 menu = intent.getStringExtra("menu");

                Toast.makeText(this, "아이디는 " + id + ",  비밀번호는 " + pass + ", 메뉴는 "+ menu, Toast.LENGTH_LONG).show();
            }
        }
    }
}