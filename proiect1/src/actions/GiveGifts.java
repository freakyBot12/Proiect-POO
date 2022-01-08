package actions;

import input.Child;
import input.Input;
import output.Output;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GiveGifts {

    public static void execute(Input input, Output output) {
        Round0.execute(input, output);
        Map<Integer, List<Double>> niceScoreHistoryMap = new LinkedHashMap<>();
        for (Child child : input.getInitialData().getChildren()) {
            List<Double> scoreHistory = new ArrayList<>();
            scoreHistory.add(child.getNiceScore());
            niceScoreHistoryMap.put(child.getId(), scoreHistory);
        }
        NextRounds.execute(input, output, niceScoreHistoryMap);
    }
}
