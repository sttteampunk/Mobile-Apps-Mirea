package com.mirea.trubnikovdo.lesson3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openTask1(View view) {
        Intent intent = new Intent(this, IntentAppActivity.class);
        startActivity(intent);
    }
    public void openTask2(View view) {
         Intent intent = new Intent(this, FavoriteBookActivity.class);
         startActivity(intent);
    }

    public void openTask3(View view) {
        Intent intent = new Intent(this, SystemIntentsActivity.class);
        startActivity(intent);
    }

    public void openTask4(View view) {
         Intent intent = new Intent(this, SimpleFragmentActivity.class);
         startActivity(intent);
    }
}