package myNews.view.activitiesAndFragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.yalantis.jellytoolbar.listener.JellyListener;
import com.yalantis.jellytoolbar.widget.JellyToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import myNews.myNews.R;
import myNews.view.adaptater.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.view_pager) public ViewPager viewPager;
    @BindView(R.id.drawerLayout) public DrawerLayout drawer;
    @BindView(R.id.tab_layout) public TabLayout tabLayout;
    @BindView(R.id.toolbar)
    public JellyToolbar toolbar;
    @BindView(R.id.nav_view) public  NavigationView navigationView;

    private String[] pageTitle = {"Top Stories", "Most Popular", "Technology"};


    private JellyToolbar mJellyToolbar;
    private AppCompatEditText editText;
    //Jelly toolbar
    private JellyListener jellyListener = new JellyListener() {
        @Override
        public void onCancelIconClicked() {
            if (TextUtils.isEmpty(editText.getText())) {
                mJellyToolbar.collapse();
            } else {
                editText.getText().clear();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //setSupportActionBar(toolbar);


        //create default navigation drawer toggle
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();*/


        //JellyToolbar
        mJellyToolbar = findViewById(R.id.toolbar);
        mJellyToolbar.getToolbar().setNavigationIcon(R.drawable.ic_menu);
        mJellyToolbar.setJellyListener(jellyListener);

        editText = (AppCompatEditText) LayoutInflater.from(this).inflate(R.layout.edit_text, null);
        editText.setBackgroundResource(R.color.colorTransparent);
        mJellyToolbar.setContentView(editText);


        //setting Tab layout (number of Tabs = number of ViewPager pages)
        for (int i = 0; i < 3; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
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
                finish();
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
