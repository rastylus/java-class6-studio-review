package questions;

public class Checkbox extends Question {

    public Checkbox(String question, Choice[] choiceArray) {
        super(question, choiceArray);
        setMaxResponses(getNumCorrect());
    }

    @Override
    public String toString() {
        String newline = System.lineSeparator();
        return newline + "CHOOSE ONE OR MORE:" + newline +
                getQuestion() + newline +
                getFormattedChoices();
    }

    public int getNumCorrect() {
        int numCorrect = 0;
        for (Choice choice : getChoiceMap().values()) {
            if (choice.isCorrect()) {
                numCorrect++;
            }
        }
        return numCorrect > 0 ? numCorrect : getChoiceMap().size();
    }

}
