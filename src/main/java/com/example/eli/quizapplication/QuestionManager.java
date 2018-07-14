package com.example.eli.quizapplication;
import android.util.Log;

import java.util.Random;
import java.util.ArrayList;

class QuestionManager {
    private ArrayList<Question> questionList = new ArrayList<>();
    private static Random randers = new Random();
    private double correctAnswers;
    private static int initialSize = 10;

    QuestionManager(){
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
        questionList.add(new Question("カニング", "cheating"));
        questionList.add(new Question("オートバイ", "motorcycle"));
        questionList.add(new Question("ガソリンスタンド", "gas station"));
        questionList.add(new Question("キャッチコピー", "catch phrase"));
        questionList.add(new Question("カリウム", "potassium"));
        questionList.add(new Question("ナトリウム", "sodium"));
        questionList.add(new Question("ジェットコースター", "roller coaster"));
        questionList.add(new Question("ジーパン", "jeans"));
        questionList.add(new Question("テレビゲーム", "video game"));
        questionList.add(new Question("マイブーム", "my obsession"));
        questionList.add(new Question("マグカップ", "mug"));
        questionList.add(new Question("ピエロ", "clown"));
        questionList.add(new Question("さぼる", "skip"));
        questionList.add(new Question("ウラン", "uranium"));
        questionList.add(new Question("テーマ", "theme"));
        questionList.add(new Question("ゼミ", "seminar"));
        questionList.add(new Question("オフィスレディー", "female office worker"));
        questionList.add(new Question("サービス", "free of charge"));
        questionList.add(new Question("フリーサイズ", "one size fits all"));
        questionList.add(new Question("シャ—プペンシル", "mechanical pencil"));
        questionList.add(new Question("キーホルダー", "keychain"));
        questionList.add(new Question("キャッチボール", "catch"));
        questionList.add(new Question("ズボン", "pants"));
        questionList.add(new Question("ピンセット", "tweezers"));
        questionList.add(new Question("アフターサービス", "after-sales service"));
        questionList.add(new Question("ガードマン", "security guard"));
        questionList.add(new Question("ポテトフライ", "French fries"));
        questionList.add(new Question("マイペース", "my own pace"));
        questionList.add(new Question("タレント", "entertainer"));
        questionList.add(new Question("チャック", "zipper"));
        questionList.add(new Question("リフォーム", "renovation"));
        questionList.add(new Question("ベビーカー", "stroller"));
        questionList.add(new Question("ホチキス", "stapler"));
        questionList.add(new Question("サイン", "signature"));
        questionList.add(new Question("バーゲンセール", "sale"));
    }

    Question getNewQuestion(){
        int randomIndex = questionList.size() == 1 ? 0 : randers.nextInt(questionList.size());
        Question question = questionList.get(randomIndex);
        questionList.remove(randomIndex);
        return question;
    }

    String checkCorrect (Question thisQuestion, String submittedAnswer){
        String result = thisQuestion.getCorrectAnswer();
        if (submittedAnswer.equalsIgnoreCase(result)) {
            correctAnswers++;
            return "Correct!";
        } else {
            return "Incorrect! Correct answer: " + thisQuestion.getCorrectAnswer();
        }
    }

    String getFinalScore(){
        return "FINAL SCORE: " + (int) ((correctAnswers / (double) initialSize) * 100)+ "%";
    }

    int getInitialSize(){
        return initialSize;
    }
}
