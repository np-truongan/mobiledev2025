package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    public static final String ARG_CITY_NAME = "city_name"; // 🔑 Consistent key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // Define your cities here (tabs = cities)
        final String[] cities = {"Hanoi", "Paris", "Tokyo"};

        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(
                getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {
            @Override
            public Fragment getItem(int position) {
                // Create a WeatherAndForecastFragment with the right city
                Bundle args = new Bundle();
                args.putString(ARG_CITY_NAME, cities[position]);

                WeatherAndForecastFragment fragment = new WeatherAndForecastFragment();
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getCount() {
                return cities.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return cities[position]; // Show city name on tab
            }
        };

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("WeatherActivity", "onStart called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("WeatherActivity", "onStop called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("WeatherActivity", "onDestroy called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("WeatherActivity", "onPause called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("WeatherActivity", "onResume called.");
    }
}