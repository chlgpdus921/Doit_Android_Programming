package org.androidtown.samplepdfview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
    }

    public void onButton1Clicked(View v) {
        String filename = editText.getText().toString();
        if (filename.length() > 0) {
            openPDF(filename.trim());
        } else {
            Toast.makeText(getApplicationContext(), "PDF파일명을 입력하세요", Toast.LENGTH_LONG).show();
        }
    }

    public void openPDF(String filename) {
        String sdcardFolder = Environment.getExternalStorageDirectory() + "/kakaoTalkDownload/";
        String filepath = sdcardFolder + File.separator + filename;
        File file = new File(filepath);

        if (file.exists()) {
            Uri uri = Uri.fromFile(file);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");

            try {
                startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(this, "pdf 파일을 보기 위한 뷰어 앱이 없습니다", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "pdf 파일이 없습니다", Toast.LENGTH_SHORT).show();
        }
    }
}

