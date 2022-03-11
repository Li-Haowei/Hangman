package com.example.hangman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;



public class MainActivity extends AppCompatActivity {
    private int libraryLen = 28216;
    private String[][] dic = new String[libraryLen][2];
    private String library = "dictionary.txt";
    private int stage = -1;
    private String currentWord;
    private String hint;
    private int currentIndex;
    private ImageButton btna, btnb, btnc, btnd, btne, btnf, btng, btnh, btni, btnj, btnk, btnl,
            btnn, btnm, btno, btnp, btnq, btnr, btns, btnt, btnu, btnv, btnw, btnx, btny, btnz;
    ;
    private Animation wave;
    private TextView tv;
    private String display;
    private ImageView img;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private int numberOfWordsPlayed;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.hint:
                for (int i=0; i < 3; i++)
                {Toast.makeText(this,this.hint,Toast.LENGTH_SHORT).show();}
                return true;
            case R.id.newword:
                this.newWord();
                return true;
            case R.id.restart:
                recreate();
                return true;
            case R.id.review:
                Intent intent = new Intent(MainActivity.this,ReviewPage.class);
                intent.putExtra("numberOfWordsPlayed", numberOfWordsPlayed);
                startActivity(intent);
                return true;
            case R.id.gre:
                library = "words.txt";
                libraryLen = 676;
                try {
                    readFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(this,"Vocabulary changed to GRE",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.math:
                library = "math.txt";
                libraryLen = 65;
                try {
                    readFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(this,"Vocabulary changed to Math",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.engdict:
                library = "dictionary.txt";
                libraryLen = 28216;
                try {
                    readFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(this,"Vocabulary changed to English Dictionary",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int ranInt = getRandomNumber(0,libraryLen); // this random integer will be used to pick a word from library
        currentWord = dic[ranInt][0];
        hint = dic[ranInt][1];
        while(!checkValidWord(currentWord)){
            //Since the library is achieved through web scraping, there may be a small chance it is a phrase
            ranInt = getRandomNumber(0,libraryLen);
            currentWord = dic[ranInt][0];
            hint = dic[ranInt][1];
        }
        display = new String(new char[currentWord.length()]).replace('\0','_');
        //Log messages for internal debugs
        Log.d("Creation",currentWord);
        Log.d("Creation",display);
        Log.d("Creation",hint);
        if(currentWord.length()>6 && currentWord.length()<9){
            //if the length is between 6 and 9 give one letter hint
            int letterHint1 = getRandomNumber(currentWord.length()/2+1,currentWord.length()-1);
            char hint1 = currentWord.charAt(letterHint1);
            String ns = display.substring(0,letterHint1)+hint1+display.substring(letterHint1+1);
            display = ns;
        }else if(currentWord.length()>=9){
            //if the length is greater or equal to 9 give two letter hint
            int letterHint1 = getRandomNumber(currentWord.length()/2+1,currentWord.length()-1);
            int letterHint2 = getRandomNumber(0,currentWord.length()/2);
            char hint1 = currentWord.charAt(letterHint1);
            char hint2 = currentWord.charAt(letterHint2);
            String ns = display.substring(0,letterHint1)+hint1+display.substring(letterHint1+1);
            display = ns;
            ns = display.substring(0,letterHint2)+hint2+display.substring(letterHint2+1);
            display = ns;
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
        wave = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.wave);
        tv = (TextView) findViewById(R.id.textView);
        tv.setText(display);
        img = (ImageView) findViewById(R.id.imageView3);
        sp = getSharedPreferences("review", Context.MODE_PRIVATE);
        editor = sp.edit();

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('a');
                btna.startAnimation(wave);
            }
        });
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update('b');
                btnb.startAnimation(wave);
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
            InputStream is = getAssets().open(library);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            st = new String(buffer);
            String[] arr = st.split("\n");
            for (int i = 0; i <arr.length-1; i++) {
                String[] wordAndHint = extractWord(arr[i]);
                dic[i] = wordAndHint;
            }
        }
        catch (IOException e) {
            Log.d("Creation","shit went wrong");
        }
    }
    private String[] extractWord(String line){
        String[] wordAndHint = line.split(" - ",2);
        return wordAndHint;
    }


    private boolean checkIfEnd(){
        //Checking if the game ends
        for (int i = 0; i < display.length(); i++) {
            if(display.charAt(i)=='_'){
                return false;
            }
        }
        editor.putString(numberOfWordsPlayed+"",currentWord + " - " +hint);
        editor.commit();
        return true;
    }

    private void checkIfRight(){
        //Check the user input is correct match, if not it takes one turn for drawing hangman
        if(display.charAt(currentIndex)!=currentWord.charAt(currentIndex)){
            String ns = display.substring(0,currentIndex)+currentWord.charAt(currentIndex)+display.substring(currentIndex+1);
            display = ns;
            SpannableString spannableString = new SpannableString(display);
            ForegroundColorSpan color = new ForegroundColorSpan(Color.BLACK);
            spannableString.setSpan(color,
                    currentIndex, currentIndex+1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv.setText(spannableString);
            stage++;
            switch (stage){
                case -1:
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.stand));
                    break;
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
        }
    }
    private void update(char letter){
        Boolean decision = true;
        if(!tv.getText().toString().equals("Game Over")) {
            for (int i = 0; i < currentWord.length(); i++) {
                if (currentWord.charAt(i) == letter) {
                    decision = false;
                    String ns = display.substring(0, i) + letter + display.substring(i + 1);
                    display = ns;

                }
            }
            tv.setText(display);
            if(decision){
                stage++;
                switch (stage){
                    case -1:
                        img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.stand));
                        break;
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
            }
            if (checkIfEnd()) {
                tv.setText("You Luckily Won");
                tv.setTextSize(35);
            }
        }
        //Below is old game mode
        /*if(!tv.getText().toString().equals("Game Over")) {
            for (int i = 0; i < display.length(); i++) {
                if (display.charAt(i) == '_') {
                    String ns = display.substring(0, i) + letter + display.substring(i + 1);
                    display = ns;
                    tv.setText(display);
                    currentIndex = i;
                    checkIfRight();
                    break;
                }
            }
            if (checkIfEnd()) {
                tv.setText("You Luckily Won");
                tv.setTextSize(35);
            }
        }*/
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private boolean checkValidWord(String word){
        if(word.contains("-")){
            return false;
        }
        if(word.contains(" ")){
            return false;
        }
        return true;
    }
    private void newWord(){
        int ranInt = getRandomNumber(0,libraryLen);
        currentWord = dic[ranInt][0];
        hint = dic[ranInt][1];
        while(!checkValidWord(currentWord)){
            ranInt = getRandomNumber(0,libraryLen);
            currentWord = dic[ranInt][0];
            hint = dic[ranInt][1];
        }
        display = new String(new char[currentWord.length()]).replace('\0','_');
        if(currentWord.length()>6 && currentWord.length()<9){
            int letterHint1 = getRandomNumber(currentWord.length()/2+1,currentWord.length()-1);
            char hint1 = currentWord.charAt(letterHint1);
            String ns = display.substring(0,letterHint1)+hint1+display.substring(letterHint1+1);
            display = ns;
        }else if(currentWord.length()>=9){
            int letterHint1 = getRandomNumber(currentWord.length()/2+1,currentWord.length()-1);
            int letterHint2 = getRandomNumber(0,currentWord.length()/2);
            char hint1 = currentWord.charAt(letterHint1);
            char hint2 = currentWord.charAt(letterHint2);
            String ns = display.substring(0,letterHint1)+hint1+display.substring(letterHint1+1);
            display = ns;
            ns = display.substring(0,letterHint2)+hint2+display.substring(letterHint2+1);
            display = ns;
        }
        int letterHint1 = getRandomNumber(currentWord.length()/2+1,currentWord.length()-1);
        int letterHint2 = getRandomNumber(0,currentWord.length()/2);
        currentIndex = 0;
        stage=-1;
        tv.setText(display);
        img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.stand));
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putString("currentWord", currentWord);
        savedInstanceState.putString("display", display);
        savedInstanceState.putInt("stage", stage);
        super.onSaveInstanceState(savedInstanceState);
    }

//onRestoreInstanceState

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        this.currentWord = savedInstanceState.getString("currentWord");
        this.display = savedInstanceState.getString("display");
        tv.setText(this.display);
        this.stage = savedInstanceState.getInt("stage");
        switch (stage){
            case -1:
                img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.stand));
                break;
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
    }
}