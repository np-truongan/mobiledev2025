package vn.edu.usth.usthweather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ForecastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = new View(getContext());
        v.setBackgroundColor(0x200000FF);
        return v;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_forecast, container, false);
    }
}