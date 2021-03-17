package com.example.cleanboost.ui.storage;

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

public class StorageFragment extends Fragment {

    private StorageViewModel storageViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      storageViewModel =
                new ViewModelProvider(this).get(StorageViewModel.class);
        View root = inflater.inflate(R.layout.fragment_storage, container, false);
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