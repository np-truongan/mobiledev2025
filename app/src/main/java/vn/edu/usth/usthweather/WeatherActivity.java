package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {

            @Override
            public Fragment getItem(int position) {
                // Return a new WeatherAndForecastFragment instance
                return new WeatherAndForecastFragment();
            }

            @Override
            public int getCount() {
                return 3; // 3 pages
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "City " + (position + 1);
            }
        };

        viewPager.setAdapter(adapter);

        Log.i("data", "onCreate called.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("data", "OnStart called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("data", "onStop called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("data", "onDestroy called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Data", "onPause called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("data", "onResume called.");
    }
}