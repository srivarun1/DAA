package AlgorithmsAndProblems;

import java.util.*;
/*

    https://leetcode.com/problems/reverse-nodes-in-k-group/solution/
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

public class ReverseKNodesInGroup {
    ListNode temporaryNext = null;

    public  ListNode reverseKNodes(ListNode head, int k)
    {
        ListNode start = head;
        ListNode toRet = null;
        ListNode prev = null;
        ListNode next = null;
        int len = 0;
        while(head != null)
        {
            head = head.next;
            len++;
        }
        System.out.println("len : " + len);
        len = len/k;
        System.out.println("len : " + len);
        while(len > 0)
        {
            prev = start;
            start = reverseK(start,k,1);
            if(next != null)
            {
                next.next = start;
            }
            if(temporaryNext!= null)
            {
                prev.next = temporaryNext;
                temporaryNext = null;
            }

            if(toRet == null)
            {
                toRet = start;
            }

            next = prev;
            start = prev.next;
            if(prev.next == null)
            {
                break;
            }
            len--;

        }

        return toRet;
    }

    public ListNode reverseK(ListNode node, int k, int pos)
    {

        if(pos == k || node.next == null)
        {

            temporaryNext = node.next;
            node.next = null;
            return node;
        }
        else
        {
            ListNode next = reverseK(node.next,k,pos+1);
            node.next = null;
            ListNode temp = next;
            while(temp != null && temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            return next;
        }
    }

    public static void main(String[] args)
    {
        Scanner k = new Scanner(System.in);
        System.out.println("Enter the size of the linked list : ");
        int size = k.nextInt();
        System.out.println("Enter k node value : ");
        int knodes = k. nextInt();
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
        ReverseKNodesInGroup test = new ReverseKNodesInGroup();
        ListNode node = test.reverseKNodes(head,knodes);
        while(node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
    }
}


