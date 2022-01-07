package actions;

import input.Child;
import input.Gift;
import input.Input;

import java.util.List;

public class ChosenGift {

    public static void searchChosenGift(Child child, Input input, List<Gift> receivedGifts, double allocatedBudget) {
        for (String preference : child.getGiftsPreferences()) {
            double minGiftPrice = Double.MAX_VALUE;
            Gift chosenGift = new Gift();
            for (Gift gift : input.getInitialData().getSantaGiftsList()) {
                if (gift.getCategory().equals(preference)) {
                    if (gift.getPrice() < minGiftPrice) {
                        minGiftPrice = gift.getPrice();
                        chosenGift = gift;
                    }
                }
            }
            if (allocatedBudget - minGiftPrice >= 0) {
                receivedGifts.add(chosenGift);
                allocatedBudget -= minGiftPrice;
            }
        }
    }
}
