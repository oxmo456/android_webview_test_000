package com.example.android_webview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class Main extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = new WebView(this);
        webView.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage cm) {
                Log.d("app", cm.message() + " -- From line "
                        + cm.lineNumber() + " of "
                        + cm.sourceId());
                return true;
            }

            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                Log.d("app", message + " -- From line "
                        + lineNumber + " of "
                        + sourceID);
            }



        });
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/index.html");


        setContentView(webView);

        Log.d("app", "webview started...");
    }
}
