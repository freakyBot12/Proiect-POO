package actions;

import input.Child;
import input.Input;
import output.ChildOutputList;
import output.Output;

import javax.swing.*;

public class NextRound {
    public static void increaseAge(Input input) {
        for (Child child : input.getInitialData().getChildren()) {
            int age = child.getAge();
            age++;
            child.setAge(age);
        }
    }

    public static void checkForYoungAdults(Input input) {
        for (Child child : input.getInitialData().getChildren()) {
            if (child.getAge() > 18)
                input.getInitialData().getChildren().remove(child);
        }
    }

    public static void execute(Input input, Output output) {
        increaseAge(input);
        checkForYoungAdults(input);

    }
}
