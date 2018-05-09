package org.androidtown.samplelifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    Button button2;
    TextView textView2;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button2 = (Button) findViewById(R.id.button2);
        textView2 = (TextView) findViewById(R.id.textView2);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "mike");

                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Intent intent = getIntent();
        processIntent(intent);
    }

    public void processIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();

            SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA);

            textView2.setText(data.getNumber() + "\n" + data.getMessage());
        }
    }


}
