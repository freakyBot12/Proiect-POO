package actions;

import input.Child;
import input.ChildUpdate;
import input.Gift;
import input.Input;
import output.ChildOutput;
import output.ChildOutputList;
import output.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NextRounds {
    public static void increaseAge(Input input) {
        for (Child child : input.getInitialData().getChildren()) {
            int age = child.getAge();
            age++;
            child.setAge(age);
        }
    }

    public static void checkForYoungAdults(Input input) {
        input.getInitialData().getChildren().removeIf(child -> child.getAge() > 18);
    }

    public static void execute(Input input, Output output, Map<Integer, List<Double>> niceScoreHistoryMap) {

        for (int i = 0; i < input.getNumberOfYears(); i++) {
            increaseAge(input);
            checkForYoungAdults(input);

            input.setSantaBudget(input.getAnnualChanges().get(i).getNewSantaBudget());

            for (ChildUpdate childUpdate : input.getAnnualChanges().get(i).getChildrenUpdates()) {
                for (Child child : input.getInitialData().getChildren()) {
                    if (childUpdate.getId() == child.getId()) {
                        if (childUpdate.getNiceScore() != null) {
                            List<Double> niceScoreHistory = niceScoreHistoryMap.get(child.getId());
                            niceScoreHistory.add(childUpdate.getNiceScore());
                            niceScoreHistoryMap.put(child.getId(), niceScoreHistory);
                        }

                        if (!childUpdate.getGiftsPreferences().isEmpty()) {
                            for (String preference : child.getGiftsPreferences()) {
                                if (!childUpdate.getGiftsPreferences().contains(preference))
                                    childUpdate.getGiftsPreferences().add(preference);
                            }
                            List<String> giftsPreferencesWithNoDuplicates = childUpdate.getGiftsPreferences().stream().distinct()
                                            .collect(Collectors.toList());
                            child.setGiftsPreferences(giftsPreferencesWithNoDuplicates);

                        }
                        break;
                    }
                }
            }

            for (Child child : input.getAnnualChanges().get(i).getNewChildren()) {
                input.getInitialData().getChildren().add(child);
                List<Double> niceScoreHistory = new ArrayList<>();
                niceScoreHistory.add(child.getNiceScore());
                niceScoreHistoryMap.put(child.getId(), niceScoreHistory);
            }
            checkForYoungAdults(input);

            for (Gift gift : input.getAnnualChanges().get(i).getNewGifts()) {
                input.getInitialData().getSantaGiftsList().add(gift);
            }

            ChildOutputList childOutputList = new ChildOutputList();
            for (Child child : input.getInitialData().getChildren()) {
                double allocatedBudget = BudgetCalculator.determineBudgetBasedOnAge(child, niceScoreHistoryMap, input);

                List<Gift> receivedGifts = new ArrayList<>();

                ChosenGift.searchChosenGift(child, input, receivedGifts, allocatedBudget);
                double averageScore = BudgetCalculator.determineAverageScore(child, niceScoreHistoryMap);
                List<Double> niceScoreHistory = niceScoreHistoryMap.get(child.getId());
                ChildOutput childOutput = new ChildOutput(child, averageScore, niceScoreHistory, allocatedBudget, receivedGifts);
                childOutputList.getChildren().add(childOutput);
            }
            output.getAnnualChildren().add(childOutputList);
        }
    }
}
