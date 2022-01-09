
package com.sv.studentquizscores2022;

import com.sv.studentquizscores2022.UI.UserIO;
import com.sv.studentquizscores2022.UI.UserIOImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-09
 * purpose: Practice userIO interface and implementation
 */
public class App {
    public static void main(String[] args) {
        
        Map<String, double[]> quizScores = new HashMap<>();
        boolean isLooping = true;
        
        UserIO io = new UserIOImpl();
        
        while (isLooping) {
            
            // Display main menu
            io.print("\nSTUDENT QUIZ SCORES MENU");
            io.print("========================");
            io.print("1 - Add Student");
            io.print("2 - Delete Student");
            io.print("3 - Display Grades");
            io.print("4 - Display Highest Grade");
            io.print("5 - Display Highest Average");
            io.print("6 - Display Lowest Grade");
            io.print("7 - Display Lowest Average");
            io.print("7 - EXIT");
            
            int response = io.readInt("What is your selection?", 1, 8);
            
            switch(response) {
                case 1:
                    String studentToAdd = io.readString("Student name:");
                    double[] grades = new double[3];
                    for(int i = 0; i < 3; i++) {
                        grades[i] = io.readDouble("What is grade #" + i + 1, 0, 100);
                    }
                    quizScores.put(studentToAdd, grades);
                    break;
                case 2:
                    String studentToDelete = io.readString("Student name:");
                    if (quizScores.get(studentToDelete) == null) {
                        io.print("That student doesn't exist.");
                    } else {
                        quizScores.remove(studentToDelete);
                        io.print(studentToDelete + " has been removed.");
                    }
                    break;
                case 3:
                    for (String student : quizScores.keySet()) {
                        double average = Arrays.stream(quizScores.get(student)).average().orElse(0);
                        io.print(student + ": " + Arrays.toString(quizScores.get(student)) + " : AVG: " + String.format("%.1f", average));
                    }
                    break;
                default:
                    io.print("That wasn't a valid choice. Try again.\n");
                    
                    
            }
        }
    }

}
