package Thread;
/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Operator Thread class that operations using the thread process.
 * */

import GUI.*;
import javax.swing.*;

public class OperatorThread implements Runnable{
    //parameters
    private Buffer spartanBuffer;
    private Operator operator;
    //constructor
    public OperatorThread(Operator operator, Buffer spartanBuffer){
        //initialize the  parameters
        this.operator = operator;
        this.spartanBuffer = spartanBuffer;

    }
    //this is the run method for operator to be used in the thread. It gets the the instance of the order button the operator
    //gui textfield and run the get and set method operations that will be handled along with the string queue
    // using the buffer
    @Override
    public void run() {

        JButton button = operator.getOperatorOrderButton();
        JTextField operatorTextField = operator.getOperatorTextField();

        while (!operator.getQuitButtonValue()){
            try {
                Thread.sleep((long) (100 * (-Math.log(Math.random()))));
            } catch (InterruptedException e) {
            }
            if(operator.getOrderButtonValue()) {
                button.setEnabled(false);
                String item = operatorTextField.getText();
                spartanBuffer.add(item);

                operatorTextField.setText("");
                button.setEnabled(true);
                operator.setOrderButtonValue();

            }
        }

    }
}
