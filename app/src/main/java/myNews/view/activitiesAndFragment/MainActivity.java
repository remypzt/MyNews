package myNews.view.activitiesAndFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.myNews.R;
import myNews.view.adaptater.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
	
	@BindView(R.id.view_pager) public   ViewPager      viewPager;
	@BindView(R.id.drawerLayout) public DrawerLayout   drawer;
	@BindView(R.id.tab_layout) public   TabLayout      tabLayout;
	@BindView(R.id.toolbar) public      Toolbar        toolbar;
	@BindView(R.id.nav_view) public     NavigationView navigationView;
	
	private String[] pageTitle = {"Top Stories", "Most Popular", "Technology"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar);
		
		//For compatibility api16 to api22
		try {
			ProviderInstaller.installIfNeeded(getApplicationContext());
		}
		catch (GooglePlayServicesRepairableException e) {
			//Indicates that Google Play services is out of date, disabled, etc
			Log.e("api", Log.getStackTraceString(e));
			//Prompt the user to install/update/enable Google play services
			GoogleApiAvailability
					.getInstance()
					.showErrorNotification(getApplicationContext(), e.getConnectionStatusCode());
			
		}
		catch (GooglePlayServicesNotAvailableException e) {
			//Indicates a non recoverable error; the ProviderInstaller is not able to install an up to date Provide
			Log.e("api", Log.getStackTraceString(e));
			
		}
		
		//create default navigation drawer toggle
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();
		
		//setting Tab layout (number of Tabs = number of ViewPager pages)
		for (int i = 0;
		     i < 3;
		     i++) {
			tabLayout.addTab(tabLayout
					                 .newTab()
					                 .setText(pageTitle[i]));
		}
		
		//set gravity for tab bar
		tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
		
		//handling navigation view item event
		assert navigationView != null;
		navigationView.setNavigationItemSelectedListener(this);
		
		//set viewpager adapter
		ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(pagerAdapter);
		
		//change Tab selection when swipe ViewPager
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
		
		//change ViewPager page when tab selected
		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				
				viewPager.setCurrentItem(tab.getPosition());
				
			}
			
			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
			
			}
			
			@Override
			public void onTabReselected(TabLayout.Tab tab) {
			
			}
		});
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.toolbar, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		
		if (id == R.id.menuNotifications) {
			Intent SetNotificationsActivity = new Intent(MainActivity.this, SetNotificationsActivity.class);
			startActivity(SetNotificationsActivity);
		}
		if (id == R.id.action_search) {
			Intent SearchActivity = new Intent(MainActivity.this, SearchActivity.class);
			startActivity(SearchActivity);
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		int id = item.getItemId();
		
		switch (id) {
			case R.id.fr1:
				viewPager.setCurrentItem(0);
				break;
			case R.id.fr2:
				viewPager.setCurrentItem(1);
				break;
			case R.id.fr3:
				viewPager.setCurrentItem(2);
				break;
			case R.id.close:
				Intent homeIntent = new Intent(Intent.ACTION_MAIN);
				homeIntent.addCategory(Intent.CATEGORY_HOME);
				homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(homeIntent);
				break;
		}
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
	
	@Override
	public void onBackPressed() {
		assert drawer != null;
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
}

