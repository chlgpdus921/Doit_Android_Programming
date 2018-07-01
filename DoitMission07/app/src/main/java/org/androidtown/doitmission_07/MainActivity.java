package org.androidtown.doitmission_07;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, age;
    Button button, store;
    String Name, Age;
 EditText year;
    EditText month;
   EditText day;
   String Year, Day, Month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        button = (Button) findViewById(R.id.button);
        store = (Button) findViewById(R.id.store);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        store.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Name = name.getText().toString();
                Age = age.getText().toString();
                Toast.makeText(getApplicationContext(), "이름: " + Name + "나이: "+Age+ "\n"+Year +"년" + Month +" 월"+Day+" 일", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void show() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("생년월일");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        final View Relative = LayoutInflater.from(this).inflate(R.layout.setdate, null, false);
        builder.setView(Relative);
        final AlertDialog dialog = builder.create();
        dialog.show();

        final Button close = Relative.findViewById(R.id.close);
        final Button set = Relative.findViewById(R.id.set);
        year = Relative.findViewById(R.id.year);
        month = Relative.findViewById(R.id.month);
       day = Relative.findViewById(R.id.day);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialog.dismiss();
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Year = year.getText().toString();
                 Month = month.getText().toString();
                 Day = day.getText().toString();
                button.setText(Year +"년 " + Month +"월 "+Day+"일");
                dialog.dismiss();
            }
        });
    }
}