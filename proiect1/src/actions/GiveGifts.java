package actions;

import input.Child;
import input.Input;
import output.Output;

public class GiveGifts {

    public void execute(Input input, Output output) {
        Round0.execute(input, output);
        for (int i = 1; i <= input.getNumberOfYears(); i++) {
            NextRound.execute(input, output);
        }
    }
}
