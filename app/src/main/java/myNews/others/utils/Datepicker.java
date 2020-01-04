package myNews.others.utils;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Remy Pouzet on 04/01/2020.
 */
public class Datepicker extends AppCompatActivity {
    TextView txtdate;
    Button btndatepicker;

    SimpleDateFormat format;
    Calendar c;
    int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        c = Calendar.getInstance();


        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);


        btndatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date

                DatePickerDialog dd = new DatePickerDialog(Datepicker.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        try {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                            Date date = formatter.parse(dateInString);

                            txtdate.setText(formatter.format(date));

                            formatter = new SimpleDateFormat("dd/MMM/yyyy");

                            txtdate.setText(txtdate.getText().toString() + "\n" + formatter.format(date));

                            formatter = new SimpleDateFormat("dd-MM-yyyy");

                            txtdate.setText(txtdate.getText().toString() + "\n" + formatter.format(date));

                            formatter = new SimpleDateFormat("dd.MMM.yyyy");

                            txtdate.setText(txtdate.getText().toString() + "\n" + formatter.format(date));

                        } catch (Exception ex) {

                        }

                    }
                }, year, month, day);
                dd.show();
            }
        });

    }


}
