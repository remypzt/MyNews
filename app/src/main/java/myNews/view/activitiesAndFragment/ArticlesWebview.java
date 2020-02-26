package myNews.view.activitiesAndFragment;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 26/02/2020.
 */
public class ArticlesWebview extends AppCompatActivity {
	
	@BindView(R.id.toolbar) public Toolbar toolbar;
	@BindView(R.id.webView1)       WebView mWebView;
	private                        WebView webView;
	private                        String  url;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.articles_webview);
		ButterKnife.bind(this);
		
		Bundle bundle = getIntent().getExtras();
		url = bundle.getString("url");
		
		//Back arrow
		toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
		toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
		
		this.mWebView
				.getSettings()
				.setJavaScriptEnabled(true);
		this.mWebView.loadUrl(url);
		
	}
}

