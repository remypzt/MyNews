package myNews.view.activitiesAndFragment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Constraints;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.google.android.material.textfield.TextInputEditText;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.data.repositories.model.Articles;
import myNews.data.service.UploadWorker;
import myNews.myNews.R;
import myNews.viewmodel.ViewModelMyNewsForSearchArticles;

/**
 * Created by Remy Pouzet on 28/12/2019.
 */
public class SetNotificationsActivity extends AppCompatActivity {
    public static final String PREFS = "PREFS", PREF_KEY_BEGIN_DATE = "PREF_KEY_BEGIN_DATE", PREF_KEY_FILTER = "PREF_KEY_FILTER", PREF_KEY_QUERY = "PREF_KEY_QUERY";
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
    public SharedPreferences mPreferences;

    List<String> listFilters;

    Intent searchResultsActivity;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ViewModelMyNewsForSearchArticles viewModelMyNewsForSearchArticles;
    //FOR DATA
    private List<Articles> articles;
    private static final int NOTIF_ID2 = 1232;
    Intent uploadWorkerActivity;
    String query, filter, beginDate, endDate, stringFilter, alertQueryTerm, beginDateInRightFormat, channelNumberOne = "channelNumberOne";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        ButterKnife.bind(this);

        this.context = mSwitch.getContext();


        newResultsButton.setVisibility(View.INVISIBLE);
        this.articles = new ArrayList<>();
        listFilters = new ArrayList<>();

        mPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);

        //Back arrow
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));

        manageNotifications();
        testingNotification();

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

    public void testingNotification() {


        Resources res = context.getResources();

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, channelNumberOne).setSmallIcon(R.drawable.ic_launcher).setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher)).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle("A notification title").setContentText("Full message").setVibrate(new long[]{0, 500, 110, 500, 110, 450, 110, 200, 110, 170, 40, 450, 110, 200, 110, 170, 40, 500}).setLights(Color.RED, 3000, 3000);

        createNotificationChannel();


        NotificationManagerCompat notifManager = NotificationManagerCompat.from(context);
        notifManager.notify(NOTIF_ID2, notification.build());
        Log.i("MainActivity", "Notification launched");
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel name";
            String description = "channel description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelNumberOne, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void manageDates() {
        SimpleDateFormat formatterBackEndFormat = new SimpleDateFormat("yyyyMMdd");
        //Initialisation du Calendar
        Calendar cal = Calendar.getInstance();
        //Recuperation de la date J-1
        cal.add(Calendar.DAY_OF_MONTH, -1);
        //Formattage de la date J-1
        String resultOfYersterday = formatterBackEndFormat.format(cal.getTime());
        beginDateInRightFormat = resultOfYersterday;
    }

    public void searchConfiguration() {
        searchResultsActivity = new Intent(SetNotificationsActivity.this, SearchResultsActivity.class);
        mPreferences.edit().putString(PREF_KEY_BEGIN_DATE, beginDateInRightFormat).apply();
        mPreferences.edit().putString(PREF_KEY_FILTER, stringFilter).apply();
        mPreferences.edit().putString(PREF_KEY_QUERY, alertQueryTerm).apply();
        notifyTheUser();
    }

    public void notifyTheUser() {
        viewModelMyNewsForSearchArticles.getNews().observe(this, this::updateList);

        //TODO
        // userscan choose an hour of notification OR to be notify at every new results


        Constraints constraints = new Constraints.Builder().build();

        PeriodicWorkRequest saveRequest = new PeriodicWorkRequest.Builder(UploadWorker.class, 15, TimeUnit.MINUTES).setConstraints(constraints).build();

        WorkManager.getInstance(this).enqueue(saveRequest);

        resultsDisplay();
    }

    public void resultsDisplay() {
        newResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                Toast.makeText(SetNotificationsActivity.this, "Il n'y a aucuns nouveaux résultats depuis hier", Toast.LENGTH_LONG).show();
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


