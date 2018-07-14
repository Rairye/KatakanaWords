package com.example.eli.quizapplication;


class Question {
    private String question;
    private String correctAnswer;

    Question(String question, String correctAnswer){
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    String getQuestion(){
        return this.question;
    }

    String getCorrectAnswer(){
        return this.correctAnswer;
    }
}
