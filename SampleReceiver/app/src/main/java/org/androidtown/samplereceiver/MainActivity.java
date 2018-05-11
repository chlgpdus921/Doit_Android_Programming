package org.androidtown.samplereceiver;
import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);//수신권한 가지고 있는지 체크
        if(permissionCheck == PackageManager.PERMISSION_GRANTED){//권한있음
            Toast.makeText(this, "SMS 수신 권한 있음", Toast.LENGTH_LONG).show();
        }
        else{//권한 없음
            Toast.makeText(this, "SMS 수신 권한 없음", Toast.LENGTH_LONG).show();
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)){//왜필요한지 알려줌
                Toast.makeText(this, "SMS 권한 설명 필요함. ", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS},1);
                //요청할 권한이 여러개일수 있으므로 String으로 전달.
            }
            else{

            }
        }
    }
}
