package com.mirea.trubnikovdo.multiactivity;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private final String TAG = MainActivity.class.getSimpleName();
    private static final String CHANNEL_ID = "com.mirea.mailapp.notification";
    private final int PermissionCode = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate()");

        editTextInput = findViewById(R.id.editTextInput);

    }

    public void onSendMail(View view) {
        String text = editTextInput.getText().toString();
        int charCount = text.length();

        String msg = "СТУДЕНТ № 24 БСБО 53-24 Трубников Данила Олегович Количество символов - " + charCount;
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("email_text", text);
        startActivity(intent);
    }

    public void onShareData(View view) {
        String text = editTextInput.getText().toString();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA Mail");
        shareIntent.putExtra(Intent.EXTRA_TEXT, text + "\n-- Отправлено студентом МИРЭА");
        startActivity(Intent.createChooser(shareIntent, "Поделиться письмом"));
    }

    public void onOpenBrowser(View view) {
        Uri address = Uri.parse("https://www.mirea.ru/");
        Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openLinkIntent);
    }

    public void onClickSendNotification(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .setContentTitle("Новое сообщение")
                .setContentText("У вас 1 непрочитанное письмо")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        notificationManager.notify(1, builder.build());
    }


    public void onClickShowDialog(View view) {
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea_dialog");
    }

    public void onOkClicked() { Toast.makeText(this, "Сохранено в черновики!", Toast.LENGTH_SHORT).show(); }
    public void onCancelClicked() { Toast.makeText(this, "Не сохранено", Toast.LENGTH_SHORT).show(); }
    public void onNeutralClicked() { Toast.makeText(this, "Действие отменено", Toast.LENGTH_SHORT).show(); }

    public void onClickShowDateDialog(View view) {
        new MyDateDialogFragment().show(getSupportFragmentManager(), "datePicker");
    }

    public void onClickShowTimeDialog(View view) {
        new MyTimeDialogFragment().show(getSupportFragmentManager(), "timePicker");
    }

    public void onClickShowProgressDialog(View view) {
        new MyProgressDialogFragment().show(getSupportFragmentManager(), "progressDialog");
    }

    public void onClickShowSnackbar(View view) {
        Snackbar.make(view, "Черновик удален", Snackbar.LENGTH_LONG)
                .setAction("Отменить", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Восстановлено!", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    @Override protected void onStart() { super.onStart(); Log.i(TAG, "onStart()"); }
    @Override protected void onResume() { super.onResume(); Log.i(TAG, "onResume()"); }
    @Override protected void onPause() { super.onPause(); Log.i(TAG, "onPause()"); }
    @Override protected void onStop() { super.onStop(); Log.i(TAG, "onStop()"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.i(TAG, "onDestroy()"); }
    @Override protected void onRestart() { super.onRestart(); Log.i(TAG, "onRestart()"); }
}