package myNews.view.activitiesAndFragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 28/12/2019.
 */
public class SetNotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        ButterKnife.bind(this);
    }


}
