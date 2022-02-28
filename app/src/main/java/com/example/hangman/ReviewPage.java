package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ReviewPage extends AppCompatActivity {
    private int numberOfWordsPlayed;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_page);
        Bundle extras = getIntent().getExtras();
        numberOfWordsPlayed = extras.getInt("numberOfWordsPlayed");
        SharedPreferences sp = getApplicationContext().getSharedPreferences("review", Context.MODE_PRIVATE);
        Log.d("debug","Entering Review Page");
        Log.d("debug","numberOfWordsPlayed: "+numberOfWordsPlayed);
        for (int i = 0; i < numberOfWordsPlayed; i++) {
                String previous = tv.getText().toString();
                tv.setText(previous+sp.getString(i+"",""));
                Log.d("debug",sp.getString(i+"",""));
        }

    }
    private String[] extractWord(String line){
        String[] wordAndHint = line.split(" - ",2);
        return wordAndHint;
    }
}