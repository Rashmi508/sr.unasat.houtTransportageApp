package sr.unasat.A.D;

public class VeldPost {

    public String label;
    public boolean wasVisited;
    public boolean isInTree;

    public VeldPost (String post) {
        label = post;
        wasVisited = false;
        isInTree = false;

    }
}
