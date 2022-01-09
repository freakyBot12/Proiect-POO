package actions;

import strategy.AverageNiceScoreStrategy;
import strategy.BabyAverageNiceScoreStrategy;
import strategy.KidsAverageNiceScoreStrategy;
import strategy.TeenAverageNiceScoreStrategy;
import common.Constants;
import input.Child;
import input.Input;

import java.util.List;
import java.util.Map;

public final class BudgetCalculator {

    private BudgetCalculator() {

    }

    /**
     * functie care calculeaza bugetul alocat unui copil in prima runda
     */
    public static double round0(final Child child, final Input input) {
        double sumOfNiceScores = 0;
        for (Child child1 : input.getInitialData().getChildren()) {
            if (child1.getAge() < Constants.BABY_MAX_AGE) {
                sumOfNiceScores += Constants.AVERAGE_SCORE_FOR_BABY;
            } else {
                sumOfNiceScores += child1.getNiceScore();
            }
        }

        double budgetUnit = input.getSantaBudget() / sumOfNiceScores;
        if (child.getAge() < Constants.BABY_MAX_AGE) {
            return budgetUnit * Constants.AVERAGE_SCORE_FOR_BABY;
        } else {
            return budgetUnit * child.getNiceScore();
        }
    }

    /**
     * functie care determina bugetul in functie de varsta copilului
     * (folosita pentru toate rundele in afara de runda 0
     */

    public static double determineBudgetBasedOnAge(final Child child,
                                                   final Map<Integer, List<Double>> niceScoreHistoryMap,
                                                   final Input input) {

        double sumOfAllAverageScores = 0;
        for (Child child1 : input.getInitialData().getChildren()) {
            if (child1.getAge() < Constants.BABY_MAX_AGE) {
                AverageNiceScoreStrategy strategy = new BabyAverageNiceScoreStrategy();
                sumOfAllAverageScores += strategy.execute(child1, niceScoreHistoryMap);
            }
            if (child1.getAge() >= Constants.BABY_MAX_AGE
                    && child1.getAge() < Constants.KID_MAX_AGE) {
                AverageNiceScoreStrategy strategy = new KidsAverageNiceScoreStrategy();
                sumOfAllAverageScores += strategy.execute(child1, niceScoreHistoryMap);
            }
            if (child1.getAge() >= Constants.KID_MAX_AGE
                    && child1.getAge() <= Constants.TEEN_MAX_AGE) {
                AverageNiceScoreStrategy strategy = new TeenAverageNiceScoreStrategy();
                sumOfAllAverageScores += strategy.execute(child1, niceScoreHistoryMap);
            }
        }

        double budgetUnit = input.getSantaBudget() / sumOfAllAverageScores;

        if (child.getAge() < Constants.BABY_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new BabyAverageNiceScoreStrategy();
            return budgetUnit * strategy.execute(child, niceScoreHistoryMap);
        }

        if (child.getAge() < Constants.KID_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new KidsAverageNiceScoreStrategy();
            return budgetUnit * strategy.execute(child, niceScoreHistoryMap);
        }

        if (child.getAge() <= Constants.TEEN_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new TeenAverageNiceScoreStrategy();
            return budgetUnit * strategy.execute(child, niceScoreHistoryMap);
        } else {
            return -1;
        }

    }

    /**
     * functie care determina averageScore-ul unui copil
     */
    public static double determineAverageScore(final Child child,
                                               final Map<Integer, List<Double>> niceScoreHistoryMap) {
        if (child.getAge() < Constants.BABY_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new BabyAverageNiceScoreStrategy();
            return strategy.execute(child, niceScoreHistoryMap);
        }
        if (child.getAge() < Constants.KID_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new KidsAverageNiceScoreStrategy();
            return strategy.execute(child, niceScoreHistoryMap);
        }
        if (child.getAge() <= Constants.TEEN_MAX_AGE) {
            AverageNiceScoreStrategy strategy = new TeenAverageNiceScoreStrategy();
            return strategy.execute(child, niceScoreHistoryMap);
        } else {
            return -1;
        }
    }

}
