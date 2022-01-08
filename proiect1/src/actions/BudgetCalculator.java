package actions;

import input.Child;
import input.Input;

import java.util.List;
import java.util.Map;

public class BudgetCalculator {

    public static double round0(Child child, Input input) {
        double sumOfNiceScores = 0;
        for (Child child1 : input.getInitialData().getChildren()) {
            if (child1.getAge() < 5)
                sumOfNiceScores += 10;
            else
                sumOfNiceScores += child1.getNiceScore();
        }

        double budgetUnit = input.getSantaBudget() / sumOfNiceScores;
        if (child.getAge() < 5)
            return budgetUnit * 10;
        else
            return budgetUnit * child.getNiceScore();
    }

    public static double averageNiceScoreForKids(Child child, Map<Integer, List<Double>> niceScoreHistoryMap) {
        List<Double> scoreHistory = niceScoreHistoryMap.get(child.getId());
        double sumOfScores = 0;
        for (Double score : scoreHistory)
            sumOfScores += score;
        return sumOfScores / scoreHistory.size();
    }

    public static double averageNiceScoreForTeens(Child child, Map<Integer, List<Double>> niceScoreHistoryMap) {
        List<Double> scoreHistory = niceScoreHistoryMap.get(child.getId());
        double sumOfScores = 0;
        double sum = 0;
        for (int i = 0; i < scoreHistory.size(); i++) {
            sumOfScores += (scoreHistory.get(i) * (i + 1));
            sum += (i + 1);
        }
        return sumOfScores / sum;
    }


    public static double determineBudgetBasedOnAge(Child child, Map<Integer, List<Double>> niceScoreHistoryMap, Input input) {

        double sumOfAllAverageScores = 0;
        for (Child child1 : input.getInitialData().getChildren()) {
            if (child1.getAge() < 5)
                sumOfAllAverageScores += 10;
            if (child1.getAge() >= 5 && child1.getAge() < 12)
                sumOfAllAverageScores += averageNiceScoreForKids(child1, niceScoreHistoryMap);
            if (child1.getAge() >= 12 && child1.getAge() <= 18)
                sumOfAllAverageScores += averageNiceScoreForTeens(child1, niceScoreHistoryMap);
        }

        double budgetUnit = input.getSantaBudget() / sumOfAllAverageScores;

        if (child.getAge() < 5)
            return budgetUnit * 10;

        if (child.getAge() >= 5 && child.getAge() < 12)
            return budgetUnit * averageNiceScoreForKids(child, niceScoreHistoryMap);

        if (child.getAge() >= 12 && child.getAge() <= 18)
            return budgetUnit * averageNiceScoreForTeens(child, niceScoreHistoryMap);
        else
            return -1;

    }

    public static double determineAverageScore(Child child, Map<Integer, List<Double>> niceScoreHistoryMap) {
        if (child.getAge() < 5)
            return 10;
        if (child.getAge() >= 5 && child.getAge() < 12)
            return averageNiceScoreForKids(child, niceScoreHistoryMap);
        if (child.getAge() >= 12 && child.getAge() <= 18)
            return averageNiceScoreForTeens(child, niceScoreHistoryMap);
        else
            return -1;
    }

}
