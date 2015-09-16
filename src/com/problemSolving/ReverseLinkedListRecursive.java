package com.problemSolving;

public class ReverseLinkedListRecursive
{
    public static void main(String[] args)
    {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        a.printLinkedList();
        Node head = reverseLinkedList(a);
        head.printLinkedList();
    }

    public static Node reverseLinkedList(Node head)
    {
        if (head.next == null)
            return head;
        Node newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static class Node
    {
        public Node next;

        public int  value;

        public Node(int value)
        {
            this.value = value;
        }

        public void printLinkedList()
        {
            Node head = this;
            while (head != null)
            {
                System.out.print(head.value + "->");
                head = head.next;
            }
            System.out.println();
        }

    }
}
