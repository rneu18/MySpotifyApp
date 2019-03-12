package com.example.myspotifyapp;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public int[] icons= {
            R.drawable.rock,
            R.drawable.classic,
            R.drawable.pop
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new RockFragment(), "Rock");
        adapter.addFragment(new ClassicFragment(), "Classic");
        adapter.addFragment(new PopFragment(), "Pop");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, false);

        tabLayout.setOnTabSelectedListener(
        new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.colorMyRed);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.colorPrimary);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                super.onTabReselected(tab);
            }
        }
        );

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        for (int iconsLoad = 0; iconsLoad < tabLayout.getTabCount(); iconsLoad++) {
            tabLayout.getTabAt(iconsLoad).setIcon(icons[iconsLoad]);
        }
    }

}