package com.example.lesson2_webview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView =
                (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new CallBack());
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        //webView.loadUrl("http://www.cnn.com");
        String  html = "<html><head></head><body><h1>Hello</h1></body></html>";
        webView.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");

    }

    private static class CallBack extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
}
