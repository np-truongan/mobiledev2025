package vn.edu.usth.usthweather;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ForecastFragment extends Fragment {

    private final int[] icons = {
            R.drawable.sunny,        // Monday
            R.drawable.rainy,        // Tuesday
            R.drawable.cloudy,       // Wednesday
            R.drawable.lightening,   // Thursday
            R.drawable.snowy,        // Friday
            R.drawable.haily,        // Saturday
            R.drawable.windy         // Sunday
    };

    // Weather descriptions using string resources
    private final int[] weatherDescriptionIds = {
            R.string.weather_sunny,           // Monday - Sunny
            R.string.weather_rainy,           // Tuesday - Rainy
            R.string.weather_cloudy,          // Wednesday - Cloudy
            R.string.weather_lightening,      // Thursday - Scattered Thunderstorms
            R.string.weather_snowy,           // Friday - Snowy
            R.string.weather_haily,           // Saturday - Hailstorm
            R.string.weather_windy            // Sunday - Windy
    };

    private final String[] temperatures = {
            "24C - 31C", "24C - 30C", "22C - 23C",
            "22C - 27C", "22C - 30C", "24C - 31C",
            "25C - 28C"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout with ScrollView
        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);
        FrameLayout forecastContainer = rootView.findViewById(R.id.forecast_container);

        // Create your LinearLayout as before
        LinearLayout linearLayout = createForecastLayout();

        // Add the LinearLayout to the container
        forecastContainer.addView(linearLayout);

        return rootView;
    }

    private LinearLayout createForecastLayout() {
        LinearLayout linearLayout = new LinearLayout(requireContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Create LayoutParams with margins using dimension resources
        LinearLayout.LayoutParams mainParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        // Get margin from dimension resources
        int margin = getResources().getDimensionPixelSize(R.dimen.forecast_layout_margin);
        mainParams.setMargins(margin, margin, margin, margin);

        // Apply params to layout
        linearLayout.setLayoutParams(mainParams);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        // Padding using dimension resources
        int padding = getResources().getDimensionPixelSize(R.dimen.forecast_layout_padding);
        linearLayout.setPadding(padding, padding, padding, padding);

        // Background color using color resources
        linearLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.forecast_background));

        // Get days array from string resources
        String[] days = getResources().getStringArray(R.array.days_of_week);

        // Get dimension resources once for reuse
        int rowVerticalPadding = getResources().getDimensionPixelSize(R.dimen.forecast_row_vertical_padding);
        int iconSize = getResources().getDimensionPixelSize(R.dimen.forecast_weather_icon_size);
        int iconMarginEnd = getResources().getDimensionPixelSize(R.dimen.forecast_icon_margin_end);
        int dayTextSize = getResources().getDimensionPixelSize(R.dimen.forecast_day_text_size);
        int descTextSize = getResources().getDimensionPixelSize(R.dimen.forecast_description_text_size);
        int tempTextSize = getResources().getDimensionPixelSize(R.dimen.forecast_temperature_text_size);

        // Get layout weight values from dimension resources
        float dayWeight = getResources().getFloat(R.dimen.forecast_day_weight);
        float descWeight = getResources().getFloat(R.dimen.forecast_description_weight);

        // Loop through days and add TextView + ImageView for each
        for (int i = 0; i < days.length; i++) {
            // Create a horizontal layout for each forecast row
            LinearLayout rowLayout = new LinearLayout(requireContext());
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);
            rowLayout.setGravity(Gravity.CENTER_VERTICAL);
            rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            // Row padding using dimension resources
            rowLayout.setPadding(0, rowVerticalPadding, 0, rowVerticalPadding);

            // TextView for day
            TextView dayView = new TextView(requireContext());
            dayView.setText(days[i]);
            dayView.setTextSize(0, dayTextSize);
            dayView.setTextColor(ContextCompat.getColor(requireContext(), R.color.day_text_color));
            LinearLayout.LayoutParams dayParams = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    dayWeight
            );
            dayView.setLayoutParams(dayParams);

            // Weather Icon ImageView
            ImageView imageView = new ImageView(requireContext());
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(iconSize, iconSize);
            imageParams.setMarginEnd(iconMarginEnd);
            imageView.setLayoutParams(imageParams);
            imageView.setImageResource(icons[i]);

            // Description and temperature layout
            LinearLayout descLayout = new LinearLayout(requireContext());
            descLayout.setOrientation(LinearLayout.VERTICAL);
            descLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, descWeight
            ));

            // Weather description TextView
            TextView descView = new TextView(requireContext());
            descView.setText(getString(weatherDescriptionIds[i]));
            descView.setTextSize(0, descTextSize);
            descView.setTextColor(ContextCompat.getColor(requireContext(), R.color.description_text_color));

            // Temperature TextView
            TextView tempView = new TextView(requireContext());
            tempView.setText(temperatures[i]);
            tempView.setTextSize(0, tempTextSize);
            tempView.setTextColor(ContextCompat.getColor(requireContext(), R.color.temperature_text_color));

            descLayout.addView(descView);
            descLayout.addView(tempView);

            // Add components to row
            rowLayout.addView(dayView);
            rowLayout.addView(imageView);
            rowLayout.addView(descLayout);

            // Add row to main layout
            linearLayout.addView(rowLayout);
        }

        return linearLayout;
    }
}