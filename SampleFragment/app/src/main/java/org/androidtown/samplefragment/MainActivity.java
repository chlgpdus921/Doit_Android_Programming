package org.androidtown.samplefragment;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
