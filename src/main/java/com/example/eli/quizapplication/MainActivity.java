package com.example.eli.quizapplication;


import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    QuestionManager questionManager;
    int currentQuestionNumber, totalQuestions;
    Question currentQuestion;
    TextView questionText, progressText, resultText;
    EditText answerText;
    Button submitButton, resetButton;
    Runnable fader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (ConstraintLayout) findViewById(R.id.Layout);
        questionText = (TextView) findViewById(R.id.QuestionText);
        progressText = (TextView) findViewById(R.id.ProgressText);
        resultText = (TextView) findViewById(R.id.ResultText);
        answerText = (EditText) findViewById(R.id.AnswerText);
        submitButton = (Button) findViewById(R.id.SubmitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!answerText.getText().toString().equals("")) {
                    submitAnswer();
                } else {
                    answerText.requestFocus();
                }
            }
        });
        resetButton = (Button) findViewById(R.id.ResetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                loadQuestionManager();
            }
        });
        if (questionManager == null | currentQuestion == null) {
            loadQuestionManager();
        }
        fader = new Runnable()
        {
            public void run()
            {
                try {
                    Thread.sleep(1500);
                    resultText.setAlpha(.85f);
                    Thread.sleep(1000);
                    resultText.setAlpha(.75f);
                    Thread.sleep(1000);
                    resultText.setAlpha(.5f);
                    Thread.sleep(750);
                    resultText.setAlpha(.35f);
                    Thread.sleep(750);
                    resultText.setAlpha(.20f);
                    Thread.sleep(500);
                    resultText.setAlpha(.05f);
                    Thread.sleep(500);
                    resultText.setAlpha(0f);
                    resultText.setText("");
                }
                catch(InterruptedException e){
                    resultText.setAlpha(1f);
                }
            }
        };
    }

    public void loadQuestionManager(){
        questionManager = new QuestionManager();
        totalQuestions = questionManager.getInitialSize();
        resultText.setText("");
        currentQuestionNumber = 1;
        submitButton.setClickable(true);
        getNewQuestion();
    }

    public void getNewQuestion(){
        answerText.requestFocus();
        currentQuestion = questionManager.getNewQuestion();
        questionText.setText(currentQuestion.getQuestion());
        progressText.setText("Question " + currentQuestionNumber + "/" + totalQuestions);

    }

    public void submitAnswer(){
        if (currentQuestionNumber > 1){
            Thread[] threads= new Thread[Thread.activeCount()];
            Thread.enumerate(threads);
            for (Thread thread : threads){
                if (thread.getName().equals("Fader")){
                    thread.interrupt();
                }
            }
        }
        resultText.setAlpha(1f);
        Thread t = new Thread(fader);
        t.setName("Fader");
        resultText.setText(questionManager.checkCorrect(currentQuestion, answerText.getText().toString()));
        if (currentQuestionNumber == (totalQuestions)){
            answerText.setText("");
            questionText.setText("");
            progressText.setText("");
            resultText.setText(questionManager.getFinalScore());
            submitButton.setClickable(false);
        } else {
            answerText.setText("");
            currentQuestionNumber++;
            t.start();
            getNewQuestion();
        }
    }
}
