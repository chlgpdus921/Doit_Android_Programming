package org.androidtown.actionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActionBar abar;
EditText editText;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        abar = this.getSupportActionBar(); //책에서는 getActionBar();인데 실행안됨.
        abar.show();
        abar.setSubtitle("옵션바 살펴보기");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //액티비티가 만들어질 때 자동 호출되어 화면에 메뉴기능 추가.
     getMenuInflater().inflate(R.menu.menu_main, menu);
        View v = menu.findItem(R.id.menu_search).getActionView();
        if (v != null) {
            editText = (EditText) v.findViewById(R.id.editText);

            if (editText != null) {
                editText.setOnEditorActionListener(onSearchListener);
            }
        }
        else{
            Toast.makeText(this, "view is null",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    /*책에는 나오지 않았던 코드, 직접 입력*/
    private TextView.OnEditorActionListener onSearchListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String text = v.getText().toString();
            Toast.makeText(getApplicationContext(), "검색어: " + text, Toast.LENGTH_SHORT).show();

            if (event == null || event.getAction() == KeyEvent.ACTION_UP) { //keyboard hide!
                InputMethodManager inputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(v.getWindowToken(),0);
            }
            return true;
        }
    };
    public void onButton1Clicked(View v) {
        abar.setLogo(R.drawable.home);
        abar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_refresh:
                textView.setText("새로고침 메뉴를 선택했습니다.");
                break;
            case R.id.menu_search:
                textView.setText("검색 메뉴를 선택했습니다.");
                break;
            case R.id.menu_settings:
                textView.setText("설정 메뉴를 선택했습니다.");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}