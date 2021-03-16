package com.example.cleanboost.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import com.example.cleanboost.R;
import com.example.cleanboost.ui.cpu.CpuFragment;
import com.example.cleanboost.ui.storage.StorageFragment;


public class ScanFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_scan, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Button navigation to the action screens
        final Button cpu_btn = getView().findViewById(R.id.cpu_btn);
        final Button storage_btn = getView().findViewById(R.id.storage_btn);
        final Button battery_btn = getView().findViewById(R.id.battery_btn);
        final Button vpn_btn = getView().findViewById(R.id.vpn_btn);

        cpu_btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                replaceFragment(new CpuFragment());
            }
        });

        storage_btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                replaceFragment(new StorageFragment());
            }
        });
        ///Above can also be replaced with lambda
        battery_btn.setOnClickListener((View v)->{
             Navigation.findNavController(getView()).navigate(R.id.navigation_battery);
        });
        vpn_btn.setOnClickListener((View v)->{
            Navigation.findNavController(getView()).navigate(R.id.navigation_vpn);
        });
    }

    public void replaceFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack(null).commit();
    }
}