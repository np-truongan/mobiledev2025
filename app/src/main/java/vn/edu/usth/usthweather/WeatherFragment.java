package vn.edu.usth.usthweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        String cityName = "Unknown";
        if (getArguments() != null) {
            cityName = getArguments().getString("city_name", "Unknown");
            cityView.setText(cityName);
            tempCondition.setText(getWeatherTextForCity(cityName));
        }

        // Temperature + Condition (Top Left)

        tempCondition.setId(View.generateViewId());
        tempCondition.setText(getWeatherTextForCity(cityName));  // 👈 dynamic text
        tempCondition.setTextSize(18f);
        tempCondition.setTextColor(0xFF000000);

        RelativeLayout.LayoutParams tempParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        tempParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        tempParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        tempParams.setMargins(24, 24, 0, 0);
        tempCondition.setLayoutParams(tempParams);

        // City name (Top Right)

        cityView.setId(View.generateViewId());
        cityView.setText(cityName);
        cityView.setTextSize(16f);
        cityView.setTextColor(0xFF000000);

        RelativeLayout.LayoutParams cityParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        cityParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        cityParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        cityParams.setMargins(0, 24, 24, 0);
        cityView.setLayoutParams(cityParams);

        // Weather icon (Center)
        ImageView iconView = new ImageView(requireContext());
        iconView.setId(View.generateViewId());
        iconView.setImageResource(R.drawable.cloudy); // default icon

        RelativeLayout.LayoutParams iconParams = new RelativeLayout.LayoutParams(
                200,
                200
        );
        iconParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        iconView.setLayoutParams(iconParams);

        // Add views
        relativeLayout.addView(tempCondition);
        relativeLayout.addView(cityView);
        relativeLayout.addView(iconView);

        return relativeLayout;
    }

    // Choose text (and later you could pick icons) based on city
    private String getWeatherTextForCity(String city) {
        switch (city) {
            case "Hanoi":
                return "30°C\nSunny";
            case "Paris":
                return "18°C\nRainy";
            case "Tokyo":
                return "22°C\nCloudy";
            default:
                return "12°C\nCloudy";
        }
    }

    @NonNull
    private RelativeLayout getRelativeLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                400 // fixed height, adjust as needed
        );
        relativeLayout.setLayoutParams(params);
        int margin = (int) (16 * getResources().getDisplayMetrics().density);
        params.setMargins(margin, margin, margin, margin);
        relativeLayout.setBackgroundColor(0x2000FF00); // light green
        return relativeLayout;
    }
}
