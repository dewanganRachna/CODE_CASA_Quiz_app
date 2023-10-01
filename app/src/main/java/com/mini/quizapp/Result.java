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


        res3=findViewById(R.id.res3);
        restart=findViewById(R.id.restart);

        StringBuilder sb3=new StringBuilder();
        sb3.append("Your Score is "+MainActivity.correct+" out of 10"+"\n");

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