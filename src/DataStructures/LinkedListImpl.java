package DataStructures;/*
    @author - srivarun.n
    @version - 1.1
 */

public class LinkedListImpl {
    ListNode head = null;
    ListNode curr = null;
    int length = 0;
    public LinkedListImpl(){}

    public LinkedListImpl(int val)
    {
        head = curr = new ListNode(val);
        length++;
    }

    public void add(int val)
    {
        if(head == null)
        {
            head  = new ListNode(val);
            curr = head;
        }
        else
        {
            if(curr != null)
            {
                curr.next = new ListNode(val);
                curr = curr.next;
            }

        }
        length++;

    }

    public void addToHead(int val)
    {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        length++;
    }

    public void deleteHead()
    {
        if(head!=null)
        {
            if(head.equals(curr))
            {
                curr = null;
            }
            head = head.next;
            length--;
        }
    }

    public void delete()
    {
        if(head == null)
        {
            return;
        }

        ListNode listIterator = head;

        while(listIterator != null)
        {
            if(listIterator.equals(curr))
            {
                /*
                    Case when head is equeal to curr node
                 */

                curr = null;
                head = null;
                return;
            }

            if(listIterator.next.equals(curr))
            {
                curr = listIterator;
                curr.next = null;
                return;
            }

            listIterator = listIterator.next;
        }


    }

    public int size()
    {
        return length;
    }

    public boolean isEmpty()
    {
        return head==null;
    }

    public boolean contains(int val)
    {

        ListNode listIterator = head;

        while(listIterator != null)
        {
            if(listIterator.val == val)
            {
                return true;
            }
            listIterator = listIterator.next;
        }
        return false;
    }

    @Override
    public String toString() {
        ListNode listIterator = head;
        String elementsOfTheList = "";
        while(listIterator != null)
        {
            if(elementsOfTheList.equals(""))
            {
                elementsOfTheList+=listIterator.val;
            }
            else
            {
                elementsOfTheList+=","+listIterator.val;
            }
            listIterator = listIterator.next;
        }
        return elementsOfTheList;
    }

    public ListNode getCurr() {
        return curr;
    }

    public ListNode getHead() {
        return head;
    }

    //TODO sort linkedlist

    public static void main(String[] args)
    {
        LinkedListImpl l = new LinkedListImpl();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(10);
        l.deleteHead();
        l.delete();
        l.delete();
        l.addToHead(1);
        System.out.println(l.toString());

    }




}
