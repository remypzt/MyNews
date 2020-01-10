package myNews.view.activitiesAndFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 28/12/2019.
 */
public class SetNotificationsActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        ButterKnife.bind(this);

        //Back arrow
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
    }
}
