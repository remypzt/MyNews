package myNews.data.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import myNews.myNews.R;
import myNews.viewmodel.ViewModelMyNewsForSearchArticles;

/**
 * Created by Remy Pouzet on 02/02/2020.
 */
public class UploadWorker extends Worker {


    static final String PREFS = "PREFS", PREF_KEY_BEGIN_DATE = "PREF_KEY_BEGIN_DATE", PREF_KEY_FILTER = "PREF_KEY_FILTER", PREF_KEY_QUERY = "PREF_KEY_QUERY";
    private static final int NOTIF_ID = 123;
    ViewModelMyNewsForSearchArticles viewModelMyNewsForSearchArticles;
    String query, filter, beginDate, endDate;
    Context context;
    SharedPreferences mPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);

    public UploadWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);

    }

    @Override
    public Result doWork() {

        query = mPreferences.getString(PREF_KEY_QUERY, "");
        filter = mPreferences.getString(PREF_KEY_FILTER, "");
        beginDate = mPreferences.getString(PREF_KEY_BEGIN_DATE, null);

        viewModelMyNewsForSearchArticles = new ViewModelMyNewsForSearchArticles(query, filter, beginDate, endDate);
        if (viewModelMyNewsForSearchArticles.getNews().getValue() != null) {
            viewModelMyNewsForSearchArticles.getNews().getValue().size();
        }


        Resources res = context.getResources();

        Notification notification = new Notification.Builder(context).setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher)).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle("A notification title").setContentText("Full message").setVibrate(new long[]{0, 500, 110, 500, 110, 450, 110, 200, 110, 170, 40, 450, 110, 200, 110, 170, 40, 500}).setLights(Color.RED, 3000, 3000).getNotification();


        NotificationManager notifManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notifManager.notify(NOTIF_ID, notification);
        Log.i("MainActivity", "Notification launched");


        //TODO notify user with number of results(enable button, enable icon in menu, send notification to the device)

        // Indicate whether the task finished successfully with the Result
        return Result.success();


    }


}
