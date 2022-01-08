package input;

import java.util.ArrayList;
import java.util.List;

public class InitialData {

    private List<Child> children;
    private List<Gift> santaGiftsList;

    public InitialData() {
        children = new ArrayList<>();
        santaGiftsList = new ArrayList<>();
    }

    public InitialData(List<Child> children, List<Gift> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(List<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
