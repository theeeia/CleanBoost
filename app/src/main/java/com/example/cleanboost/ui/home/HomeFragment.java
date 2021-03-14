package com.example.cleanboost.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
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

import java.util.Random;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ///Load ProgressBar that is inside the fragment_home view
        ProgressBar simpleProgressBar= getView().findViewById(R.id.simpleProgressBar); // initiate the progress bar
        TextView progressBarStatus = getView().findViewById(R.id.toolbar_status);
        simpleProgressBar.setMax(100); // 100 maximum value for the progress bar

        //Generate random number for now
        //in the future it will be updated based on how long the user hasn't had a full scan
        final int randomGeneratedStatus = new Random().nextInt(101) + 1;
        simpleProgressBar.setProgress(randomGeneratedStatus); // 50 default progress value for the progress bar

        if(randomGeneratedStatus<=40)
        {progressBarStatus.setText(getResources().getString(R.string.status_poor));
            progressBarStatus.setTextColor(getResources().getColor(R.color.activePrimary));
            simpleProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar));
        }
        else if(randomGeneratedStatus<=80)
        {progressBarStatus.setText(getResources().getString(R.string.status_ok));
            progressBarStatus.setTextColor(getResources().getColor(R.color.primaryYellow));
            simpleProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_ok));}
        else
        {progressBarStatus.setText(getResources().getString(R.string.status_good));
            progressBarStatus.setTextColor(getResources().getColor(R.color.primaryGreen));
            simpleProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_good));}
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