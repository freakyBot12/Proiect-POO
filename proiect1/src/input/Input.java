package input;

import java.util.List;

public class Input {

    private int numberOfYears;
    private int santaBudget;
    private InitialData initialData;
    private List<AnnualChange> annualChanges;

    public Input() {

    }

    public Input(int numberOfYears, int santaBudget, InitialData initialData, List<AnnualChange> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public int getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(int santaBudget) {
        this.santaBudget = santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(List<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }
}
