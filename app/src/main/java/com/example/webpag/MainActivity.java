package com.example.webpag;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //definindo a url que vai abrir no WebView
        myWebView = findViewById(R.id.webview);
        //mantendo o site dentro do app sem a utilização de navegador web Classe:WebViewClientImpl
        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        //setando a classe no webView do nosso layout
        myWebView.setWebViewClient(webViewClient);
        //carregando a url
        myWebView.loadUrl("http://catdog.sa-east-1.elasticbeanstalk.com/");

        //Habilitando o JavaScript para o menu abrir
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    //esse método permite voltar para tela anterior com o botão do próprio dispositivo
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
