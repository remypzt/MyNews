package myNews.view.activitiesAndFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR), month = c.get(Calendar.MONTH), day = c.get(Calendar.DAY_OF_MONTH);

    List<String> filter;
    String stringFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ButterKnife.bind(this);

        filter = new ArrayList<>();




        //Back arrow
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));


        datepickerShort(beginbtndatepicker, endbtndatepicker);

        datepickerShort(endbtndatepicker, beginbtndatepicker);

        launchTheSearch();

    }

    public Button getSearchButton() {
        return searchButton;
    }

    public void searchFilter(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            filter.add(checkBox.getText().toString());
        }
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

             Intent searchResultsActivity = new Intent(SearchActivity.this, SearchResultsActivity.class);
             Bundle bundle = new Bundle();
             bundle.putString("beginDate", beginbtndatepicker.getText().toString());
             bundle.putString("endDate", endbtndatepicker.getText().toString());
             bundle.putString("query", getSearchButton().getText().toString());
             searchFilter(checkbox1);
             searchFilter(checkbox2);
             searchFilter(checkbox3);
             searchFilter(checkbox4);
             searchFilter(checkbox5);
             searchFilter(checkbox6);
             stringFilter = StringUtils.join(filter, " ");
             bundle.putString("filter", stringFilter);
             searchResultsActivity.putExtras(bundle);
             startActivity(searchResultsActivity);
         }
        });
    }
}








