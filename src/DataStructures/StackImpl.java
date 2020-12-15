package DataStructures;

/*
    @author - srivarun
    @version - 1.1
 */
public class StackImpl {
    StackNode top = null;

    public void push(int val)
    {
        if(top == null)
        {
            top = new StackNode(val);
        }
        else
        {
            top = new StackNode(val,top);
        }
    }

    public int pop()
    {
        int topVal = top.val;
        top = top.next;
        return topVal;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public int peek()
    {
        return top.val;
    }


    public static void main(String[] args)
    {
        StackImpl st = new StackImpl();
        System.out.println(st.isEmpty());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());


    }
}
