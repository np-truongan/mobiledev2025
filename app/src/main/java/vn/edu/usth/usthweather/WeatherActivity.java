package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    public static final String ARG_CITY_NAME = "city_name"; // Consistent key
    private static final String TAG = "WeatherActivity";

    private String[] cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize cities array using string resources
        initializeCities();

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

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

        Log.i(TAG, "Activity created with " + cities.length + " cities");
    }

    /**
     * Initialize the cities array using string resources
     * This ensures proper localization support and consistency with other components
     */
    private void initializeCities() {
        cities = new String[]{
                getString(R.string.city_hanoi),
                getString(R.string.city_paris),
                getString(R.string.city_tokyo)
        };
    }

    /**
     * Get the current cities array
     * @return Array of city names
     */
    public String[] getCities() {
        return cities.clone(); // Return a copy to prevent external modification
    }

    /**
     * Get city name at specific position
     * @param position The position index
     * @return The city name at the given position, or null if invalid position
     */
    public String getCityAtPosition(int position) {
        if (position >= 0 && position < cities.length) {
            return cities[position];
        }
        return null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume called.");
    }
}