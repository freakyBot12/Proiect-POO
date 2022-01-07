package input;

import java.util.List;

public class ChildUpdate {

    private int id;
    private double newNiceScore;
    private List<String> newGiftsPreferences;

    public ChildUpdate() {

    }

    public ChildUpdate(int id, double newNiceScore, List<String> newGiftsPreferences) {
        this.id = id;
        this.newNiceScore = newNiceScore;
        this.newGiftsPreferences = newGiftsPreferences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNewNiceScore() {
        return newNiceScore;
    }

    public void setNewNiceScore(double newNiceScore) {
        this.newNiceScore = newNiceScore;
    }

    public List<String> getNewGiftsPreferences() {
        return newGiftsPreferences;
    }

    public void setNewGiftsPreferences(List<String> newGiftsPreferences) {
        this.newGiftsPreferences = newGiftsPreferences;
    }
}
