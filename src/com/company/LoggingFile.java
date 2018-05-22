package com.company;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is logging class that logs the order and ships items to log.txt
 * */

import java.io.*;

public class LoggingFile {

    //constructor
    public LoggingFile() {
    }

    //This method just append the the item that is on the textfield when the user press either the chi or order
    // button to an already existing log.txt file
    public static void write(String input) {


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
            input += "\n";
            writer.append(input);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
