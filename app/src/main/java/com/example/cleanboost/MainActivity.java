package com.example.cleanboost;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_storage, R.id.navigation_cpu, R.id.navigation_home, R.id.navigation_vpn,R.id.navigation_battery)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        //action bar
       getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.opt_actionbar);
        getSupportActionBar().setElevation(0);

        ProgressBar simpleProgressBar=(ProgressBar) findViewById(R.id.simpleProgressBar); // initiate the progress bar
        TextView progressBarStatus = (TextView) findViewById(R.id.toolbar_status);
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



}