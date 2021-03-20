package com.example.cleanboost.ui.storage;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.cleanboost.R;

public class StorageFragment extends Fragment {

    private StorageViewModel storageViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      storageViewModel =
                new ViewModelProvider(this).get(StorageViewModel.class);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        View root = inflater.inflate(R.layout.fragment_storage_small, container, false);
        if(height > 1281 && width > 1000){

             root = inflater.inflate(R.layout.fragment_storage_big, container, false);
        }


       /*   final TextView textView = root.findViewById(R.id.text_storage);
        storageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}