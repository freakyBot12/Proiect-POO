package actions;

import input.Child;
import input.Gift;
import input.Input;
import output.ChildOutput;
import output.ChildOutputList;
import output.Output;

import java.util.ArrayList;
import java.util.List;

public class Round0 {

    public static void execute(Input input, Output output) {
        ChildOutputList childOutputList = new ChildOutputList();
        input.getInitialData().getChildren().removeIf(child -> child.getAge() > 18);
        for (Child child : input.getInitialData().getChildren()) {

            double allocatedBudget = BudgetCalculator.round0(child, input);

            List<Gift> receivedGifts = new ArrayList<>();

            ChosenGift.searchChosenGift(child, input, receivedGifts, allocatedBudget);

            ChildOutput childOutput = new ChildOutput(child, allocatedBudget, receivedGifts);
            if (child.getAge() < 5)
                childOutput.setAverageScore(10);
            childOutputList.getChildren().add(childOutput);
        }

        output.getAnnualChildren().add(childOutputList);
    }
}
