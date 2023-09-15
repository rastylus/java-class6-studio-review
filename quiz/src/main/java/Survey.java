import questions.*;

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
            int i=0;
            System.out.println(question);
            do {
                String userResponse = input.nextLine();
                if (userResponse.equalsIgnoreCase("done")) {
                    break;
                } else {
                    while (question.isInvalid(userResponse)) {
                        System.out.println(System.lineSeparator() + "That response is invalid. Please try again: ");
                        userResponse = input.nextLine();
                    }
                    System.out.println("Got it!");

                    if (question instanceof ShortAnswer || question instanceof Paragraph || question instanceof LinearScale) {
                        userResponses.add(userResponse);
                    } else {
                        int userRespNum = Integer.parseInt(userResponse);
                        userResponses.add(question.getChoiceMap().get(userRespNum).getContent());
                    }
                    i++;

                    if (question instanceof Checkbox && i < question.getMaxResponses()) {
                        System.out.println("(Select another by number or enter DONE)");
                    }
                }
            } while (i < question.getMaxResponses());
        }
        input.close();
    }
}