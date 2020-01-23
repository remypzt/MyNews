package myNews.view.activitiesAndFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.data.repositories.model.Articles;
import myNews.myNews.R;
import myNews.viewmodel.ViewModelMyNewsForSearchArticles;

/**
 * Created by Remy Pouzet on 28/12/2019.
 */
public class SetNotificationsActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.enable_notifications)
    Switch mSwitch;
    @BindView(R.id.checkBox)
    CheckBox checkbox1;
    @BindView(R.id.checkBox2)
    CheckBox checkbox2;
    @BindView(R.id.checkBox3)
    CheckBox checkbox3;
    @BindView(R.id.checkBox4)
    CheckBox checkbox4;
    @BindView(R.id.checkBox5)
    CheckBox checkbox5;
    @BindView(R.id.checkBox6)
    CheckBox checkbox6;
    @BindView(R.id.input_search_content)
    TextInputEditText inputSearchContent;
    @BindView(R.id.new_results)
    Button newResultsButton;
    String query;
    String filter;
    String beginDate;
    String endDate;
    List<String> listFilters;
    String stringFilter;
    String alertQueryTerm;
    String beginDateInRightFormat;
    String endDateInRightFormat;
    Intent searchResultsActivity;
    ViewModelMyNewsForSearchArticles viewModelMyNewsForSearchArticles;
    //FOR DATA
    private List<Articles> articles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        ButterKnife.bind(this);

        newResultsButton.setVisibility(View.INVISIBLE);
        this.articles = new ArrayList<>();


        //Back arrow
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));

        manageNotifications();

        viewModelMyNewsForSearchArticles = new ViewModelMyNewsForSearchArticles(query, filter, beginDate, endDate);

    }


    private void manageNotifications() {
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    alertQueryTerm = Objects.requireNonNull(inputSearchContent.getText()).toString();
                    manageFilter();
                    manageDates();
                    searchConfiguration();
                    Toast.makeText(SetNotificationsActivity.this, "Votre alerte est activée", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SetNotificationsActivity.this, "Votre alerte est désactivée", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void manageFilter() {
        searchFilter(checkbox1);
        searchFilter(checkbox2);
        searchFilter(checkbox3);
        searchFilter(checkbox4);
        searchFilter(checkbox5);
        searchFilter(checkbox6);
        stringFilter = StringUtils.join(listFilters, " ");
    }

    public void searchFilter(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            listFilters.add(checkBox.getText().toString());
        }
    }


    public void manageDates() {
        // could be useless if endDate pass by SearchResultsActivity.configureSearchParameters

        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
        Date today = new Date();
        String resultOfToday = formatter2.format(today);
        Date dateOfToday = null;
        try {
            dateOfToday = formatter2.parse(resultOfToday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        endDateInRightFormat = resultOfToday;
    }

    public void searchConfiguration() {
        searchResultsActivity = new Intent(SetNotificationsActivity.this, SearchResultsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("beginDate", beginDateInRightFormat);
        bundle.putString("endDate", endDateInRightFormat);
        bundle.putString("query", Objects.requireNonNull(inputSearchContent.getText()).toString());
        bundle.putString("filter", stringFilter);

        searchResultsActivity.putExtras(bundle);
        notifyTheUser();
    }

    public void notifyTheUser() {
        viewModelMyNewsForSearchArticles.getNews().observe(this, this::updateList);

        //TODO program task for every days (use sharedpreferences ?)
        // notify user (enable button, enable icon in menu, send notification to the device)
        // userscan choose an hour of notification OR to be notify at every new results

        resultsDisplay();


    }

    public void resultsDisplay() {
        newResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchResultsActivity = new Intent(SetNotificationsActivity.this, SearchResultsActivity.class);
                newResultsButton.setVisibility(View.INVISIBLE);
                startActivity(searchResultsActivity);
            }
        });

    }

    public void updateList(List<Articles> articlesList) {
        articles.clear();
        if (articlesList != null) {
            articles.addAll(articlesList);
            if (articlesList.size() == 0) {
                Toast.makeText(SetNotificationsActivity.this, "Il n'y a aucuns résultats", Toast.LENGTH_LONG).show();
                newResultsButton.setVisibility(View.INVISIBLE);
            } else {
                newResultsButton.setVisibility(View.VISIBLE);
            }
        } else {
            Toast.makeText(SetNotificationsActivity.this, "BAD_REQUEST", Toast.LENGTH_LONG).show();
            newResultsButton.setVisibility(View.INVISIBLE);
        }

    }
}


