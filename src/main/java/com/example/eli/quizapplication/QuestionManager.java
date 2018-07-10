package com.example.eli.quizapplication;
import android.util.Log;

import java.util.Random;
import java.util.ArrayList;

public class QuestionManager {
    private ArrayList<Question> questionList = new ArrayList<>();
    private Random randers;
    private double correctAnswers;
    private int initialSize;
    public QuestionManager(){
        randers = new Random();
        questionList = new ArrayList<>();
        questionList.add(new Question("マンツーマン", "one-on-one"));
        questionList.add(new Question("ピーマン", "bell pepper"));
        questionList.add(new Question("クレーム", "complaint"));
        questionList.add(new Question("サラリーマン", "office worker"));
        questionList.add(new Question("アンケート", "questionnaire"));
        questionList.add(new Question("コント", "skit"));
        questionList.add(new Question("アルバイト", "part-time job"));
        questionList.add(new Question("カルテ", "medical record"));
        questionList.add(new Question("ワイシャツ", "dress shirt"));
        questionList.add(new Question("コンセント", "outlet"));
        questionList.add(new Question("マント", "cloak"));
        questionList.add(new Question("レントゲン", "x-ray"));
        this.initialSize = this.questionList.size();
    }
    public Question getNewQuestion(){
        int randomIndex = questionList.size() == 1 ? 0 : randers.nextInt(questionList.size());
        Question question = questionList.get(randomIndex);
        questionList.remove(randomIndex);
        return question;
    }
    public String checkCorrect (Question thisQuestion, String submittedAnswer){
        String result = thisQuestion.getCorrectAnswer();
        if (submittedAnswer.equalsIgnoreCase(result)) {
            correctAnswers++;
            return "Correct!";
        }
        else{
            return "Incorrect! Correct answer: " + thisQuestion.getCorrectAnswer();
        }
    }
    public String getFinalScore(){
        return "FINAL SCORE: " + (int) ((correctAnswers / (double) initialSize) * 100)+ "%";
    }
    public int getInitialSize(){
        return initialSize;
    }

}
