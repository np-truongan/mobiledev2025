package vn.edu.usth.usthweather;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ForecastFragment extends Fragment {

    private final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private final int[] icons = {
            R.drawable.sunny,   // Monday
            R.drawable.rainy,   // Tuesday
            R.drawable.cloudy,  // Wednesday
            R.drawable.lightening,   // Thursday
            R.drawable.snowy,        // Friday
            R.drawable.haily,        //Saturday
            R.drawable.windy        //Sunday
    };
    private final String[] descriptions = {
            "Partly Cloudy", "Showers", "Rain",
            "Scattered Showers", "Mostly Cloudy",
            "Partly Cloudy", "Thunderstorms",
            "Scattered Thunderstorms", "Showers",
            "Scattered Thunderstorms"
    };
    private final String[] temperatures = {
            "24C - 31C", "24C - 30C", "22C - 23C",
            "22C - 27C", "22C - 30C", "24C - 31C",
            "25C - 28C", "24C - 27C", "24C - 26C",
            "23C - 27C"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout linearLayout = new LinearLayout(requireContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Create LayoutParams with margins
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        // Convert dp → px for consistent margins
        int margin = (int) (16 * getResources().getDisplayMetrics().density);
        params.setMargins(margin, margin, margin, margin);

        // Apply params to layout
        linearLayout.setLayoutParams(params);

        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        // Padding inside the layout
        int padding = (int) (16 * getResources().getDisplayMetrics().density);
        linearLayout.setPadding(padding, padding, padding, padding);

        // Semi-transparent blue background
        linearLayout.setBackgroundColor(0x200000FF);


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
            rowLayout.setPadding(0, 24, 0, 24);

            // TextView
            TextView dayView = new TextView(requireContext());
            dayView.setText(days[i]);
            dayView.setTextSize(16f);
            dayView.setTextColor(Color.BLACK);
            LinearLayout.LayoutParams dayParams = new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f // weight so text takes up space
            );
            dayView.setLayoutParams(dayParams);

            // Weather Icon ImageView
            ImageView imageView = new ImageView(requireContext());
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                    80,
                    80
            );
            imageParams.setMarginEnd(32);
            imageView.setLayoutParams(imageParams);
            imageView.setImageResource(icons[i]);

            LinearLayout descLayout = new LinearLayout(requireContext());
            descLayout.setOrientation(LinearLayout.VERTICAL);
            descLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 2f
            ));

            TextView descView = new TextView(requireContext());
            descView.setText(descriptions[i]);
            descView.setTextSize(15f);
            descView.setTextColor(Color.BLACK);

            TextView tempView = new TextView(requireContext());
            tempView.setText(temperatures[i]);
            tempView.setTextSize(14f);
            tempView.setTextColor(Color.DKGRAY);

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