package com.demo.hqinterviewdemo.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.demo.hqinterviewdemo.R;
import com.demo.hqinterviewdemo.model.DataBean;
import com.demo.hqinterviewdemo.utils.Alert;
import com.demo.hqinterviewdemo.utils.InternetCheckUtils;
import com.demo.hqinterviewdemo.utils.StringUtils;

public class WebViewActivity extends Activity {

    private WebView webView;
    private ProgressDialog progressDialog;
    private DataBean dataBean;
    private Context context;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        context = this;

        dataBean = (DataBean) getIntent().getExtras().getSerializable("DataBean");

        webView = (WebView) findViewById(R.id.webView);
//        webView.getSettings().setJavaScriptEnabled(true);

        if(dataBean.getCache()){

            if(InternetCheckUtils.isOnline(context)){
                webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
            }else{
                webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            }

        }
//        webView.loadUrl(url);
        if (progressDialog == null) {
            // in standard case YourActivity.this
            progressDialog = new ProgressDialog(WebViewActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        startWebView(StringUtils.makeValidURL(dataBean.getUrl()));
    }
    
    
    private void startWebView(String url) {
        
        //Create new webview Client to show progress dialog
        //When opening a url or click on link
         
        webView.setWebViewClient(new WebViewClient() {      
//            ProgressDialog progressDialog;
          
            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {              
                view.loadUrl(url);
                return true;
            }
        
            //Show loader on url load
            public void onLoadResource (WebView view, String url) {

            }
            public void onPageFinished(WebView view, String url) {
                try{
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                if(InternetCheckUtils.isOnline(context)){
                    Alert.pop_Alert(context, "Invalid URL!");
                }else{
                    Alert.pop_Alert(context, "Please Check The Intenet Connectivity!");
                }

                super.onReceivedError(view, errorCode, description, failingUrl);
            }

        });
          
         // Javascript inabled on webview  
        webView.getSettings().setJavaScriptEnabled(true);
         
        //Load url in webview
        webView.loadUrl(url);
          
    }
     
    // Open previous opened link from history on webview when back button pressed
     
    @Override
    // Detect when the back button is pressed
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
    }
}