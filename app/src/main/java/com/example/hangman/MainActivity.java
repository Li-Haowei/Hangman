package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String[][] GRE = new String[676][];
    private String currentWord;
    private String hint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readFile() throws IOException {
        File file = new File("\\value\\words.txt");
        String st;
        int i = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((st = br.readLine()) != null){
            String[] wordAndHint = extractWord(st);
            GRE[i] = wordAndHint;
            i++;
        }
    }
    private String[] extractWord(String line){
        String[] wordAndHint = line.split(" - ",2);
        return wordAndHint;
    }

}