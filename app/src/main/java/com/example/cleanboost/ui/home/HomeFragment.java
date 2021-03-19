package com.example.cleanboost.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cleanboost.R;

import java.util.Random;

import soup.neumorphism.NeumorphCardView;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ///Navigate on ImageButton press
        final NeumorphCardView scan = view.findViewById(R.id.scan_btn);
        //((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // ((AppCompatActivity)getActivity()).getSupportActionBar().setCustomView(R.layout.test);

        scan.setOnClickListener(v->replaceFragment(new ScanFragment()));

        ///Load ProgressBar that is inside the fragment_home view
        ProgressBar simpleProgressBar= view.findViewById(R.id.simpleProgressBar); // initiate the progress bar
        TextView progressBarStatus = view.findViewById(R.id.toolbar_status);
        simpleProgressBar.setMax(100); // 100 maximum value for the progress bar

        //Generate random number for now
        //in the future it will be updated based on how long the user hasn't had a full scan
        final int randomGeneratedStatus = new Random().nextInt(101) + 1;
        simpleProgressBar.setProgress(randomGeneratedStatus); // 50 default progress value for the progress bar

        if(randomGeneratedStatus<=40)
        {progressBarStatus.setText(getResources().getString(R.string.status_poor));
            progressBarStatus.setTextColor(getResources().getColor(R.color.activePrimary));
            simpleProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar));}

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

}