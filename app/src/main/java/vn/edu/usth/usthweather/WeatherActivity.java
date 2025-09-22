package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileReader;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.weather_container, new WeatherFragment())
                    .replace(R.id.forecast_container, new ForecastFragment())
                    .commit();
        }
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