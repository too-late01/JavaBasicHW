package ru.otus.java.hw5Errors;

import java.io.IOException;
import java.util.Scanner;

public class HW5Errors {
    static int correctCount = 0;
    static int wrongCount = 0;
    static boolean count = false;

    public static void main(String[] args) {
        Question[] questions = new Question[2];
        questions[0] = new Question(1,
                "Вопрос",
                new QuestionOption[]{

                        new QuestionOption(1, "cs", false),
                        new QuestionOption(2, "java", true),
                        new QuestionOption(3, "class", false),
                        new QuestionOption(4, "exe", false)
                });
        questions[1] = new Question(2,
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                new QuestionOption[]{

                        new QuestionOption(1, "commit", false),
                        new QuestionOption(2, "push", false),
                        new QuestionOption(3, "clone", true),
                        new QuestionOption(4, "copy", false),
                });

        for (int i = 0; i < questions.length; i++) {
            questions[i].print();
            count = questions[i].showCorrectAnswer();
            if (count == true) correctCount = correctCount + 1;
            else wrongCount = wrongCount + 1;
        }
        System.out.println("Правильных ответов=" + " " + correctCount + " " +
                "Неправильных ответов=" + " " + wrongCount);

    }
}


