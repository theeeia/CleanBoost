package com.example.cleanboost.ui.battery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BatteryViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public BatteryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is battery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}