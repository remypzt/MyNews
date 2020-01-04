package myNews.view.activitiesAndFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 28/12/2019.
 */
public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.date_of_beginning)
    public Button dateOfBeginning;
    @BindView(R.id.search_button)
    public Button searchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ButterKnife.bind(this);
        setDateOfBeginning();
    }


    private void setDateOfBeginning() {
        dateOfBeginning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
