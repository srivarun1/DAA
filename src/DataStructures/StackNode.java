package DataStructures;

public class StackNode {
    public boolean isLastNode = false;
    public int val;
    public StackNode next = null;

    public StackNode(int val)
    {
        isLastNode = true;
        this.val = val;
    }

    public StackNode(int val, StackNode top)
    {
        this.val = val;
        this.next = top;
    }
}
