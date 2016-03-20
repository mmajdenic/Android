package nr.co.majdenic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
 
public class AndroidWebViewActivity extends Activity {
     
 private WebView myWebView;
 private String LOG_TAG = "AndroidWebViewActivity";
  
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         
        myWebView = (WebView) findViewById(R.id.webView1);
         
        //enable Javascript
        myWebView.getSettings().setJavaScriptEnabled(true);
         
        //loads the WebView completely zoomed out
        myWebView.getSettings().setLoadWithOverviewMode(true);
         
        //true makes the Webview have a normal viewport such as a normal desktop browser 
        //when false the webview will have a viewport constrained to it's own dimensions
        myWebView.getSettings().setUseWideViewPort(true);
         
        //override the web client to open all links in the same webview
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.setWebChromeClient(new MyWebChromeClient());
         
        //Injects the supplied Java object into this WebView. The object is injected into the 
        //JavaScript context of the main frame, using the supplied name. This allows the 
        //Java object's public methods to be accessed from JavaScript.
        myWebView.addJavascriptInterface(new JavaScriptInterface(this), "Android");
         
        //load the home page URL
        myWebView.loadUrl("http://vodostaj.weebly.com/");
  
    }
  
 //customize your web view client to open links from your own site in the 
 //same web view otherwise just open the default browser activity with the URL
 private class MyWebViewClient extends WebViewClient {
     @Override
     public boolean shouldOverrideUrlLoading(WebView view, String url) {
         if (Uri.parse(url).getHost().equals("http://vodostaj.weebly.com/")) {
             return false;
         }
         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
         startActivity(intent);
         return true;
     }
 }
  
 private class MyWebChromeClient extends WebChromeClient {
      
  //display alert message in Web View
  @Override
     public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
         Log.d(LOG_TAG, message);
         new AlertDialog.Builder(view.getContext())
          .setMessage(message).setCancelable(true).show();
         result.confirm();
         return true;
     }
 
 }
  
 public class JavaScriptInterface {
     Context mContext;
 
     // Instantiate the interface and set the context 
     JavaScriptInterface(Context c) {
         mContext = c;
     }
      
     //using Javascript to call the finish activity
     public void closeMyActivity() {
         finish();
     }
      
 }
  
 //Web view has record of all pages visited so you can go back and forth
 //just override the back button to go back in history if there is page
 //available for display
 @Override
 public boolean onKeyDown(int keyCode, KeyEvent event) {
     if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
         myWebView.goBack();
         return true;
     }
     return super.onKeyDown(keyCode, event);
 }
  
}