package actions;

import input.Child;
import input.Input;

public class BudgetCalculator {

    public static double round0(Child child, Input input) {
        double sumOfNiceScores = 0;
        for (Child child1 : input.getInitialData().getChildren()) {
            sumOfNiceScores += child1.getNiceScore();
        }

        double budgetUnit = input.getSantaBudget() / sumOfNiceScores;
        return budgetUnit * child.getNiceScore();
    }


}
