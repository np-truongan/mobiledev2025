package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class WeatherFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        RelativeLayout relativeLayout = getRelativeLayout();
        TextView cityView = new TextView(requireContext());
        TextView tempCondition = new TextView(requireContext());

        // Get arguments from the pager
        String cityName = getString(R.string.city_hanoi); // Default to Hanoi
        if (getArguments() != null) {
            cityName = getArguments().getString("city_name", getString(R.string.city_hanoi));
        }

        // Temperature + Condition (Top Left)
        tempCondition.setId(View.generateViewId());
        tempCondition.setText(getWeatherTextForCity(cityName));
        tempCondition.setTextSize(18f);
        tempCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.weather_text_color));

        RelativeLayout.LayoutParams tempParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        tempParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        tempParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        // Use dimension resources for margins
        int margin = getResources().getDimensionPixelSize(R.dimen.forecast_layout_margin);
        tempParams.setMargins(margin + 8, margin + 8, 0, 0); // Adding slight offset for better positioning
        tempCondition.setLayoutParams(tempParams);

        // City name (Top Right)
        cityView.setId(View.generateViewId());
        cityView.setText(cityName);
        cityView.setTextSize(16f);
        cityView.setTextColor(ContextCompat.getColor(requireContext(), R.color.city_text_color));

        RelativeLayout.LayoutParams cityParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        cityParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        cityParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        cityParams.setMargins(0, margin + 8, margin + 8, 0); // Adding slight offset for better positioning
        cityView.setLayoutParams(cityParams);

        // Weather icon (Center)
        ImageView iconView = new ImageView(requireContext());
        iconView.setId(View.generateViewId());
        iconView.setImageResource(getWeatherIconForCity(cityName));

        // Use weather icon size from dimensions
        int iconSize = getResources().getDimensionPixelSize(R.dimen.forecast_weather_icon_size);
        RelativeLayout.LayoutParams iconParams = new RelativeLayout.LayoutParams(
                iconSize * 3, // Make it larger for the main weather display
                iconSize * 3
        );
        iconParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        iconView.setLayoutParams(iconParams);

        // Add views
        relativeLayout.addView(tempCondition);
        relativeLayout.addView(cityView);
        relativeLayout.addView(iconView);
        relativeLayout.setBackgroundResource(R.drawable.frame);

        return relativeLayout;
    }

    // Choose text based on city using string resources where possible
    private String getWeatherTextForCity(String city) {
        if (city.equals(getString(R.string.city_hanoi))) {
            return "30°C\n" + getString(R.string.weather_sunny);
        } else if (city.equals(getString(R.string.city_paris))) {
            return "18°C\n" + getString(R.string.weather_rainy);
        } else if (city.equals(getString(R.string.city_tokyo))) {
            return "22°C\n" + getString(R.string.weather_cloudy);
        } else {
            return "12°C\n" + getString(R.string.weather_cloudy);
        }
    }

    // Choose weather icon based on city
    private int getWeatherIconForCity(String city) {
        if (city.equals(getString(R.string.city_hanoi))) {
            return R.drawable.sunny;
        } else if (city.equals(getString(R.string.city_paris))) {
            return R.drawable.rainy;
        } else if (city.equals(getString(R.string.city_tokyo))) {
            return R.drawable.cloudy;
        } else {
            return R.drawable.cloudy; // default icon
        }
    }

    @NonNull
    private RelativeLayout getRelativeLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(requireContext());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                400 // Could be moved to dimensions if needed
        );
        relativeLayout.setLayoutParams(params);

        // Use dimension resources for margins
        int margin = getResources().getDimensionPixelSize(R.dimen.forecast_layout_margin);
        params.setMargins(margin, margin, margin, margin);

        // Use color resources for background
        relativeLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.weather_background));

        return relativeLayout;
    }
}