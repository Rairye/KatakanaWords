package com.example.eli.quizapplication;


public class Question {
    private String question;
    private String correctAnswer;
    public Question(String question, String correctAnswer){
        this.question = question;
        this.correctAnswer = correctAnswer;
    }
    public String getQuestion(){
        return this.question;
    }
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }
}
