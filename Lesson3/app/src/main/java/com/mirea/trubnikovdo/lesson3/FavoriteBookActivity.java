package com.mirea.trubnikovdo.lesson3;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class FavoriteBookActivity extends AppCompatActivity {

    static final String USER_MESSAGE = "MESSAGE";
    private TextView textViewUserBook;

    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_book);

        textViewUserBook = findViewById(R.id.textViewBook);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                String userBook = data.getStringExtra(USER_MESSAGE);
                                textViewUserBook.setText(userBook);
                            }
                        }
                    }
                }
        );
    }

    public void getInfoAboutBook(View view) {
        Intent intent = new Intent(this, ShareActivity.class);

        intent.putExtra("book_name", "!!!ВАША КНИГА, А НЕ МОЯ!!!");
        intent.putExtra("quotes_name", "!!!ВАША ЦИТАТА, А НЕ МОЯ!!!");

        activityResultLauncher.launch(intent);
    }
}