package myNews.view.activitiesAndFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 26/02/2020.
 */
public class ArticlesWebview extends AppCompatActivity {
	
	@BindView(R.id.webView1) public WebView mWebView;
	private                         WebView webView;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.articles_webview);
		ButterKnife.bind(this);
		
		Bundle bundle = getIntent().getExtras();
		assert bundle != null;
		String localUrl = bundle.getString("url");
		
		this.mWebView
				.getSettings()
				.setJavaScriptEnabled(true);
		this.mWebView.loadUrl(localUrl);
		
	}
}

