package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        // Get city name from arguments, default to Hanoi using string resources
        if (getArguments() != null) {
            cityName = getArguments().getString(
                    WeatherActivity.ARG_CITY_NAME,
                    getString(R.string.city_hanoi) // Use string resource for default
            );
        } else {
            cityName = getString(R.string.city_hanoi); // Default to Hanoi from resources
        }

        if (savedInstanceState == null) {
            setupChildFragments();
        }

        return view;
    }

    /**
     * Sets up the child fragments (WeatherFragment and ForecastFragment)
     */
    private void setupChildFragments() {
        // Create WeatherFragment with city name arguments
        WeatherFragment weatherFragment = new WeatherFragment();
        Bundle weatherArgs = new Bundle();
        weatherArgs.putString(WeatherActivity.ARG_CITY_NAME, cityName);
        weatherFragment.setArguments(weatherArgs);

        // Create ForecastFragment
        ForecastFragment forecastFragment = new ForecastFragment();

        // Replace fragments in their containers
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.weather_container, weatherFragment);
        ft.replace(R.id.forecast_container, forecastFragment);
        ft.commit();
    }

    /**
     * Updates the city name and refreshes the weather fragment
     * @param newCityName The new city name to display
     */
    public void updateCity(String newCityName) {
        this.cityName = newCityName;

        // Update the weather fragment with new city data
        WeatherFragment weatherFragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(WeatherActivity.ARG_CITY_NAME, cityName);
        weatherFragment.setArguments(args);

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.weather_container, weatherFragment);
        ft.commit();
    }

    /**
     * Gets the current city name
     * @return The current city name being displayed
     */
    public String getCurrentCity() {
        return cityName != null ? cityName : getString(R.string.city_hanoi);
    }
}