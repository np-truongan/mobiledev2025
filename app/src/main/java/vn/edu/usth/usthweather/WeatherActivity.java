package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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