package com.mini.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button submit,quit;
    RadioGroup radioGroup;
    TextView question,queno;
    RadioButton rb1,rb2,rb3,rb4;
    public String ques[]={"Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?"};
    public String choices[][]={{ "finalize method","main method","static method","private method"},
            {"&","&=","|=","<="},
            {"import","this","catch","abstract"},
            {"Interface","interface","intf","Intf"},
            {"public","protected","private","All of the mentioned"},
            {"Import pkg.","import pkg.*","Import pkg.*","import pkg."},
            {"int","float","void","None of the mentioned"},
            {"lang","java","util","java.packages"},
            {"equals()","Equals()","isequal()","Isequal()"},
            {"int","long","byte","float"}};
    public String correctAnswer[]={ "main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};

    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queno=findViewById(R.id.queNO);
        submit=findViewById(R.id.submit);
        radioGroup=findViewById(R.id.groupradio);
        quit = findViewById(R.id.quit);
        question=findViewById(R.id.question);
        rb1=findViewById(R.id.radio_1);
        rb2=findViewById(R.id.radio_2);
        rb3=findViewById(R.id.radio_3);
        rb4=findViewById(R.id.radio_4);

        queno.setText(Integer.toString(flag+1));
        question.setText(ques[flag]);
        rb1.setText(choices[flag][0]);
        rb2.setText(choices[flag][1]);
        rb3.setText(choices[flag][2]);
        rb4.setText(choices[flag][3]);

        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);
                    }
                });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                // When submit button is clicked,
                // Get the Radio Button which is set
                // If no Radio Button is set, -1 will be returned
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this,
                                    "No answer has been selected",
                                    Toast.LENGTH_SHORT)
                            .show();
                }
                else {

                    RadioButton radioButton
                            = (RadioButton)radioGroup
                            .findViewById(selectedId);
                    String ansText=radioButton.getText().toString();
                    Toast.makeText(getApplicationContext(),ansText,Toast.LENGTH_SHORT).show();

                    if(ansText.equals(correctAnswer[flag])){
                        correct++;
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        wrong++;
                        Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                    flag++;
                    // Now display the value of selected item
                    // by the Toast message

                    if(flag<ques.length){
                        queno.setText(Integer.toString(flag+1));
                        question.setText(ques[flag]);
                        rb1.setText(choices[flag][0]);
                        rb2.setText(choices[flag][1]);
                        rb3.setText(choices[flag][2]);
                        rb3.setText(choices[flag][3]);
                    }
                    else{
                        marks=correct;
                        Intent intent=new Intent(getApplicationContext(),Result.class);
                        startActivity(intent);
                    }
                    radioGroup.clearCheck();
                }
            }
        });


        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Result.class);
                startActivity(intent);
            }
        });
    }
}
