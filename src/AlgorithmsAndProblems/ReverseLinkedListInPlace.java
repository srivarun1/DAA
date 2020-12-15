package AlgorithmsAndProblems;

import java.util.Scanner;

public class ReverseLinkedListInPlace {

    private static ListNode reverse(ListNode head)
    {
        if(head.next == null)
        {
            return head;
        }
        else
        {
            ListNode next = reverse(head.next);
            head.next = null;
            ListNode temp = next;
            while(temp != null && temp.next != null) {
                temp = temp.next;
            }
            temp.next = head;
            return next;
        }
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
        try {
            ListNode result = reverse(head);
            while(result != null)
            {
                System.out.println(result.val);
                result = result.next;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
