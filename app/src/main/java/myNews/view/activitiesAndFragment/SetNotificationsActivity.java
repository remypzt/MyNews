package myNews.view.activitiesAndFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.google.android.material.textfield.TextInputEditText;

import net.danlew.android.joda.JodaTimeAndroid;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Duration;

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
public class SetNotificationsActivity extends AppCompatActivity implements View.OnClickListener {
	
	public static final String PREFS                         = "PREFS";
	public static final String PREF_KEY_BEGIN_DATE           = "PREF_KEY_BEGIN_DATE";
	public static final String PREF_KEY_FILTER               = "PREF_KEY_FILTER";
	public static final String PREF_KEY_QUERY                = "PREF_KEY_QUERY";
	public static final String PREF_KEY_HOUR_OF_NOTIFICATION = "PREF_KEY_HOUR_OF_NOTIFICATION";
	public static final String PREF_KEY_NUMBER_OF_TIME_UNITY = "PREF_KEY_NUMBER_OF_TIME_UNITY";
	public static final String PREF_KEY_TIME_UNITY           = "REF_KEY_TIME_UNITY";
	public static final String PREF_KEY_FREQUENCE_MODE       = "PREF_KEY_FREQUENCE_MODE";
	public static final String PREF_KEY_ALERT_STATE          = "PREF_KEY_ALERT_STATE";
	
	public                                              SharedPreferences mPreferences;
	@BindView(R.id.enable_notifications)                Switch            mSwitch;
	@BindView(R.id.checkBox)                            CheckBox          checkbox1;
	@BindView(R.id.checkBox2)                           CheckBox          checkbox2;
	@BindView(R.id.checkBox3)                           CheckBox          checkbox3;
	@BindView(R.id.checkBox4)                           CheckBox          checkbox4;
	@BindView(R.id.checkBox5)                           CheckBox          checkbox5;
	@BindView(R.id.checkBox6)                           CheckBox          checkbox6;
	@BindView(R.id.input_search_content)                TextInputEditText inputSearchContent;
	@BindView(R.id.toolbar)                             Toolbar           toolbar;
	@BindView(R.id.numberPickerNotificationHour)        NumberPicker      npHour;
	@BindView(R.id.timeSettingTextViewNotificationHour) TextView          timeSettingTextView;
	@BindView(R.id.numberPickerUnityFrequence)          NumberPicker      npFrequenceUnity;
	@BindView(R.id.timeSettingTextViewUnityFrequence)   TextView          frequenceUnityTextView;
	@BindView(R.id.numberPickeTypeFrequence)            NumberPicker      npTypeUnity;
	@BindView(R.id.timeSettingTextViewTypeFrequence)    TextView          typeUnityTextView;
	@BindView(R.id.switchFrequencemode)                 Switch            switchFrequeneceMode;
	
	List<String> listFilters;
	
	Intent searchResultsActivity;
	
	ViewModelMyNewsForSearchArticles viewModelMyNewsForSearchArticles;
	String                           query;
	String                           filter;
	String                           beginDate;
	String              endDate;
	String              stringFilter;
	String              alertQueryTerm;
	String              beginDateInRightFormat;
	String              typeOfUnityFrequence;
	String              uiquery;
	String              uifilter;
	String              frequenceMode;
	String              alertState;
	int                 hourOfNotification;
	int                 delay;
	int                 unityFrequence;
	int                 unityFrequenceLogic;
	PeriodicWorkRequest saveRequest;
	
	private List<Articles> articles;
	private Context        context;
	
	final NumberPicker.OnValueChangeListener onValueChangeListenerFrequenceType = new NumberPicker.OnValueChangeListener() {
		@Override
		public void onValueChange(NumberPicker numberPicker,
		                          int oldVal,
		                          int newVal) {
			switch (newVal) {
				case 0:
					typeOfUnityFrequence = "Minutes";
					unityFrequenceLogic = unityFrequence;
					break;
				case 1:
					typeOfUnityFrequence = "Heures";
					unityFrequenceLogic = unityFrequence * 60;
					break;
				case 2:
					typeOfUnityFrequence = "Jours";
					unityFrequenceLogic = unityFrequence * 60 * 24;
					break;
				default:
					typeOfUnityFrequence = "Semaines";
					unityFrequenceLogic = unityFrequenceLogic * 60 * 24 * 7;
				
			}
			
			typeUnityTextView.setText("Unité de fréquence\n" + typeOfUnityFrequence);
			
			mSwitch.setChecked(false);
			Toast
					.makeText(SetNotificationsActivity.this, "Veuillez réactiver l'alerte pour prendre en compte les nouveaux paramètres", Toast.LENGTH_LONG)
					.show();
		}
	};
	
	NumberPicker.OnValueChangeListener onValueChangeListenerSettingTime = new NumberPicker.OnValueChangeListener() {
		@Override
		public void onValueChange(NumberPicker numberPicker,
		                          int oldVal,
		                          int newVal) {
			
			timeSettingTextView.setText("Heure \n de début\n" + newVal + "h");
			hourOfNotification = newVal;
			mSwitch.setChecked(false);
			Toast
					.makeText(SetNotificationsActivity.this, "Veuillez réactiver l'alerte pour prendre en compte les nouveaux paramètres", Toast.LENGTH_LONG)
					.show();
		}
	};
	
	NumberPicker.OnValueChangeListener onValueChangeListenerUnityFrequence = new NumberPicker.OnValueChangeListener() {
		@Override
		public void onValueChange(NumberPicker numberPicker,
		                          int oldVal,
		                          int newVal) {
			
			frequenceUnityTextView.setText("Fréquence\n" + "> 15 minutes\n" + newVal);
			unityFrequence = newVal;
			mSwitch.setChecked(false);
			Toast
					.makeText(SetNotificationsActivity.this, "Veuillez réactiver l'alerte pour prendre en compte les nouveaux paramètres", Toast.LENGTH_LONG)
					.show();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		JodaTimeAndroid.init(this);
		setContentView(R.layout.notifications);
		ButterKnife.bind(this);
		
		this.context = mSwitch.getContext();
		
		this.articles = new ArrayList<>();
		listFilters   = new ArrayList<>();
		
		mPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
		
		//Back arrow
		toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
		toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
		
		previousAlertmanagement();
		
		settingTimeOfNotification();
		settingUnityFrequence();
		settingTypeOfUnityFrequence();
		manageFrequenceMode();
		manageNotifications();
		
		
		viewModelMyNewsForSearchArticles = new ViewModelMyNewsForSearchArticles(query, filter, beginDate, endDate);
		
	}
	
	public boolean previousAlertmanagement() {
		alertState = mPreferences.getString(PREF_KEY_ALERT_STATE, "Désactif");
		if (alertState.equals("Actif")) {
			
			frequenceMode = mPreferences.getString(PREF_KEY_FREQUENCE_MODE, "Programmée");
			if (frequenceMode == "Instantanée") {
				switchFrequeneceMode.setChecked(true);
				//TODO
				
			} else {
				switchFrequeneceMode.setChecked(false);
				
				hourOfNotification = mPreferences.getInt(PREF_KEY_HOUR_OF_NOTIFICATION, 25);
				npHour.setValue(hourOfNotification);
				
				typeOfUnityFrequence = mPreferences.getString(PREF_KEY_TIME_UNITY, "Heures");
				
				unityFrequence = mPreferences.getInt(PREF_KEY_NUMBER_OF_TIME_UNITY, 24);
				npFrequenceUnity.setValue(unityFrequence);
				
			}
			inputSearchContent.setText(mPreferences.getString(PREF_KEY_QUERY, ""));
			mSwitch.setChecked(true);
			filter = mPreferences.getString(PREF_KEY_FILTER, "");
			
			return true;
			
		} else {
			
			npHour.setValue(12);
			hourOfNotification = 25;
			
			npFrequenceUnity.setValue(24);
			unityFrequence = 24;
			
			npTypeUnity.setValue(1);
			
			mSwitch.setChecked(false);
			switchFrequeneceMode.setChecked(false);
			
			return false;
		}
	}
	
	public void settingUnityFrequence() {
		//Set the minimum value of NumberPicker
		npFrequenceUnity.setMinValue(0);
		//Specify the maximum value/number of NumberPicker
		npFrequenceUnity.setMaxValue(100);
		
		npFrequenceUnity.setOnValueChangedListener(onValueChangeListenerUnityFrequence);
		
		frequenceUnityTextView.setText("Fréquence\n" + "> 15 minutes\n" + unityFrequence);
		frequenceUnityTextView.setTextColor(Color.parseColor("#ffd32b3b"));
		
	}
	
	public void settingTypeOfUnityFrequence() {
		//Set the minimum value of NumberPicker
		npTypeUnity.setMinValue(0);
		//Specify the maximum value/number of NumberPicker
		npTypeUnity.setMaxValue(3);
		
		npTypeUnity.setDisplayedValues(new String[]{"Minutes", "Heures", "Jours", "Semaines"});
		
		npTypeUnity.setOnValueChangedListener(onValueChangeListenerFrequenceType);
		
		typeUnityTextView.setText("Unité de fréquence\n" + typeOfUnityFrequence);
		typeUnityTextView.setTextColor(Color.parseColor("#ffd32b3b"));
		
	}
	
	public void settingTimeOfNotification() {
		//Set the minimum value of NumberPicker
		npHour.setMinValue(0);
		//Specify the maximum value/number of NumberPicker
		npHour.setMaxValue(23);
		
		npHour.setOnValueChangedListener(onValueChangeListenerSettingTime);
		
		if (hourOfNotification != 25) {
			timeSettingTextView.setText("Heure \n de début\n" + hourOfNotification + "h");
		} else {
			timeSettingTextView.setText("Heure \n de début\n" + "maintenant");
		}
		timeSettingTextView.setTextColor(Color.parseColor("#ffd32b3b"));
		
	}
	
	private void manageFrequenceMode() {
		
		if (switchFrequeneceMode.isChecked()) {
			instantAlertFrequenceMode();
		}
		switchFrequeneceMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@SuppressLint("SetTextI18n")
			public void onCheckedChanged(CompoundButton buttonView,
			                             boolean isChecked) {
				if (isChecked) {
					instantAlertFrequenceMode();
					mSwitch.setChecked(false);
					Toast
							.makeText(SetNotificationsActivity.this, "Veuillez réactiver l'alerte pour prendre en compte les nouveaux paramètres", Toast.LENGTH_LONG)
							.show();
					
				} else {
					mSwitch.setChecked(false);
					programmAlertFrequenceMode();
					
					//TODO
					WorkManager
							.getInstance(SetNotificationsActivity.this)
							.cancelAllWork();
					Toast
							.makeText(SetNotificationsActivity.this, "Veuillez réactiver l'alerte pour prendre en compte les nouveaux paramètres", Toast.LENGTH_LONG)
							.show();
				}
			}
		});
	}
	
	private void manageNotifications() {
		
		mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@SuppressLint("SetTextI18n")
			public void onCheckedChanged(CompoundButton buttonView,
			                             boolean isChecked) {
				if (isChecked) {
					activateAlert();
				} else {
					alertState = "Désactif";
					Toast
							.makeText(SetNotificationsActivity.this, "Votre alerte est désactivée", Toast.LENGTH_LONG)
							.show();
					listFilters.clear();
					mSwitch.setText("Alerte désactivée");
					
				}
			}
		});
	}
	
	private void instantAlertFrequenceMode() {
		frequenceMode = "Instantanée";
		mPreferences
				.edit()
				.putString(PREF_KEY_FREQUENCE_MODE, frequenceMode)
				.apply();
		npHour.setVisibility(View.GONE);
		timeSettingTextView.setVisibility(View.GONE);
		npFrequenceUnity.setVisibility(View.GONE);
		frequenceUnityTextView.setVisibility(View.GONE);
		npTypeUnity.setVisibility(View.GONE);
		typeUnityTextView.setVisibility(View.GONE);
		
		typeOfUnityFrequence = "minutes";
		hourOfNotification   = 25;
		unityFrequence       = 15;
		unityFrequenceLogic  = 15;
	}
	
	private void programmAlertFrequenceMode() {
		frequenceMode = "Programmée";
		mPreferences
				.edit()
				.putString(PREF_KEY_FREQUENCE_MODE, frequenceMode)
				.apply();
		
		timeSettingTextView.setVisibility(View.VISIBLE);
		npHour.setVisibility(View.VISIBLE);
		npFrequenceUnity.setVisibility(View.VISIBLE);
		frequenceUnityTextView.setVisibility(View.VISIBLE);
		npTypeUnity.setVisibility(View.VISIBLE);
		typeUnityTextView.setVisibility(View.VISIBLE);
		
	}
	
	public void activateAlert() {
		alertState     = "Actif";
		alertQueryTerm = Objects
				.requireNonNull(inputSearchContent.getText())
				.toString();
		
		manageFilter();
		manageDates();
		searchConfiguration();
		notifyTheUser();
		
		if (alertQueryTerm != null) {
			uiquery = alertQueryTerm;
		} else {
			uiquery = "";
		}
		
		if (listFilters.size() < 1) {
			uifilter = "";
		} else {
			uifilter = listFilters.toString();
		}
		
		if (frequenceMode.equals("Instantanée")) {
			if (hourOfNotification != 25) {
				mSwitch.setText("Alert activée avec les paramètres suivants = \n" + "" + "termes : " + uiquery + "\n" + "filtres : " + uifilter + "\n" + "heure de notification : " + hourOfNotification + "h" + "\n" + "fréquence : " + unityFrequence + " " + typeOfUnityFrequence);
			} else {
				mSwitch.setText("Alert activée avec les paramètres suivants = \n" + "" + "termes : " + uiquery + "\n" + "filtres : " + uifilter + "\n" + "heure de notification : " + DateTime
						.now()
						.getHourOfDay() + "\n" + "fréquence : " + unityFrequence + " " + typeOfUnityFrequence);
				
			}
		} else {
			mSwitch.setText("Alert activée avec les paramètres suivants = \n" + "" + "termes : " + uiquery + "\n" + "filtres : " + uifilter + "\n" + "notifications instanée");
			
		}
		Toast
				.makeText(SetNotificationsActivity.this, "Votre alerte est activée", Toast.LENGTH_LONG)
				.show();
		
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
		mPreferences
				.edit()
				.putString(PREF_KEY_BEGIN_DATE, beginDateInRightFormat)
				.apply();
		mPreferences
				.edit()
				.putString(PREF_KEY_FILTER, stringFilter)
				.apply();
		mPreferences
				.edit()
				.putString(PREF_KEY_QUERY, alertQueryTerm)
				.apply();
		mPreferences
				.edit()
				.putInt(PREF_KEY_HOUR_OF_NOTIFICATION, hourOfNotification)
				.apply();
		mPreferences
				.edit()
				.putInt(PREF_KEY_NUMBER_OF_TIME_UNITY, unityFrequence)
				.apply();
		mPreferences
				.edit()
				.putString(PREF_KEY_TIME_UNITY, typeOfUnityFrequence)
				.apply();
		mPreferences
				.edit()
				.putString(PREF_KEY_ALERT_STATE, alertState)
				.apply();
		
	}
	
	public void notifyTheUser() {
		
		viewModelMyNewsForSearchArticles
				.getNews()
				.observe(SetNotificationsActivity.this, this::updateList);
		
		if (hourOfNotification != 25) {
			if (DateTime
					    .now()
					    .getHourOfDay() < hourOfNotification) {
				delay = (int) new Duration(DateTime.now(), DateTime
						.now()
						.withTimeAtStartOfDay()
						.plusHours(hourOfNotification)).getStandardMinutes();
			} else {
				delay = (int) new Duration(DateTime.now(), DateTime
						.now()
						.withTimeAtStartOfDay()
						.plusDays(1)
						.plusHours(hourOfNotification)).getStandardMinutes();
			}
		}
		
		Constraints constraints = new Constraints.Builder().build();
		
		if (hourOfNotification == 25) {
			saveRequest = new PeriodicWorkRequest.Builder(UploadWorker.class, unityFrequenceLogic, TimeUnit.MINUTES)
					.addTag("send_reminder_periodic")
					.setConstraints(constraints)
					.build();
		} else {
			saveRequest = new PeriodicWorkRequest.Builder(UploadWorker.class, unityFrequenceLogic, TimeUnit.MINUTES)
					.setInitialDelay(delay, TimeUnit.MINUTES)
					.addTag("send_reminder_periodic")
					.setConstraints(constraints)
					.build();
		}
		
		WorkManager
				.getInstance(SetNotificationsActivity.this)
				.enqueueUniquePeriodicWork("send_reminder_periodic", ExistingPeriodicWorkPolicy.REPLACE, saveRequest);
		
	}
	
	public void searchFilter(CheckBox checkBox) {
		if (checkBox.isChecked()) {
			listFilters.add(checkBox
					                .getText()
					                .toString());
		}
	}
	
	public void updateList(List<Articles> articlesList) {
		articles.clear();
		if (articlesList != null) {
			articles.addAll(articlesList);
			if (articlesList.size() == 0) {
				Toast
						.makeText(SetNotificationsActivity.this, "Il n'y a aucuns nouveaux " + "résultats " + "depuis hier", Toast.LENGTH_LONG)
						.show();
				
			} else {
				
				Toast
						.makeText(SetNotificationsActivity.this, "Il y a des nouveaux résultats depuis hier", Toast.LENGTH_LONG)
						.show();
				
			}
		} else {
			Toast
					.makeText(SetNotificationsActivity.this, "BAD_REQUEST", Toast.LENGTH_LONG)
					.show();
			
			mSwitch.setChecked(false);
		}
	}
	
	
	
	@Override
	public void onClick(View parameterView) {
	
	}
}
