package myNews.view.userInterface;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import myNews.devexchanges.myNews.R;

/**
 * Created by Remy Pouzet
 */

public class DesActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        TextView textView = (TextView)findViewById(R.id.text_view);

        setSupportActionBar(toolbar);
        if (getIntent() != null) {
            textView.setText(getIntent().getStringExtra("string"));
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
