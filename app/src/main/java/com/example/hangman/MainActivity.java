package com.example.hangman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;



public class MainActivity extends AppCompatActivity {
    private int libraryLen = 28216;
    private final String[][] dic = new String[libraryLen][2];
    private String library = "dictionary.txt";
    private int stage = -1;
    private String currentWord;
    private String hint;
    private ImageButton btna, btnb, btnc, btnd, btne, btnf, btng, btnh, btni, btnj, btnk, btnl,
            btnn, btnm, btno, btnp, btnq, btnr, btns, btnt, btnu, btnv, btnw, btnx, btny, btnz;
    private Animation wave;
    private TextView tv;
    private String display;
    private ImageView img;
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

        btna = findViewById(R.id.btna);
        btnb = findViewById(R.id.btnb);
        btnc = findViewById(R.id.btnc);
        btnd = findViewById(R.id.btnd);
        btne = findViewById(R.id.btne);
        btnf = findViewById(R.id.btnf);
        btng = findViewById(R.id.btng);
        btnh = findViewById(R.id.btnh);
        btni = findViewById(R.id.btni);
        btnj = findViewById(R.id.btnj);
        btnk = findViewById(R.id.btnk);
        btnl = findViewById(R.id.btnl);
        btnn = findViewById(R.id.btnn);
        btnm = findViewById(R.id.btnm);
        btno = findViewById(R.id.btno);
        btnp = findViewById(R.id.btnp);
        btnq = findViewById(R.id.btnq);
        btnr = findViewById(R.id.btnr);
        btns = findViewById(R.id.btns);
        btnt = findViewById(R.id.btnt);
        btnu = findViewById(R.id.btnu);
        btnv = findViewById(R.id.btnv);
        btnw = findViewById(R.id.btnw);
        btnx = findViewById(R.id.btnx);
        btny = findViewById(R.id.btny);
        btnz = findViewById(R.id.btnz);
        wave = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.wave);
        tv = findViewById(R.id.textView);
        tv.setText(display);
        img = findViewById(R.id.imageView3);
        SharedPreferences sp = getSharedPreferences("review", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        newWord();


        btna.setOnClickListener(view -> {
            update('a');
            btna.startAnimation(wave);
        });
        btnb.setOnClickListener(view -> {
            update('b');
            btnb.startAnimation(wave);
        });
        btnc.setOnClickListener(view -> {
            update('c');
            btnc.startAnimation(wave);
        });
        btnd.setOnClickListener(view -> {
            update('d');
            btnd.startAnimation(wave);
        });
        btne.setOnClickListener(view -> {
            update('e');
            btne.startAnimation(wave);
        });
        btnf.setOnClickListener(view -> {
            update('f');
            btnf.startAnimation(wave);
        });
        btng.setOnClickListener(view -> {
            update('g');
            btng.startAnimation(wave);
        });
        btnh.setOnClickListener(view -> {
            update('h');
            btnh.startAnimation(wave);
        });
        btni.setOnClickListener(view -> {
            update('i');
            btni.startAnimation(wave);
        });
        btnj.setOnClickListener(view -> {
            update('j');
            btnj.startAnimation(wave);
        });
        btnk.setOnClickListener(view -> {
            update('k');
            btnk.startAnimation(wave);
        });
        btnl.setOnClickListener(view -> {
            update('l');
            btnl.startAnimation(wave);
        });
        btnn.setOnClickListener(view -> {
            update('n');
            btnn.startAnimation(wave);
        });
        btnm.setOnClickListener(view -> {
            update('m');
            btnm.startAnimation(wave);
        });
        btno.setOnClickListener(view -> {
            update('o');
            btno.startAnimation(wave);
        });
        btnp.setOnClickListener(view -> {
            update('p');
            btnp.startAnimation(wave);
        });
        btnq.setOnClickListener(view -> {
            update('q');
            btnq.startAnimation(wave);
        });
        btnr.setOnClickListener(view -> {
            update('r');
            btnr.startAnimation(wave);
        });
        btns.setOnClickListener(view -> {
            update('s');
            btns.startAnimation(wave);
        });
        btnt.setOnClickListener(view -> {
            update('t');
            btnt.startAnimation(wave);
        });
        btnu.setOnClickListener(view -> {
            update('u');
            btnu.startAnimation(wave);
        });
        btnv.setOnClickListener(view -> {
            update('v');
            btnv.startAnimation(wave);
        });
        btnw.setOnClickListener(view -> {
            update('w');
            btnw.startAnimation(wave);
        });
        btnx.setOnClickListener(view -> {
            update('x');
            btnx.startAnimation(wave);
        });
        btny.setOnClickListener(view -> {
            update('y');
            btny.startAnimation(wave);
        });
        btnz.setOnClickListener(view -> {
            update('z');
            btnz.startAnimation(wave);
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
        return line.split(" - ",2);
    }


    private boolean checkIfEnd(){
        //Checking if the game ends
        for (int i = 0; i < display.length(); i++) {
            if(display.charAt(i)=='_'){
                return false;
            }
        }

        return true;
    }



    private void update(char letter){
        boolean decision = true;
        if(!tv.getText().toString().equals("Game Over")) {
            for (int i = 0; i < currentWord.length(); i++) {
                if (currentWord.charAt(i) == letter) {
                    decision = false;
                    display = display.substring(0, i) + letter + display.substring(i + 1);

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
                        createDialog();
                        break;
                    default:
                        tv.setText("Game Over");
                        break;
                }
            }
            if (checkIfEnd()) {
                tv.setText("You Luckily Won");
                createDialog();
                tv.setTextSize(35);
            }
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private boolean checkValidWord(String word){
        if(word.contains("-")){
            return false;
        }
        return !word.contains(" ");
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
            display = display.substring(0,letterHint1)+hint1+display.substring(letterHint1+1);
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
        stage=-1;
        tv.setText(display);
        img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.stand));

        SharedPreferences sp = getSharedPreferences("review", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(numberOfWordsPlayed+"",currentWord + " - " +hint);
        editor.apply();
        numberOfWordsPlayed++;
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


    public void createDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Here is the word");
        final View popup = getLayoutInflater().inflate(R.layout.popup, null);
        dialogBuilder.setView(popup);
        dialogBuilder.setMessage("Word: " + currentWord + "\n"+ "\n" + "Definition: " + hint);
        dialogBuilder.setNegativeButton("Add to review", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogBuilder.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}