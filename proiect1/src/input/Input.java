package input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private int numberOfYears;
    private double santaBudget;
    private InitialData initialData;
    private List<AnnualChange> annualChanges;

    public Input() {
        initialData = new InitialData();
        annualChanges = new ArrayList<>();
    }

    public Input(int numberOfYears, double santaBudget, InitialData initialData, List<AnnualChange> annualChanges) {
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

    public double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(double santaBudget) {
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
