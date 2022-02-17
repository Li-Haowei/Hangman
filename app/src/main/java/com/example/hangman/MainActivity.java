package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String[][] GRE = new String[676][];
    private String currentWord;
    private String hint;
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
    private LinearLayout inputBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        inputBox = (LinearLayout) findViewById(R.id.inputBox);
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void readFile() throws IOException {
        File file = new File("\\words.txt");
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