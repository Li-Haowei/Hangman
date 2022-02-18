package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;



public class MainActivity extends AppCompatActivity {
    private String[][] GRE = new String[676][2];
    private int stage;
    private String currentWord;
    private String hint;
    private int currentIndex;
    private ImageButton btna;
    private ImageButton btnb;
    private ImageButton btnc;
    private ImageButton btnd;
    private ImageButton btne;
    private ImageButton btnf;
    private ImageButton btng;
    private ImageButton btnh;
    private ImageButton btni;
    private ImageButton btnj;
    private ImageButton btnk;
    private ImageButton btnl;
    private ImageButton btnn;
    private ImageButton btnm;
    private ImageButton btno;
    private ImageButton btnp;
    private ImageButton btnq;
    private ImageButton btnr;
    private ImageButton btns;
    private ImageButton btnt;
    private ImageButton btnu;
    private ImageButton btnv;
    private ImageButton btnw;
    private ImageButton btnx;
    private ImageButton btny;
    private ImageButton btnz;
    private TextView tv;
    private String display;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentWord = GRE[getRandomNumber(0,676)][0];
        hint = GRE[getRandomNumber(0,676)][1];
        display = new String(new char[currentWord.length()]).replace('\0','_');
        Log.d("Creation",currentWord);
        Log.d("Creation",display);
        Log.d("Creation",hint);
        int letterHint1 = getRandomNumber(currentWord.length()/2+1,currentWord.length()-1);
        int letterHint2 = getRandomNumber(0,currentWord.length()/2);
        char hint1 = currentWord.charAt(letterHint1);
        char hint2 = currentWord.charAt(letterHint2);

        String ns = display.substring(0,letterHint1)+hint1+display.substring(letterHint1+1);
        display = ns;
        ns = display.substring(0,letterHint2)+hint2+display.substring(letterHint2+1);
        display = ns;
        Log.d("Creation",display);

        btna = (ImageButton) findViewById(R.id.btna);
        btnb = (ImageButton) findViewById(R.id.btnb);
        btnc = (ImageButton) findViewById(R.id.btnc);
        btnd = (ImageButton) findViewById(R.id.btnd);
        btne = (ImageButton) findViewById(R.id.btne);
        btnf = (ImageButton) findViewById(R.id.btnf);
        btng = (ImageButton) findViewById(R.id.btng);
        btnh = (ImageButton) findViewById(R.id.btnh);
        btni = (ImageButton) findViewById(R.id.btni);
        btnj = (ImageButton) findViewById(R.id.btnj);
        btnk = (ImageButton) findViewById(R.id.btnk);
        btnl = (ImageButton) findViewById(R.id.btnl);
        btnn = (ImageButton) findViewById(R.id.btnn);
        btnm = (ImageButton) findViewById(R.id.btnm);
        btno = (ImageButton) findViewById(R.id.btno);
        btnp = (ImageButton) findViewById(R.id.btnp);
        btnq = (ImageButton) findViewById(R.id.btnq);
        btnr = (ImageButton) findViewById(R.id.btnr);
        btns = (ImageButton) findViewById(R.id.btns);
        btnt = (ImageButton) findViewById(R.id.btnt);
        btnu = (ImageButton) findViewById(R.id.btnu);
        btnv = (ImageButton) findViewById(R.id.btnv);
        btnw = (ImageButton) findViewById(R.id.btnw);
        btnx = (ImageButton) findViewById(R.id.btnx);
        btny = (ImageButton) findViewById(R.id.btny);
        btnz = (ImageButton) findViewById(R.id.btnz);
        tv = (TextView) findViewById(R.id.textView);
        tv.setText(display);
        img = (ImageView) findViewById(R.id.imageView3);



        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('a');
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('b');
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('c');
            }
        });
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('d');
            }
        });
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('e');
            }
        });
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('f');
            }
        });
        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('g');
            }
        });
        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('h');
            }
        });
        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('i');
            }
        });
        btnj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('j');
            }
        });
        btnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('k');
            }
        });
        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('l');
            }
        });
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('n');
            }
        });
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('m');
            }
        });
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('o');
            }
        });
        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('p');
            }
        });
        btnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('q');
            }
        });
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('r');
            }
        });
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('s');
            }
        });
        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('t');
            }
        });
        btnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('u');
            }
        });
        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('v');
            }
        });
        btnw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('w');
            }
        });
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('x');
            }
        });
        btny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('y');
            }
        });
        btnz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('z');
            }
        });
    }
    private void readFile() throws IOException {
        String st;
        try {
            InputStream is = getAssets().open("words.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            st = new String(buffer);
            String[] arr = st.split("\n");
            for (int i = 0; i <arr.length-1; i++) {
                String[] wordAndHint = extractWord(arr[i]);
                GRE[i] = wordAndHint;
            }
        }
        catch (IOException e) {
            Log.d("Creation","shit went wrong");
        }
    }
    private boolean checkIfEnd(){
        for (int i = 0; i < display.length(); i++) {
            if(display.charAt(i)=='_'){
                return false;
            }
        }
        return true;
    }

    private void checkIfRight(){
        if(display.charAt(currentIndex)!=currentWord.charAt(currentIndex)){
            String ns = display.substring(0,currentIndex)+currentWord.charAt(currentIndex)+display.substring(currentIndex+1);
            display = ns;
            SpannableString spannableString = new SpannableString(display);
            ForegroundColorSpan color = new ForegroundColorSpan(Color.BLACK);
            spannableString.setSpan(color,
                    currentIndex, currentIndex+1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv.setText(spannableString);
            switch (stage){
                case 0:
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.head));
                    break;
                case 1:
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.body));
                    break;
                case 2:
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.left));
                    break;
                case 3:
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.botharms));
                    break;
                case 4:
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.leftleg));
                    break;
                case 5:
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.endgame));
                    tv.setText("Game Over");
                    break;
                default:
                    tv.setText("Game Over");
                    break;
            }
            stage++;
        }
    }
    private void update(char letter){
        for (int i = 0; i < display.length(); i++) {
            if(display.charAt(i)=='_'){
                String ns = display.substring(0,i)+letter+display.substring(i+1);
                display = ns;
                tv.setText(display);
                currentIndex = i;
                checkIfRight();
                break;
            }
        }
        if(checkIfEnd()){
            tv.setText("You Luckily Won");
            tv.setTextSize(35);
        }
    }
    private String[] extractWord(String line){
        String[] wordAndHint = line.split(" - ",2);
        return wordAndHint;
    }
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}