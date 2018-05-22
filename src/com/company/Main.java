package com.company;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This is the main class that initiate the program and run it.
 * */

import GUI.*;
import Thread.*;


public class Main {
    //parameters
    private final static int blockSize = 5;
    private Buffer spartanBuffer;
    //constructor
    public Main() {
        //initialize parameters
        LoggingFile log = new LoggingFile();
        spartanBuffer = new Buffer(blockSize, log);
        Operator operator = new Operator(spartanBuffer);
        Clerk clerk = new Clerk(spartanBuffer);

    }
    //run the program
    public static void main(String[] args) {
        new Main();


    }
}
