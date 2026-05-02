package com.mirea.trubnikovdo.lesson3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class SimpleFragmentActivity extends AppCompatActivity {

    private Fragment fragment1, fragment2;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);

        fragment1 = new BlankFragment();
        fragment2 = new BlankFragment2();
        fragmentManager = getSupportFragmentManager();


        Button btnFirstFragment = findViewById(R.id.btnFirstFragment);
        Button btnSecondFragment = findViewById(R.id.btnSecondFragment);

        if (btnFirstFragment != null && btnSecondFragment != null) {

            if (savedInstanceState == null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, fragment1)
                        .commit();
            }

            // Обработка кликов
            btnFirstFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView, fragment1)
                            .commit();
                }
            });

            btnSecondFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView, fragment2)
                            .commit();
                }
            });
        }

    }
}