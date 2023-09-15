package com.mini.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView res1,res2,res3;
    Button restart;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        res1=findViewById(R.id.res1);
        res2=findViewById(R.id.res2);
        res3=findViewById(R.id.res3);
        restart=findViewById(R.id.restart);

        StringBuilder sb=new StringBuilder();
        sb.append("Correct answers"+MainActivity.correct+"\n");

        StringBuilder sb2=new StringBuilder();
        sb2.append("Wrong answers"+MainActivity.wrong+"\n");

        StringBuilder sb3=new StringBuilder();
        sb3.append("Final Score"+MainActivity.correct+"\n");

        res1.setText(sb);
        res2.setText(sb2);
        res3.setText(sb3);

        MainActivity.correct=0;
        MainActivity.wrong=0;
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



    }
}