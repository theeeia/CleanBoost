package com.example.cleanboost.ui.cpu;

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

public class CpuFragment extends Fragment {

    private CpuViewModel cpuViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cpuViewModel =
                new ViewModelProvider(this).get(CpuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cpu, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        cpuViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}