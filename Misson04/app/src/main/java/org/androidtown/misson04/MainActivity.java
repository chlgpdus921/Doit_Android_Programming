package org.androidtown.misson04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        editText.addTextChangedListener(watcher);

    }
    public void Button2onClicked(View v){
        finish();
    }
    public void Button1onClicked(View v){
        String letter = editText.getText().toString();
        Toast.makeText(getApplicationContext(),"입력하신 메세지는\n\n" + letter, Toast.LENGTH_LONG).show();
    }
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            InputFilter lengthFilter = new InputFilter.LengthFilter(80);
            InputFilter[] filters = new InputFilter[]{lengthFilter};
            editText.setFilters(filters);

            String letter = editText.getText().toString();

            if (s.length() > 80) {
                Toast.makeText(MainActivity.this, "80자 까지만 입력 가능합니다.", Toast.LENGTH_SHORT).show();
            }
            textView.setText(s.length() + " / 80 바이트");

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

}
