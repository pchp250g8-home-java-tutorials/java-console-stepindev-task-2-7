/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.home.task_2_7_en;
import java.io.*;
/**
 *
 * @author PC
 */
public class Program 
{
    public static void main(String[] args) 
    {
        String a; // current code string
        String b; // target code string
        int n_len1; // length of current code string
        int n_len2; // length of target code string
        int total_moves = 0; // move counter
        //--Variable for keyboard input
        var stdin = new BufferedReader(new InputStreamReader(System.in)); 
        // Reading input data
        System.out.print("Enter current code: "); // Prompt
        a = stdin.readLine(); // Input current code
        System.out.print("Enter target code: "); 
        b = stdin.readLine(); // Input target code
        a = a.trim(); // Remove unnecessary whitespace
        b = b.trim(); // Remove unnecessary whitespace
        n_len1 = a.length(); // Calculate length of 1st string
        n_len2 = b.length(); // Calculate length of 2nd string
        // Check if current and target code lengths match
        // If the current code length does not equal the target length
        // or if the codes are not four digits long, the program terminates. 
        if ((n_len1 != 4) || (n_len2 != 4) || (n_len1 != n_len2))
        {
            System.out.println("The combination lock code must be 4 digits."); 
            System.out.println("Current and target codes must be of the same length."); 
            System.exit(0); // Exit program
        }
        // Calculate minimum number of moves
        for(int i = 0; i < a.length(); i++)
        {
            var x = (int)(a.charAt(i) - '0'); // Digit of current code
            var y = (int)(b.charAt(i) - '0'); // Target code digit
            var diff1 = Math.abs(x - y); // digit difference, forward dial rotation
            // digit difference, reverse dial rotation
            var diff2 = 10 - Math.abs(x - y); 
            // Minimum number of moves—the difference between each digit of the dial
            // in the target code and the current safe code
            // Total number of moves—the answer to the problem
            total_moves += Math.min(diff1, diff2); 
        }
        // Output information to the screen
        System.out.println("Current code:" + a); 
        System.out.println("Target code:" + b); 
        System.out.println("Minimum number of moves:" + total_moves);
    }
}