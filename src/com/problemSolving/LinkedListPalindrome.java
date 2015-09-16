package com.problemSolving;

import java.util.Stack;

public class LinkedListPalindrome
{
    public static void main(String[] args)
    {
        LinkedListPalindrome lp = new LinkedListPalindrome();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        lp.process(n1);
    }

    private void process(Node node)
    {
        Stack<Node> stack = new Stack<Node>();
        Node head = node;
        Node current = node;
        while (current != null)
        {
            stack.push(current);
            current = current.next;
        }
        current = head;
        while (current != null)
        {
            if (stack.peek().data == current.data)
            {
                stack.pop();
            }
            current = current.next;
        }
        if (stack.isEmpty())
        {
            System.out.println("Its palindrome");
        } else
        {
            System.out.println("Its  not palindrome");
        }
    }
}

class Node
{
    int  data;

    Node next;

    public Node(int i)
    {
        data = i;
    }
}