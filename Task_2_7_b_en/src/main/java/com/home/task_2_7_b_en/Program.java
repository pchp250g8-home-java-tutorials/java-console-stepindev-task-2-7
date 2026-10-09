/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
to change this license
 */
package com.home.task_2_7_b_en;
import java.io.*;
/**
 *
 * @author PC
 */
public class Program 
{

    public static void main(String[] args) throws Exception
    {
        int a; // Current code
        int b; // Target code
        int m = 0; // Number of digits in the target code
        int n = 0; // Number of digits in the current code
        int total_moves = 0; // Number of dial movements
        int a1, b1; // Temporary variables for handling the lock combinations
        //--Variable for keyboard input
        var stdin = new BufferedReader(new InputStreamReader(System.in)); 
        //--Keyboard input: target and current codes--
        //--Entered as four-digit numbers--
        System.out.print("Enter the current code: "); 
        a = Integer.parseInt(stdin.readLine()); 
        System.out.print("Enter the target code: "); 
        b = Integer.parseInt(stdin.readLine()); 
        a1 = a; b1 = b; 
        // Number of digits in the current code
        while (a1 > 0) // Loop condition
        {
            m += 1; // Increment digit counter
            a1 /= 10; // Divide number by 10
        }
        // Number of digits in the target code
        while (b1 > 0) // Loop condition
        {
            n += 1; // Increment digit counter
            b1 /= 10; // Divide number by 10
        }
        // Check if the lengths of the current and target codes match
        // If the length of the current code does not equal the length of the target
        // or if the codes are not four digits long, the program terminates. 
        if ((m != 4) || (n != 4) || (m != n))
        {
            System.out.println("The lock combination must be 4 digits long."); 
            System.out.println("The current and target codes must be of the same length."); 
            System.exit(0); // Exit the program
        }
        a1 = a; b1 = b; 
        // Iterate through the digits of the current and target codes
        while ((a1 > 0) && (b1 > 0))
        {
            var d1 = a1 % 10; // Digit of the current code
            var d2 = b1 % 10; // Digit of the target code
            var diff1 = Math.abs(d1 - d2); // Difference between digits (forward dial movement)
            var diff2 = 10 - Math.abs(d1 - d2); // Difference between digits (reverse dial movement)
            // Minimum number of moves—the difference between each digit
            // in the target code and the current safe lock code
            total_moves += Math.min(diff1, diff2); 
            a1 /= 10; // Move to the next digit of the current code
            b1 /= 10; // Move to the next digit of the target code
        }
        // Display information on the screen
        System.out.println("Current code:" + a); 
        System.out.println("Target code:" + b); 
        System.out.println("Minimum number of moves:" + total_moves);
    }
}