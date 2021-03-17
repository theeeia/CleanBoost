package com.example.cleanboost.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cleanboost.R;
import com.example.cleanboost.ui.cpu.CpuFragment;
import com.example.cleanboost.ui.storage.StorageFragment;

import java.util.Random;


public class ScanFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
            simpleProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar));}

        else if(randomGeneratedStatus<=80)
        {progressBarStatus.setText(getResources().getString(R.string.status_ok));
            progressBarStatus.setTextColor(getResources().getColor(R.color.primaryYellow));
            simpleProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_ok));}
        else
        {progressBarStatus.setText(getResources().getString(R.string.status_good));
            progressBarStatus.setTextColor(getResources().getColor(R.color.primaryGreen));
            simpleProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_good));}

        //Button navigation to the action screens
        final Button cpu_btn = view.findViewById(R.id.cpu_btn);
        final Button storage_btn = view.findViewById(R.id.storage_btn);
        final Button battery_btn = view.findViewById(R.id.battery_btn);
        final Button vpn_btn = view.findViewById(R.id.vpn_btn);

        cpu_btn.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.navigation_cpu)
        );

        storage_btn.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.navigation_storage)
        );
        ///Above can also be replaced with lambda
        battery_btn.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.navigation_battery)
        );
        vpn_btn.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.navigation_vpn));
    }

    public void replaceFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack(null).commit();
    }
}