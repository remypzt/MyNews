package myNews.data.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import myNews.myNews.R;
import myNews.viewmodel.ViewModelMyNewsForSearchArticles;

/**
 * Created by Remy Pouzet on 02/02/2020.
 */
public class UploadWorker extends Worker {
	
	public static final String PREFS                         = "PREFS";
	public static final String PREF_KEY_BEGIN_DATE           = "PREF_KEY_BEGIN_DATE";
	public static final String PREF_KEY_FILTER               = "PREF_KEY_FILTER";
	public static final String PREF_KEY_QUERY                = "PREF_KEY_QUERY";
	public static final String PREF_KEY_HOUR_OF_NOTIFICATION = "PREF_KEY_HOUR_OF_NOTIFICATION";
	public static final String PREF_KEY_NUMBER_OF_TIME_UNITY = "PREF_KEY_NUMBER_OF_TIME_UNITY";
	public static final String PREF_KEY_TIME_UNITY           = "REF_KEY_TIME_UNITY";
	
	private static final int NOTIF_ID = 123;
	
	private ViewModelMyNewsForSearchArticles viewModelMyNewsForSearchArticles;
	
	private String query, filter, beginDate, endDate, channelNumberOne = "channelNumberOne";
	String typeOfUnityFrequence;
	private Context           context;
	private SharedPreferences mPreferences;
	int numberOfArticles;
	int unityFrequence;
	
	public UploadWorker(@NonNull Context context,
	                    @NonNull WorkerParameters params) {
		super(context, params);
		this.context = context;
	}
	
	@Override
	public Result doWork() {
		mPreferences         = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
		query                = mPreferences.getString(PREF_KEY_QUERY, "");
		filter               = mPreferences.getString(PREF_KEY_FILTER, "");
		beginDate            = mPreferences.getString(PREF_KEY_BEGIN_DATE, null);
		unityFrequence       = mPreferences.getInt(PREF_KEY_NUMBER_OF_TIME_UNITY, 24);
		typeOfUnityFrequence = mPreferences.getString(PREF_KEY_TIME_UNITY, "Heures");
		
		
		viewModelMyNewsForSearchArticles = new ViewModelMyNewsForSearchArticles(query, filter, beginDate, endDate);
		if (viewModelMyNewsForSearchArticles
				    .getNews()
				    .getValue() != null) {
			viewModelMyNewsForSearchArticles
					.getNews()
					.getValue()
					.size();
			numberOfArticles = viewModelMyNewsForSearchArticles
					.getNews()
					.getValue()
					.size();
			
		}
		
		notifyTheUserByAndroidnotif();
		
		// Indicate whether the task finished successfully with the Result
		return Result.success();
	}
	
	public void notifyTheUserByAndroidnotif() {
		Resources res = context.getResources();
		
		NotificationCompat.Builder notification = new NotificationCompat.Builder(context, channelNumberOne)
				.setSmallIcon(R.drawable.ic_launcher)
				.setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.ic_launcher))
				.setShowWhen(true)
				.setAutoCancel(true)
				.setContentTitle("«" + query + "»" + ":" + numberOfArticles + "nouveaux articles depuis" + unityFrequence + typeOfUnityFrequence)
				.setContentText("15")
				.setVibrate(new long[]{0, 500, 110, 500, 110, 450, 110, 200, 110, 170, 40, 450, 110, 200, 110, 170, 40, 500})
				.setLights(Color.RED, 3000, 3000);
		
		createNotificationChannel();
		
		NotificationManagerCompat notifManager = NotificationManagerCompat.from(context);
		notifManager.notify(NOTIF_ID, notification.build());
		Log.i("MainActivity", "Notification launched");
	}
	
	private void createNotificationChannel() {
		// Create the NotificationChannel, but only on API 26+ because
		// the NotificationChannel class is new and not in the support library
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			CharSequence        name        = "channel name";
			String              description = "channel description";
			int                 importance  = NotificationManager.IMPORTANCE_DEFAULT;
			NotificationChannel channel     = new NotificationChannel(channelNumberOne, name, importance);
			channel.setDescription(description);
			// Register the channel with the system; you can't change the importance
			// or other notification behaviors after this
			NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
			notificationManager.createNotificationChannel(channel);
		}
	}
}
