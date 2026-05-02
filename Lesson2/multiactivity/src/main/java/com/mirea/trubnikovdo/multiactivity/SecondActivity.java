package com.mirea.trubnikovdo.multiactivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i(TAG, "onCreate()");

        TextView textView = findViewById(R.id.textViewData);
        LinearLayout spinningGroup = findViewById(R.id.spinningGroup);


        String text = getIntent().getStringExtra("email_text");

        if (text != null && !text.isEmpty()) {
            textView.setText(text);
        } else {
            textView.setText("Пустое сообщение");
        }

        // --- 1. ВРАЩЕНИЕ ВОКРУГ ОСИ Y (Карусель) ---
        ObjectAnimator spinY = ObjectAnimator.ofFloat(spinningGroup, "rotationY", 0f, 360f);
        spinY.setDuration(5000); // 2.5 секунды на полный оборот
        spinY.setRepeatCount(ValueAnimator.INFINITE); // Бесконечно
        spinY.setInterpolator(new LinearInterpolator()); // Равномерная скорость

        // --- 2. ПОКАЧИВАНИЕ ВОКРУГ ОСИ X (Вверх-вниз / Кивки) ---
        // Отклоняем на 15 градусов назад и вперед
        ObjectAnimator wobbleX = ObjectAnimator.ofFloat(spinningGroup, "rotationX", -5f, 5f);
        wobbleX.setDuration(2400); // Время отличается от Y, чтобы анимация выглядела "живой"
        wobbleX.setRepeatCount(ValueAnimator.INFINITE);
        // REVERSE заставляет анимацию идти туда-сюда плавно (15 -> -15 -> 15...)
        wobbleX.setRepeatMode(ValueAnimator.REVERSE);

        // --- 3. ПОКАЧИВАНИЕ ВОКРУГ ОСИ Z (Влево-вправо / Маятник) ---
        // В Android свойство "rotation" - это вращение в 2D (по оси Z)
        ObjectAnimator tiltZ = ObjectAnimator.ofFloat(spinningGroup, "rotation", -8f, 8f);
        tiltZ.setDuration(1700); // Еще одно отличающееся время
        tiltZ.setRepeatCount(ValueAnimator.INFINITE);
        tiltZ.setRepeatMode(ValueAnimator.REVERSE); // Туда-сюда

        // ЗАПУСКАЕМ ВСЕ 3 АНИМАЦИИ ОДНОВРЕМЕННО
        spinY.start();
        wobbleX.start();
        tiltZ.start();

    }
}