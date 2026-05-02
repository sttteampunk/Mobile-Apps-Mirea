package com.mirea.trubnikovdo.mireaproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;

public class DataFragment extends Fragment {

    private TextView spinView;
    private final String[] spinnerFrames = {"|", "/", "-", "\\"};
    private int spinIndex = 0;
    private final Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable spinRunnable = new Runnable() {
        @Override
        public void run() {
            if (spinView != null) {
                spinView.setText(spinnerFrames[spinIndex]);
                spinIndex = (spinIndex + 1) % spinnerFrames.length;
                handler.postDelayed(this, 150);
            }
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        // --- ANIMATION SETUP ---
        spinView = view.findViewById(R.id.spinText);
        handler.post(spinRunnable);

        // --- CLICK TOGGLE SETUP ---
        MaterialCardView card1 = view.findViewById(R.id.card1);
        MaterialCardView card2 = view.findViewById(R.id.card2);
        MaterialCardView card3 = view.findViewById(R.id.card3);

        // Create a listener that flips the "Selected" status
        View.OnClickListener toggleListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If it's selected, unselect it. If unselected, select it.
                v.setSelected(!v.isSelected());
            }
        };

        // Attach listener to all three cards
        card1.setOnClickListener(toggleListener);
        card2.setOnClickListener(toggleListener);
        card3.setOnClickListener(toggleListener);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(spinRunnable);
        spinView = null;
    }
}