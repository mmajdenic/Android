package majdenic.waterlevel;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.annotation.SuppressLint;
import android.app.Activity;
 
@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        WebView webView = (WebView)findViewById(R.id.WebView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("http://mmajdenic.wix.com/vodostaj");
    }
}