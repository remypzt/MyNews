package myNews.view.activitiesAndFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.myNews.R;

/**
 * Created by Remy Pouzet on 28/12/2019.
 */
public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.search_button)
    public Button searchButton;
    @BindView(R.id.date_of_beginning)
    public Button beginbtndatepicker;
    @BindView(R.id.date_of_ending)
    public Button endbtndatepicker;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR), month = c.get(Calendar.MONTH), day = c.get(Calendar.DAY_OF_MONTH);

    private static SearchActivity searchActivity;

    public static SearchActivity getInstance() {
        if (searchActivity == null) {
            searchActivity = new SearchActivity();
        }
        return searchActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ButterKnife.bind(this);

        //Back arrow
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));

        //date picker ang error gestion
        datepickerShort(beginbtndatepicker, endbtndatepicker);
        datepickerShort(endbtndatepicker, beginbtndatepicker);

        launchTheSearch();
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public Button getBeginbtndatepicker() {
        return beginbtndatepicker;
    }

    public Button getEndbtndatepicker() {
        return endbtndatepicker;
    }

    public void datepickerShort(Button button1, Button button2) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        button1.setOnClickListener(v -> {
            DatePickerDialog dd = new DatePickerDialog(SearchActivity.this, (view, year, monthOfYear, dayOfMonth) -> {
                try {
                    String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                    Date date = formatter.parse(dateInString);
                    button1.setText(formatter.format(date));

                    String dateInStringForData = year + "" + (monthOfYear + 1) + "" + dayOfMonth;
                    button1.setPrivateImeOptions(dateInStringForData);

                    if (button2.getText().length() > 1) {
                        Date dateOfBeginning = formatter.parse((String) button1.getText());
                        Date dateOfEnding = formatter.parse((String) button2.getText());
                        int comparison = dateOfBeginning.compareTo(dateOfEnding);
                        if (comparison > 0 && button1 == beginbtndatepicker) {
                            Toast.makeText(SearchActivity.this, "la date de début doit être antérieure à celle de fin", Toast.LENGTH_LONG).show();
                            button1.setText(null);
                        } else if (comparison < 0 && button2 != endbtndatepicker) {
                            Toast.makeText(SearchActivity.this, "la date fin doit être ultérieure à celle de début", Toast.LENGTH_LONG).show();
                            button1.setText(null);
                        }
                    }
                } catch (Exception ex) {
                }
            }, year, month, day);
            dd.show();
        });
    }

    private void launchTheSearch() {
        searchButton.setOnClickListener(new View.OnClickListener(){
         @Override
            public void onClick(final View v) {
             Intent SearchResultsActivity = new Intent(SearchActivity.this, SearchResultsActivity.class);
             startActivity(SearchResultsActivity);
         }
        });
    }
}








