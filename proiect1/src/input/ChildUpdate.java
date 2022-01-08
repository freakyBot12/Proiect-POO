package input;

import java.util.ArrayList;
import java.util.List;

public class ChildUpdate {

    private int id;
    private Double niceScore;
    private List<String> giftsPreferences;

    public ChildUpdate() {
        giftsPreferences = new ArrayList<>();
    }

    public ChildUpdate(int id, Double newNiceScore, List<String> giftsPreferences) {
        this.id = id;
        this.niceScore = newNiceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}
