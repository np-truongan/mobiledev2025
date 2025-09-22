package vn.edu.usth.usthweather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class WeatherAndForecastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Root layout: vertical LinearLayout
        LinearLayout rootLayout = new LinearLayout(requireContext());
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        // Container for WeatherFragment
        FrameLayout weatherContainer = new FrameLayout(requireContext());
        weatherContainer.setId(View.generateViewId());
        weatherContainer.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        // Container for ForecastFragment
        FrameLayout forecastContainer = new FrameLayout(requireContext());
        forecastContainer.setId(View.generateViewId());
        LinearLayout.LayoutParams forecastParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f // fill remaining space
        );
        forecastContainer.setLayoutParams(forecastParams);

        // Add containers
        rootLayout.addView(weatherContainer);
        rootLayout.addView(forecastContainer);

        // Add child fragments
        getChildFragmentManager().beginTransaction()
                .replace(weatherContainer.getId(), new WeatherFragment())
                .replace(forecastContainer.getId(), new ForecastFragment())
                .commit();

        return rootLayout;
    }
}