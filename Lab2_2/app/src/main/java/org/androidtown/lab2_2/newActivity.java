package org.androidtown.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class newActivity extends AppCompatActivity {
    TextView textView;
    Button goBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = (TextView) findViewById(R.id.textView);
        goBtn = (Button) findViewById(R.id.button2);
        backBtn = (Button) findViewById(R.id.button3);

       final Intent passedIntent = getIntent();
       final String url = passedIntent.getStringExtra("url");
        textView.setText(url);

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.length() == 0) {
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요.", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));
                    startActivity(intent);
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다. ", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
