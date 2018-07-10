package org.androidtown.lab31;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        registerForContextMenu(button);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu");
        menu.add(0, 0, 0, "Red");
        menu.add(0, 1, 1, "Green");
        menu.add(0, 2, 2, "Blue");
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                button.setTextColor(Color.RED);
                return true;
            case 1:
                button.setTextColor(Color.GREEN);
                return true;
            case 2:
                button.setTextColor(Color.BLUE);
                return true;
        }
        return false;
    }
}
