package org.techtown.tutorial.paintboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_main);

        // 1단계 버튼 눌렀을 때 PaintBoard 보여주기
        Button step01Button = (Button) findViewById(R.id.step01Button);
        step01Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaintBoardActivity.class);
                startActivity(intent);
            }
        });

        // 2단계 버튼 눌렀을 때 GoodPaintBoard 보여주기
        Button step02Button = (Button) findViewById(R.id.step02Button);
        step02Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GoodPaintBoardActivity.class);
                startActivity(intent);
            }
        });

        // 3단계 버튼 눌렀을 때 BestPaintBoard 보여주기
        Button step03Button = (Button) findViewById(R.id.step03Button);
        step03Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BestPaintBoardActivity.class);
                startActivity(intent);
            }
        });

    }


}
