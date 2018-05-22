package Thread;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Clerk Thread class that operations using the thread process.
 * */

import GUI.*;
import javax.swing.*;

public class ClerkThread implements Runnable{

    //parameters
    private Buffer spartanBuffer;
    private Clerk clerk;
    //constructor
    public ClerkThread(Clerk clerk, Buffer spartanBuffer){
        //initialize the  parameters
        this.clerk = clerk;
        this.spartanBuffer = spartanBuffer;
    }

    //this is the run method for clerk to be used in the thread. It gets the the instance of the ship button the clerk
    //gui textfield and run the get and set method operations that will be handled along with the string queue
    // using the buffer
    @Override
    public void run() {

        JButton button = clerk.getClerkShipButton();
        JTextField clerkTextField = clerk.getClerkTextField();
        while (!clerk.getQuitButtonValue()){
            try {
                Thread.sleep((long) (100 * (-Math.log(Math.random()))));
            } catch (InterruptedException e) {
            }

            if (!spartanBuffer.isEmpty() && clerk.getClerkTextField().getText().equals("")){
                clerkTextField.setText(spartanBuffer.front());
                button.setEnabled(true);
            }

            if(clerk.getShipButtonValue()) {
               spartanBuffer.leave();

               if(spartanBuffer.isEmpty()){
                   clerkTextField.setText("");
                   button.setEnabled(false);
               }
               else{
                   clerkTextField.setText(spartanBuffer.front());
                   button.setEnabled(true);
               }

               clerk.setShipButtonValue();
            }
        }
    }
}
