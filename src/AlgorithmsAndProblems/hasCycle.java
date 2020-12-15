package AlgorithmsAndProblems;

import java.util.*;

/*

    Definition of singly linked list

    public class ListNode {
    int val;
    ListNode node;

    public ListNode() {}

    public ListNode(int val)
    {
        this.val = val;
    }

    public ListNode(int val, ListNode node)
    {
        this.val = val;
        this.node = node;
    }
}

 */

public class hasCycle {
    public static boolean hasCycle(ListNode head) {
        if(head == null)
        {
            return false;
        }
        if(head.next == null)
        {
            return false;
        }
        if(head.next.next == null)
        {
            return false;
        }
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare != null)
        {
            if(hare.next != null)
            {
                hare = hare.next.next;
                tortoise = tortoise.next;
            }
            else
            {
                return false;
            }
            if(hare != null)
            {
                if(hare.val == tortoise.val)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner k = new Scanner(System.in);
        System.out.println("Enter the size of the linked list : ");
        int size = k.nextInt();
        System.out.println("Enter the values in the linked list : ");
        ListNode head = null;
        ListNode tail = null;
        for(int i = 0 ; i < size  ; i++)
        {
            if(head == null)
            {
                tail = new ListNode(k.nextInt());
                head = tail;
            }
            else {
                tail.next = new ListNode(k.nextInt());
                tail = tail.next;
            }
        }
        System.out.println(hasCycle(head));
    }
}
