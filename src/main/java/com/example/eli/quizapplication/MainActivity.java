package com.example.eli.quizapplication;

import android.support.constraint.ConstraintLayout;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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
                submitAnswer();
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
        currentQuestion = questionManager.getNewQuestion();
        questionText.setText(currentQuestion.getQuestion());
        progressText.setText("Question " + currentQuestionNumber + "/" + totalQuestions);

    }
    public void submitAnswer(){
        resultText.setText(questionManager.checkCorrect(currentQuestion, answerText.getText().toString()));
        if (currentQuestionNumber == (totalQuestions)){
            answerText.setText("");
            questionText.setText("");
            progressText.setText("");
            resultText.setText(questionManager.getFinalScore());
            submitButton.setClickable(false);
        }
        else{
            answerText.setText("");
            currentQuestionNumber++;
            getNewQuestion();

        }
    }

}