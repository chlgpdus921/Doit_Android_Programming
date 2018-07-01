package org.androidtown.doitmission_07_1;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name, age;
    Button button, store;
    String Name, Age;
    DatePickerDialog datePickerDialog;
    int y, d, m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        button = (Button) findViewById(R.id.button);
        store = (Button) findViewById(R.id.store);

        SimpleDateFormat simpleDateFormat_y = new SimpleDateFormat("yyyy");
        SimpleDateFormat simpleDateFormat_m = new SimpleDateFormat("MM");
        SimpleDateFormat simpleDateFormat_d = new SimpleDateFormat("dd");
        Calendar cal = Calendar.getInstance();
        y = Integer.parseInt(simpleDateFormat_y.format(cal.getTime()));
        m = Integer.parseInt(simpleDateFormat_m.format(cal.getTime()));
        d = Integer.parseInt(simpleDateFormat_d.format(cal.getTime()));
        button.setText(y + "년 " + m + "월 " + d + "일");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event(v);
            }
        });
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name = name.getText().toString();
                Age = age.getText().toString();
                Toast.makeText(getApplicationContext(), "이름: " + Name + "나이: " + Age + "\n" + button.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void event(View v) {
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                button.setText(year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일");
            }
        };
        datePickerDialog = new DatePickerDialog(this, callBack, y, m - 1, d);
        datePickerDialog.show();
    }
}