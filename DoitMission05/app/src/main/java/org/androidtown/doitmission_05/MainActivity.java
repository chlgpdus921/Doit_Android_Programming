package org.androidtown.doitmission_05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button login;
public static final int REQUEST_CODE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.Login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    startActivityForResult(intent, REQUEST_CODE);
                }
        });

        Intent passedintent = getIntent();
    processedIntent(passedintent);


    }
    public void onNewIntent(Intent intent){
        processedIntent(intent);
        super.onNewIntent(intent);
    }

    private void processedIntent(Intent intent) {
        if (intent != null) {
            String content = intent.getStringExtra("content");
            Toast.makeText(this, "선택하신 메뉴는 " + content, Toast.LENGTH_LONG).show();
        }
    }
}
