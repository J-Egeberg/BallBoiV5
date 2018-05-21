package oakberg.dk.mytemplate.entity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import oakberg.dk.mytemplate.R;

public class RecipeDetail extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);


        String title = this.getIntent().getExtras().getString("title");
        String url = this.getIntent().getExtras().getString("url");


        setTitle(title);


        mWebView = (WebView) findViewById(R.id.detail_web_view);


        mWebView.loadUrl(url);



    }
}
