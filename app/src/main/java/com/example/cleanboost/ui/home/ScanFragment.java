package com.example.cleanboost.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

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
        final Button cpu_btn = root.findViewById(R.id.cpu_btn);
        final Button storage_btn = root.findViewById(R.id.storage_btn);
        final Button battery_btn = root.findViewById(R.id.battery_btn);
        final Button vpn_btn = root.findViewById(R.id.vpn_btn);

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





        return root;
    }

    public void replaceFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack(null).commit();
    }
}