package output;

import java.util.ArrayList;
import java.util.List;

public class ChildOutputList {
    private List<ChildOutput> children = new ArrayList<>();

    public ChildOutputList() {

    }

    public ChildOutputList(List<ChildOutput> children) {
        this.children = children;
    }

    public List<ChildOutput> getChildren() {
        return children;
    }

    public void setChildren(List<ChildOutput> children) {
        this.children = children;
    }
}
