package com.example.cleanboost.ui.vpn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cleanboost.R;
import com.example.cleanboost.ui.battery.BatteryViewModel;


public class VpnFragment extends Fragment {

    private BatteryViewModel vpnViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vpnViewModel =
                new ViewModelProvider(this).get( BatteryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vpn, container, false);

        //((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
       // ((AppCompatActivity)getActivity()).getSupportActionBar().setCustomView(R.layout.opt_actionbar);

        final TextView textView = root.findViewById(R.id.text_vpn);
        vpnViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {



            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}