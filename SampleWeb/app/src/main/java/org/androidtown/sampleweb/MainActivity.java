package org.androidtown.sampleweb;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private EditText urlInput;
    private Button loadButton;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        urlInput = (EditText) findViewById(R.id.urlInput);
        loadButton = (Button) findViewById(R.id.loadButton);

        WebSettings webSettings = webView.getSettings(); //웹 설정 정보
        webSettings.setJavaScriptEnabled(true); //자바스크립트 허용

        webView.setWebChromeClient(new WebBrowserClient()); //웹뷰에 클라이언트 객체 지정
        webView.addJavascriptInterface(new JavaScriptMethods(), "sample");//자바스크립트
        webView.loadUrl("file:///android_asset/www/sample.html");//웹뷰에 샘플 페이지 로딩

        loadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl(urlInput.getText().toString());
            }
        });
    }

    final class JavaScriptMethods {
        JavaScriptMethods() {
        }

        @android.webkit.JavascriptInterface
        public void clickOnFace() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    loadButton.setText("클릭 후 열기");
                    webView.loadUrl("javascrpt:changeFace()");
                }
            });
        }
    }

    final class WebBrowserClient extends WebChromeClient {
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.confirm();
            return true;
        }
    }
}
