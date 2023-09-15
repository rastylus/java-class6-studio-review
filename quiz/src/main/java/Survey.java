import questions.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Survey {

    private final ArrayList<Question> questions = new ArrayList<>();
    private final ArrayList<String> userResponses = new ArrayList<>();

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    ArrayList<String> getUserResponses() {
        return userResponses;
    }

    public void addQuestions(Question[] questionArray) {
        Collections.addAll(questions, questionArray);
    }

    public void run() {
        Scanner input = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question);
            String userResponse = input.nextLine();
            while (question.isInvalid(userResponse)) {
                System.out.println(System.lineSeparator() + "That response is invalid. Please try again: ");
                userResponse = input.nextLine();
            }
            System.out.println("Got it!");
            userResponses.add(userResponse);
        }
        input.close();
    }
}