package com.problemSolving;

public class BitwiseTest
{
    static final int HAMBURGER    = 1; // 00000001

    static final int CHEESEBURGER = 2; // 00000010

    static final int FRIES        = 4; // 00000100

    static final int SODA         = 8; // 00001000

    public static void main(String[] args)
    {
        orderFood("Bob", HAMBURGER | FRIES);
        orderFood("Jane", FRIES | SODA | CHEESEBURGER);
    }

    public static void orderFood(String person, int foods)
    {
        System.out.println(person + " ordered:");
        if ((HAMBURGER & foods) == HAMBURGER)
            System.out.println("\tHamburger");
        if ((CHEESEBURGER & foods) == CHEESEBURGER)
            System.out.println("\tCheeseburger");
        if ((FRIES & foods) == FRIES)
            System.out.println("\tFries");
        if ((SODA & foods) == SODA)
            System.out.println("\tSoda");
    }
}
