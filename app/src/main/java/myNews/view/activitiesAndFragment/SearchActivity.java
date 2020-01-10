package myNews.view.activitiesAndFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ButterKnife.bind(this);

        //Back arrow
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));

        datepicker();
    }

    public void datepicker() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        beginbtndatepicker.setOnClickListener(v -> {
            DatePickerDialog dd = new DatePickerDialog(SearchActivity.this, (view, year, monthOfYear, dayOfMonth) -> {
                try {
                    String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                    Date date = formatter.parse(dateInString);
                    beginbtndatepicker.setText(formatter.format(date));
                    if (endbtndatepicker.getText().length() > 1) {
                        Date dateOfBeginning = formatter.parse((String) beginbtndatepicker.getText());
                        Date dateOfEnding = formatter.parse((String) endbtndatepicker.getText());
                        int comparison = dateOfBeginning.compareTo(dateOfEnding);
                        if (comparison > 0) {
                            Toast.makeText(SearchActivity.this, "la date de début doit être antérieure à celle de fin", Toast.LENGTH_LONG).show();
                            beginbtndatepicker.setText(null);
                        }
                    }
                } catch (Exception ex) {
                }
            }, year, month, day);
            dd.show();
        });

        endbtndatepicker.setOnClickListener(v -> {
            DatePickerDialog dd = new DatePickerDialog(SearchActivity.this, (view, year, monthOfYear, dayOfMonth) -> {
                try {
                    String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                    Date date = formatter.parse(dateInString);
                    endbtndatepicker.setText(formatter.format(date));
                    if (beginbtndatepicker.getText().length() > 1) {
                        Date dateOfBeginning = formatter.parse((String) beginbtndatepicker.getText());
                        Date dateOfEnding = formatter.parse((String) endbtndatepicker.getText());
                        int comparison = dateOfBeginning.compareTo(dateOfEnding);
                        if (comparison > 0) {
                            Toast.makeText(SearchActivity.this, "la date fin doit être ultérieure à celle de début", Toast.LENGTH_LONG).show();
                            endbtndatepicker.setText(null);
                        }
                    }
                } catch (Exception ex) {
                }
            }, year, month, day);
            dd.show();
        });
    }

    private void launchTheSearch() {
        searchButton.setOnClickListener();
    }
}








