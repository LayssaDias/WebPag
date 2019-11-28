package com.example.webpag;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientImpl extends WebViewClient {
    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    //mantendo site dentro do app
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if (url.contains("http://catdog.sa-east-1.elasticbeanstalk.com/")) return false;
        //intent serve para abrir outra tela, mas aqui vms jogar a url na webView do nosso layout
        //isso serve para não utilizar navegador
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }
}