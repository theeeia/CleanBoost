package com.example.cleanboost.ui.battery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cleanboost.R;


public class BatteryFragment extends Fragment {

    private BatteryViewModel batteryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        batteryViewModel =
                new ViewModelProvider(this).get( BatteryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_battery, container, false);
        final TextView textView = root.findViewById(R.id.text_battery);
        batteryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}