
package com.sv.studentquizscores2022.UI;

/**
 *
 * @author StevePro
 */
public interface UserIO {
    void print(String message);
    String readString(String prompt);
    int readInt(String prompt);
    int readInt(String prompt, int min, int max);
    double readDouble(String prompt);
    double readDouble(String prompt, double min, double max);
    
}
