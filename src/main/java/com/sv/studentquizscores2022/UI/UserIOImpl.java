
package com.sv.studentquizscores2022.UI;

import java.util.Scanner;


/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-09
 * purpose: 
 */
public class UserIOImpl implements UserIO {
    
    Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        
        while(true) {
            String input = readString(prompt);
            
            try {
                int number = Integer.parseInt(input);
                return number;
            } catch (Exception e) {
                print("That wasn't a valid number. Try again.");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        
        while (true) {
            int number = readInt(prompt);
            if (number >= min && number <= max) {
                return number;
            }
            print("That's not a valid choice. Try again.\n");
        }
    }

    @Override
    public double readDouble(String prompt) {
        
        while(true) {
            String input = readString(prompt);
            
            try {
                double number = Double.parseDouble(input);
                return number;
            } catch (Exception e) {
                print("That wasn't a valid grade. Try again.");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        
        while (true) {
            double grade = readDouble(prompt);
            if (grade >= min && grade <= max) {
                return grade;
            }
            print("Only grades between " + min + "and " + max + " are accepted.\n");
        }
    }
}
