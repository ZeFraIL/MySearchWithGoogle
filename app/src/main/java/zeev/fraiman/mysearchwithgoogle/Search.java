package zeev.fraiman.mysearchwithgoogle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Search extends AppCompatActivity {

    Context context=Search.this;
    EditText et;
    Button bSearch;
    String stUrl="";
    WebView wvs;
    private static final String GOOGLE_SERACH_URL = "https://www.google.com/search?q=";
    Intent take;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initElements();

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stUrl=et.getText().toString();
                WebSettings webSettings = wvs.getSettings();
                webSettings.setJavaScriptEnabled(true);
                if (stUrl.equals(""))
                    return;
                wvs.setWebViewClient(new myWebViewClient());
                wvs.loadUrl(GOOGLE_SERACH_URL + stUrl);
            }
        });

    }

    private void initElements() {
        context=Search.this;
        take=getIntent();
        et=findViewById(R.id.et);
        bSearch=findViewById(R.id.bSearch);
        wvs=findViewById(R.id.wvs);
    }



    public void backWithLink(View view) {
        Intent goback=new Intent();
        goback.putExtra("result", wvs.getUrl());
        setResult(111,goback);
        finish();
    }

    private class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }


}