import questions.*;

public class SurveyRunner {

    // Create survey
    private static final Survey survey = new Survey();

    public static void main(String[] args) {

        // Create questions

        Choice[] trueAndFalse = {
                new Choice("True"),
                new Choice("False")
        };
        TrueOrFalse lactoseIntolerant = new TrueOrFalse("I am lactose-intolerant and need a non-dairy alternative.", trueAndFalse);
        TrueOrFalse diabetic = new TrueOrFalse("I am diabetic and need a no-sugar-added alternative.", trueAndFalse);

        Choice[] flavorChoices = {
                new Choice("Vanilla"),
                new Choice("Chocolate"),
                new Choice("Strawberry")
        };
        MultipleChoice flavor = new MultipleChoice("What flavor of ice cream would you like?", flavorChoices);

        LinearScale numScoops = new LinearScale("How many scoops of ice cream would you like?", 3);

        Choice[] toppingChoices = {
                new Choice("Oreo crumbles"),
                new Choice("Fresh strawberry slices"),
                new Choice("M&Ms"),
                new Choice("Hot caramel syrup"),
                new Choice("Pecans")
        };
        Checkbox toppings = new Checkbox("Select some toppings:", toppingChoices);

        ShortAnswer flavorSuggestion = new ShortAnswer("What flavor of ice cream would you like to see added to our menu?");

        Paragraph comments = new Paragraph("Any other questions or comments?");


        // Add questions to survey

        survey.addQuestions(new Question[] { lactoseIntolerant, diabetic, flavor, numScoops, toppings, flavorSuggestion, comments });


        // Interact with user (intro, run survey, outro)

        String newline = System.lineSeparator();
        System.out.println("Thank you for registering for our meetup! We will be serving dessert and would like to know your preferences ahead of time." + newline);

        survey.run();

        System.out.println(newline + "Thank you! Your preferences have been noted for the upcoming event:" +
                newline + "\t- " + String.join(newline + "\t- ", survey.getAllResponses()) + newline);

    }
}