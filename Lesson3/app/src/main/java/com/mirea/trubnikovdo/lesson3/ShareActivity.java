package com.mirea.trubnikovdo.lesson3;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {

    private EditText editTextBookName;
    private EditText editTextQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        editTextBookName = findViewById(R.id.editTextBookName);
        editTextQuote = findViewById(R.id.editTextQuote);
        TextView textViewDataFromMain = findViewById(R.id.textViewDataFromMain);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String initialBook = extras.getString("book_name");
            String initialQuote = extras.getString("quotes_name");
            textViewDataFromMain.setText(String.format("Передано из MainActivity:\n%s\n%s", initialBook, initialQuote));
        }
    }

    public void sendDataBack(View view) {
        String bookName = editTextBookName.getText().toString();
        String quote = editTextQuote.getText().toString();

        String resultString = String.format("Название Вашей любимой книги: %s. Цитата: %s", bookName, quote);

        Intent data = new Intent();

        data.putExtra(FavoriteBookActivity.USER_MESSAGE, resultString);

        setResult(Activity.RESULT_OK, data);

        finish();
    }
}