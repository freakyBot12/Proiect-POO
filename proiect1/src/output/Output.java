package output;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private List<ChildOutputList> annualChildren = new ArrayList<>();

    public Output() {

    }

    public Output(List<ChildOutputList> annualChildren) {
        this.annualChildren = annualChildren;
    }

    public List<ChildOutputList> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(List<ChildOutputList> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
