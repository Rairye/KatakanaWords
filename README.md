Sample Android quiz app for practicing waseigo ("Japanese English" such as "ワイシャツ") and non-Japanese (such as "アルバイト") katakana words.

Java source files can be found here: https://github.com/Rairye/KatakanaWords/tree/master/src/main/java/com/example/eli/quizapplication

Essentially, the program consists of a MainActvitiy, a Question class, and a QuestionManager class. 
The question class contains only two fields, question and correctAnswer, and two getter methods, getQuestion and getCorrectAnswer. 
The QuestionManagerClass stores an ArrayList of Question objects. Its main functions are to return instances of Question to the MainActivity, check if user's answer is correct, give feedback about the user's answer, count the number of correct answers, and then return the final results at the end of the quiz.

The current version is simple but functional. Future versions would include a larger number of questions and some UI animation. 
