import questions.LinearScale;
import questions.Paragraph;
import questions.Question;
import questions.ShortAnswer;

public class SurveyRunner {

    private static final Survey survey = new Survey();

    public static void main(String[] args) {

        ShortAnswer faveIceCream = new ShortAnswer("What is your favorite flavor of ice cream?");
        Paragraph toppingsExpo = new Paragraph("Please expound upon your favorite ice cream toppings and combinations!");
        LinearScale vanillaRank = new LinearScale("How much do you like waffle cones?", 5);

        survey.addQuestions(new Question[] { faveIceCream, vanillaRank, toppingsExpo });

        survey.run();

        System.out.println(System.lineSeparator() + "Thank you for taking our survey! We have recorded your responses.");
    }
}