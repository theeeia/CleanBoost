package com.example.cleanboost.ui.cpu;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.cleanboost.R;
import com.example.cleanboost.ui.home.ScanFragment;

public class CpuFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return  inflater.inflate(R.layout.fragment_cpu, container, false);
    }
    private void startCountAnimation(TextView numberAnimated, int from, int to) {
        ValueAnimator animator = ValueAnimator.ofInt(from, to);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                numberAnimated.setText(animation.getAnimatedValue().toString()+"%");
            }
        });
        animator.start();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Animate cpuNumber
        TextView cpuNumber = view.findViewById(R.id.cpu_number);
        startCountAnimation(cpuNumber,0,88);

        //Animate ram number
        TextView ramNumber = view.findViewById(R.id.ram_number);
        startCountAnimation(ramNumber,0,76);



        // Image on click listener
        // TODO: Implement navigation to activity when added

    }

}