package com.mirea.trubnikovdo.lesson3;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class IntentAppResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_app_result);

        TextView textViewResult = findViewById(R.id.textViewResult);

        // 1. Получаем Intent, который запустил эту активность
        // и достаем строку по ключу "current_time"
        String time = getIntent().getStringExtra("current_time");

        // 2. Ваш номер по списку в группе (поменяйте на свой!)
        int myListNumber = 24;
        int squareResult = myListNumber * myListNumber;

        // 3. Формируем итоговую строку согласно методичке
        String text = String.format("квадрат номера в группе %d, а текущее время %s", squareResult, time);

        // 4. Выводим на экран
        textViewResult.setText(text);
    }
}