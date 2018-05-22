package Thread;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the buffer class that handles the communications of threads in the programs
 * */

import com.company.LoggingFile;

public class Buffer {

    private String[] stringQueue;//hold the items in a string array
    private int size, frontItem, lastItem, blockSize;// int parameters to be used in the string array
    private LoggingFile log;//log file

    //constructor
    public Buffer(int blockSize, LoggingFile log){
        //initialize the parameters
        stringQueue = new String[blockSize];
        this.blockSize = blockSize;
        size = 0;
        frontItem = 0;
        lastItem = 0;
        this.log = log;

    }

    //method to add an item to the queue which will be used in a synchronized thread
    public synchronized void add(String item){
        try {
            while (isFull()) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        log.write("Operator Ordered Item: "+item);
        stringQueue[lastItem] = item;
        lastItem++;//queue is never shifted but the place of the last item is located is defined by index lastItem
        lastItem = lastItem%blockSize;
        size++;
        notifyAll();
    }

    //method to remove an item to the queue which will be used in a synchronized thread
    public synchronized String leave(){
        try {
            while (isEmpty()) {
                System.out.println("EMPTY");
                wait();

            }
        } catch (InterruptedException e) {
        }

        log.write("Clerk Shipped Item: "+stringQueue[frontItem]);
        String item = stringQueue[frontItem];
        stringQueue[frontItem] = null;
        frontItem++;//the front of the queue is defined by the index of frontItem
        frontItem = frontItem%blockSize;
        size--;
        notifyAll();
        return item;


    }
    //method to check if the queue is full
    public synchronized boolean isFull() {
        return size >= stringQueue.length;
    }
    //method to check if the queue is empty
    public synchronized boolean isEmpty(){
        return size == 0;
    }
    //method to return the item in front of the queue
    public synchronized String front(){
        return stringQueue[frontItem];
    }

}
