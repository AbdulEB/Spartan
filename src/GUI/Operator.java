package GUI;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Operator GUI class that creates the Operator GUI and the get and set methods it will
 * use. The Operator thread class is called here.
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import Thread.*;

public class Operator {
    //parameters
    private JFrame operatorFrame;
    private JLabel operatorLabel;
    public JTextField operatorTextField;
    private JButton operatorOrderButton, operatorQuitButton;
    private Boolean isOrderClicked, isQuitClicked = false;
    private OperatorThread operatorThread;

    //constructor
    public Operator(Buffer spartanBuffer){
        //initialize the parameters
        isOrderClicked = false;
        operatorFrame = new JFrame();
        executeOperatorDisplay();
        operatorThread = new OperatorThread(this, spartanBuffer);
        Thread t = new Thread(operatorThread);
        //start the thread
        t.start();

    }
    //method to create the Operator GUI
    private void executeOperatorDisplay(){

        operatorLabel = new JLabel("Item");
        operatorLabel.setBounds(10, 10, 50, 20);

        operatorTextField = new JTextField();
        operatorTextField.setBounds(60, 10, 300, 20);

        operatorOrderButton = new JButton("Order");
        operatorOrderButton.setBounds(80, 40, 100, 25);
        //on click method is to execute when the button is clicked
        operatorOrderButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent event){
                operatorOrderButtonMouseOnClick(event);
            }
        });
        operatorQuitButton = new JButton("Quit");
        operatorQuitButton.setBounds(190, 40, 100, 25);
        //on click method is to execute when the button is clicked
        operatorQuitButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent event){
                operatorQuitButtonMouseOnClick(event);
            }
        });

        operatorFrame.add(operatorLabel);
        operatorFrame.add(operatorTextField);
        operatorFrame.add(operatorOrderButton);
        operatorFrame.add(operatorQuitButton);
        operatorFrame.setPreferredSize(new Dimension(400, 120));
        operatorFrame.setTitle("Phone Operator");
        operatorFrame.setResizable(false);
        operatorFrame.setLocation(400, 400);
        operatorFrame.setLayout(null);
        operatorFrame.setVisible(true);
        operatorFrame.pack();
    }

    //method to run if the quit button is pressed
    public void operatorOrderButtonMouseOnClick(MouseEvent event){
                isOrderClicked = true;
    }
    //method to run if the order button is pressed
    public void operatorQuitButtonMouseOnClick(MouseEvent event){
        isQuitClicked = true;
        operatorFrame.dispose();
    }
    //get method to return the text field
    public JTextField getOperatorTextField() {
        return operatorTextField;
    }
    //method to reset if the order button is pressed
    public void setOrderButtonValue(){
        if (isOrderClicked){
            isOrderClicked = false;
        }
        else{
            isOrderClicked = true;
        }

    }
    //method to get if the order button is pressed
    public boolean getOrderButtonValue(){
        return isOrderClicked;
    }
    //method to get the value if the quit button is pressed
    public boolean getQuitButtonValue(){
        return isQuitClicked;
    }
    //method to return the order button
    public JButton getOperatorOrderButton() {
        return operatorOrderButton;
    }
}
