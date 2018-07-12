package org.androidtown.lab3_3;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
public Button button, button2;
Fragment_first fragment1;
Fragment_second fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();

    }

    public void init(){
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        fragment1  = new Fragment_first();
        fragment2  = new Fragment_second();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
    }
    private void setListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
            }
        });
    }

}
