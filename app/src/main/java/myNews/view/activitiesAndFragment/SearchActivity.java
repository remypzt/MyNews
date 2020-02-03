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

import com.google.android.material.textfield.TextInputEditText;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    @BindView(R.id.input_search_content)
    TextInputEditText inputSearchContent;

    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR), month = c.get(Calendar.MONTH), day = c.get(Calendar.DAY_OF_MONTH);

    List<String> filter;
    String stringFilter;
    Date dateBackEndFormat;

    String beginDateInRightFormat;
    String endDateInRightFormat;
    SimpleDateFormat formatterUIFormat = new SimpleDateFormat("dd/MM/yyyy");

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


    public void searchFilter(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            filter.add(checkBox.getText().toString());
        }
    }

    public void datepickerShort(Button button1, Button button2) {

        SimpleDateFormat formatterBackEndFormat = new SimpleDateFormat("yyyyMMdd");
        button1.setOnClickListener(v -> {
            DatePickerDialog dd = new DatePickerDialog(SearchActivity.this, (view, year, monthOfYear, dayOfMonth) -> {
                try {
                    String dateInStringUIFormat = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                    Date dateUIFormat = formatterUIFormat.parse(dateInStringUIFormat);

                    if (dayOfMonth > 9) {
                        String dateInStringBackEndFormat = year + "" + (monthOfYear + 1) + "" + dayOfMonth;
                        dateBackEndFormat = formatterBackEndFormat.parse(dateInStringBackEndFormat);
                    } else {
                        String dateInStringBackEndFormatException = year + "" + (monthOfYear + 1) + "0" + dayOfMonth;
                        dateBackEndFormat = formatterBackEndFormat.parse(dateInStringBackEndFormatException);
                    }

                    button1.setText(formatterUIFormat.format(dateUIFormat));

                    // check that dates cannot be paradoxal between them
                    if (button1.getText().toString().length() > 0 && button2.getText().toString().length() > 0) {
                        checkDateBetweenThem(button1, button2);
                    }

                    // check dates cannot be place in the future
                    if (button1 != endbtndatepicker) {
                        Date dateOfBeginning = formatterUIFormat.parse(dateInStringUIFormat);
                        checkDateWithToday(dateOfBeginning, button1);
                        beginDateInRightFormat = formatterBackEndFormat.format(dateBackEndFormat);
                    } else {
                        Date dateOfEnding = formatterUIFormat.parse(dateInStringUIFormat);
                        checkDateWithToday(dateOfEnding, button1);
                        endDateInRightFormat = formatterBackEndFormat.format(dateBackEndFormat);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }, year, month, day);
            dd.show();
        });
    }

    // check dates cannot be place in the future
    public void checkDateWithToday(Date date, Button button) {
        Date today = new Date();
        String resultOfToday = formatterUIFormat.format(today);
        Date dateOfToday = null;
        try {
            dateOfToday = formatterUIFormat.parse(resultOfToday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int todayCompareWithDate = dateOfToday.compareTo(date);
        if (todayCompareWithDate < 0) {
            Toast.makeText(SearchActivity.this, "la date sélectionnée ne peut être ultérieur à celle d'aujourd'hui", Toast.LENGTH_LONG).show();
            button.setText(null);
        }
    }

    public void checkDateBetweenThem(Button button1, Button button2) {
        Date dateOfBeginning = null;
        try {
            dateOfBeginning = formatterUIFormat.parse((String) button1.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateOfEnding = null;
        try {
            dateOfEnding = formatterUIFormat.parse((String) button2.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int comparison = dateOfBeginning.compareTo(dateOfEnding);
        if (comparison > 0 && button1 == beginbtndatepicker) {
            Toast.makeText(SearchActivity.this, "la date de début doit être antérieure à celle de fin", Toast.LENGTH_LONG).show();
            button1.setText(null);
        } else if (comparison < 0 && button2 != endbtndatepicker) {
            Toast.makeText(SearchActivity.this, "la date fin doit être ultérieure à celle de début", Toast.LENGTH_LONG).show();
            button1.setText(null);

        }
    }
    private void launchTheSearch() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                Intent searchResultsActivity = new Intent(SearchActivity.this, SearchResultsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("beginDate", beginDateInRightFormat);
                bundle.putString("endDate", endDateInRightFormat);
                bundle.putString("query", Objects.requireNonNull(inputSearchContent.getText()).toString());
                searchFilter(checkbox1);
                searchFilter(checkbox2);
                searchFilter(checkbox3);
                searchFilter(checkbox4);
                searchFilter(checkbox5);
                searchFilter(checkbox6);
                stringFilter = StringUtils.join(filter, " ");
                bundle.putString("filter", stringFilter);
                // bundle.putString("origin", "fromSearchActivity.java");
                searchResultsActivity.putExtras(bundle);
                startActivity(searchResultsActivity);
            }
        });
    }
}









