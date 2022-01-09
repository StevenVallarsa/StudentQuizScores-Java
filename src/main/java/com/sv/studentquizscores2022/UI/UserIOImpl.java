
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
        System.out.println(prompt);
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
                System.out.println("That wasn't a valid number. Try again.");
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
            System.out.println("That's not a valid choice. Try again.\n");
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
                System.out.println("That wasn't a valid grade. Try again.");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        
        while (true) {
            double number = readDouble(prompt);
            if (number >= min && number <= max) {
                return number;
            }
            System.out.println("Only grades between 0 and 100 are accepted.\n");
        }
    }
}
