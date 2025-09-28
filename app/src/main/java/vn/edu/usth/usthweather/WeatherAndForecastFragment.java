package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class WeatherAndForecastFragment extends Fragment {

    private String cityName;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_and_forecast, container, false);

        if (getArguments() != null) {
            cityName = getArguments().getString(WeatherActivity.ARG_CITY_NAME, "Unknown");
        }

        if (savedInstanceState == null) {
            WeatherFragment weatherFragment = new WeatherFragment();
            Bundle args = new Bundle();
            args.putString(WeatherActivity.ARG_CITY_NAME, cityName);
            weatherFragment.setArguments(args);

            ForecastFragment forecastFragment = new ForecastFragment();

            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.weather_container, weatherFragment);
            ft.replace(R.id.forecast_container, forecastFragment);
            ft.commit();
        }

        return view;
    }

}
