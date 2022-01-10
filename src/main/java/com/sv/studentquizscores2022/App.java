
package com.sv.studentquizscores2022;

import com.sv.studentquizscores2022.UI.UserIO;
import com.sv.studentquizscores2022.UI.UserIOImpl;
import java.util.Arrays;
import java.util.Collections;
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
        
        Map<String, double[]> quizGrades = new HashMap<>();
        quizGrades.put("Steve", new double[] {05, 99, 98});
        quizGrades.put("Julie", new double[] {05, 99, 98});
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
            io.print("8 - EXIT");
            
            int response = io.readInt("What is your selection?", 1, 8);
            
            // This is the "brute force" way of working through this menu.
            // In a future exercise this will be refactored into separate
            // methods.
            switch(response) {
                case 1:
                    String studentToAdd = io.readString("Student name:");
                    double[] grades = new double[3];
                    for(int i = 0; i < 3; i++) {
                        grades[i] = io.readDouble("What is grade #" + i + 1, 0, 100);
                    }
                    quizGrades.put(studentToAdd, grades);
                    break;
                    
                case 2:
                    String studentToDelete = io.readString("Student name:");
                    if (quizGrades.get(studentToDelete) == null) {
                        io.print("That student doesn't exist.");
                    } else {
                        quizGrades.remove(studentToDelete);
                        io.print(studentToDelete + " has been removed.");
                    }
                    break;
                    
                case 3:
                    if (quizGrades.size() == 0) {
                        io.print("There are no students to display.");
                    } else {
                        io.print("");
                        for (String student : quizGrades.keySet()) {
                            String scoresString = Arrays.toString(quizGrades.get(student));
                            double average = Arrays.stream(quizGrades.get(student)).average().orElse(0);
                            String averageString = String.format("%.1f", average);
                            
                            io.print(student + ": " + scoresString + " : AVG: " + averageString);
                        }
                    }
                    break;
                    
                case 4:
                    if (quizGrades.size() == 0) {
                        io.print("There are no students to display.");
                    } else {
                        double highestGrade = 0;
                        for (String student : quizGrades.keySet()) {
                            double maxGrade = Arrays.stream(quizGrades.get(student)).max().getAsDouble();
                            if (maxGrade > highestGrade) {
                                highestGrade = maxGrade;
                            }
                        }
                        io.print("\nThe hightest grade is " + highestGrade + ", and was attained by:");
                        for (String student : quizGrades.keySet()) {
                            if (Arrays.stream(quizGrades.get(student)).anyMatch(grade -> grade == highestGrade)) {
                                io.print("- " + student);
                                
                            }
                        }
                    }
                    break;
                    
                case 5:
                    if (quizGrades.size() == 0) {
                        io.print("There are no students to display.");
                    } else {
                        double highestAverage = 0;
                        for (String student : quizGrades.keySet()) {
                            double average = Arrays.stream(quizGrades.get(student)).average().orElse(0);
                            if (average > highestAverage) {
                                highestAverage = average;
                            }
                        }
                        io.print("\nThe hightest average is " + String.format("%.1f", highestAverage) + ", and was attained by:");
                        for (String student : quizGrades.keySet()) {
                            if (Arrays.stream(quizGrades.get(student)).average().orElse(0) == highestAverage) {
                                io.print("- " + student);
                            }
                        }                        
                    }
                    break;
                    
                case 6:
                    if (quizGrades.size() == 0) {
                        io.print("There are no students to display.");
                    } else {
                        double lowestGrade = 100;
                        for (String student : quizGrades.keySet()) {
                            double minGrade = Arrays.stream(quizGrades.get(student)).min().getAsDouble();
                            if (minGrade < lowestGrade) {
                                lowestGrade = minGrade;
                            }
                        }
                        io.print("\nThe lowest grade is " + lowestGrade + ", and was attained by:");
                        for (String student : quizGrades.keySet()) {
                            for (double grade : quizGrades.get(student)) {
                                if (lowestGrade == grade) {
                                    io.print("- " + student);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    if (quizGrades.size() == 0) {
                        io.print("There are no students to display.");
                    } else {
                        double lowestAverage = 100;
                        for (String student : quizGrades.keySet()) {
                            double average = Arrays.stream(quizGrades.get(student)).average().orElse(0);
                            if (average < lowestAverage) {
                                lowestAverage = average;
                            }
                        }
                        io.print("\nThe lowest average is " + String.format("%.1f", lowestAverage) + ", and was attained by:");
                        for (String student : quizGrades.keySet()) {
                            if (Arrays.stream(quizGrades.get(student)).average().orElse(0) == lowestAverage) {
                                io.print("- " + student);
                            }
                        }                        
                    }
                    break;
                    
                case 8:
                    isLooping = false;
                    break;
                default:
                    io.print("That wasn't a valid choice. Try again.\n");
                    
            }
        }
        io.print("\nGoodbye!");
    }

}
