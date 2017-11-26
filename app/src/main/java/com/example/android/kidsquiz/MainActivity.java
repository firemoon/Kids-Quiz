package com.example.android.kidsquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int checkRightAnswers() {

        int rightAnswersCounter = 0;

        //Check 1st answer
        RadioButton radioButtonQ1 = (RadioButton) findViewById(R.id.q1a);
        if (radioButtonQ1.isChecked()) rightAnswersCounter += 1;

        //Check 2nd answer
        EditText editTextQ2A = (EditText) findViewById(R.id.q2a);
        if (editTextQ2A.getText().toString().equals("62")) rightAnswersCounter += 1;

        //Check 3rd answer
        CheckBox checkBoxQ3A = (CheckBox) findViewById(R.id.q3_a);
        CheckBox checkBoxQ3B = (CheckBox) findViewById(R.id.q3_b);
        CheckBox checkBoxQ3C = (CheckBox) findViewById(R.id.q3_c);
        CheckBox checkBoxQ3D = (CheckBox) findViewById(R.id.q3_d);
        CheckBox checkBoxQ3E = (CheckBox) findViewById(R.id.q3_e);
        CheckBox checkBoxQ3F = (CheckBox) findViewById(R.id.q3_f);

        //To accept right answer if only a,b,d and e are checked
        if (checkBoxQ3A.isChecked())
            if (checkBoxQ3B.isChecked())
                if (checkBoxQ3D.isChecked())
                    if (checkBoxQ3E.isChecked())
                        if (checkBoxQ3C.isChecked() == false)
                            if (checkBoxQ3F.isChecked() == false)
                                rightAnswersCounter += 1;


        //Check 4th answer
        EditText editTextQ4A = (EditText) findViewById(R.id.q4a);
        // if the compareToIgnoreCase method returns zero, it means str1 equals str2.
        if (editTextQ4A.getText().toString().compareToIgnoreCase("RABBIT") == 0)
            rightAnswersCounter += 1;

        //Check 5th Answer
        RadioButton radioButtonQ5A = (RadioButton) findViewById(R.id.q5a);
        if (radioButtonQ5A.isChecked()) rightAnswersCounter += 1;

        return rightAnswersCounter;

    }

    public void calculateScore() {

        int rightAnswersCounter = checkRightAnswers();
        int score = rightAnswersCounter * 20;
        Log.v("calculateScore", "" + score); // This is optional to record in Logcat
        TextView scoreTextView = (TextView) findViewById(R.id.score);
        scoreTextView.setText(getString(R.string.correctAnswer) + " " + rightAnswersCounter + " & " + getString(R.string.score) + " " + score + "%" );
    }


    public void submitOnclick(View V) {
        calculateScore();
    }

}
