package com.mini.quizapp;

import androidx.appcompat.app.AppCompatActivity;

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
    TextView question;
    RadioButton rb1,rb2,rb3,rb4;
    public String ques[]={"Which is a Programming Language?",
            "In COMAL language program, after name of procedure parameters must be in?",
            "Programming language COBOL works best for use in?"};
    public String choices[][]={{"HTML", "CSS", "Vala", "PHP"},
            {"Punction Marks", "Back-Slash", "Brackets", "Semi Colon"},
            {"Siemens Applications", "Student Applications", "Social Applications", "Commercial Applications"}};
    public String correctAnswer[]={ "PHP",
            "Brackets",
            "Commercial Applications"};

    int flag=0;
    public static int marks=0,correct=0,wrong=0;
//    private Questions questions=new Questions();
//    private String answer;
//    private int questionLength = questions.questions.length;
//    Random random;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=findViewById(R.id.submit);
        radioGroup=findViewById(R.id.groupradio);
        quit = findViewById(R.id.quit);
        question=findViewById(R.id.question);
        rb1=findViewById(R.id.radio_1);
        rb2=findViewById(R.id.radio_2);
        rb3=findViewById(R.id.radio_3);
        rb4=findViewById(R.id.radio_4);

        question.setText(ques[flag]);
        rb1.setText(choices[flag][0]);
        rb2.setText(choices[flag][1]);
        rb3.setText(choices[flag][2]);
        rb3.setText(choices[flag][3]);

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
//                    Toast.makeText(MainActivity.this,
//                                    radioButton.getText(),
//                                    Toast.LENGTH_SHORT)
//                            .show();

                    if(flag<ques.length){
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

        // Add the Listener to the Submit Button
//        clear.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v)
//            {
//
//                // Clear RadioGroup
//                // i.e. reset all the Radio Buttons
//                radioGroup.clearCheck();
//            }
//        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Result.class);
                startActivity(intent);
            }
        });
    }
}
