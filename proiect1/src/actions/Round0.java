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
        for (Child child : input.getInitialData().getChildren()) {
            if (child.getAge() > 18) {
                input.getInitialData().getChildren().remove(child);
                break;
            }

            double allocatedBudget = BudgetCalculator.round0(child, input);

            List<Gift> receivedGifts = new ArrayList<>();

            ChosenGift.searchChosenGift(child, input, receivedGifts, allocatedBudget);

            ChildOutput childOutput = new ChildOutput(child, allocatedBudget, receivedGifts);
            childOutputList.getChildren().add(childOutput);
        }

        output.getAnnualChildren().add(childOutputList);
    }
}
