package org.androidtown.samplefragment;


import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import static org.androidtown.samplefragment.R.*;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(id.mainFragment);
        menuFragment = new MenuFragment();
    }

    public void onFragmentChanged(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(id.container, menuFragment).commit();
        }
        else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(id.container, mainFragment).commit();
        }
    }


}
