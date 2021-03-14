package com.example.cleanboost.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cleanboost.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private String kombinacija = "";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final Button scan = root.findViewById(R.id.scan_btn);
        //((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
       // ((AppCompatActivity)getActivity()).getSupportActionBar().setCustomView(R.layout.test);

        scan.setOnClickListener(new ToggleButton.OnClickListener() {
            public void onClick(View view) {
                    replaceFragment(formatFragment("scan", new ScanFragment()));
            }
        });

        return root;
    }

    public void replaceFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack(null).commit();
    }

    public Fragment formatFragment(String string, Fragment fragment) {
        kombinacija += string;
        Bundle args = new Bundle();
        args.putString("string", kombinacija);
        fragment.setArguments(args);
        return fragment;
    }
}