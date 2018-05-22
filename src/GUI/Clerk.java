package GUI;

/* Author: Abdul El Badaoui
 * Student Number: 5745716
 * Description: This class is the Clerk GUI class that creates the Clerk GUI and the get and set methods it will
 * use. The Clerk thread class is called here.
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import Thread.*;

public class Clerk {
    //parameters
    private JFrame clerkFrame;
    private JLabel clerkLabel;
    public JTextField clerkTextField;
    private JButton clerkShipButton, clerkQuitButton;
    private Boolean isShipClicked, isQuitClicked = false;
    ClerkThread clerkThread;
    //constructor
    public Clerk(Buffer spartanBuffer){
        //initialize the parameters
        isShipClicked = false;
        clerkFrame = new JFrame();
        executeClerkDisplay();
        clerkThread = new ClerkThread(this, spartanBuffer);
        Thread t2 = new Thread(clerkThread);
        //start the thread
        t2.start();
    }
    //method to create the Operator GUI
    private void executeClerkDisplay(){

        clerkLabel = new JLabel("Item");
        clerkLabel.setBounds(10, 10, 50, 20);

        clerkTextField = new JTextField();
        clerkTextField.setBounds(60, 10, 300, 20);

        clerkShipButton = new JButton("Ship");
        clerkShipButton.setBounds(80, 40, 100, 25);
        clerkShipButton.setEnabled(false);
        //on click method is to execute when the button is clicked
        clerkShipButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent event){
                clerkShipButtonMouseOnClick(event);
            }
        });
        clerkQuitButton = new JButton("Quit");
        clerkQuitButton.setBounds(190, 40, 100, 25);
        //on click method is to execute when the button is clicked
        clerkQuitButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent event){
                clerkQuitButtonMouseOnClick(event);
            }
        });

        clerkFrame.add(clerkLabel);
        clerkFrame.add(clerkTextField);
        clerkFrame.add(clerkShipButton);
        clerkFrame.add(clerkQuitButton);
        clerkFrame.setPreferredSize(new Dimension(400, 120));
        clerkFrame.setTitle("Ship Clerk");
        clerkFrame.setResizable(false);
        clerkFrame.setLocation(1000, 400);
        clerkFrame.setLayout(null);
        clerkFrame.setVisible(true);
        clerkFrame.pack();

    }

    //method to run if the ship button is pressed
    public void clerkShipButtonMouseOnClick(MouseEvent event){
            isShipClicked = true;
    }
    //method to run if the quit button is pressed
    public void clerkQuitButtonMouseOnClick(MouseEvent event){
        isQuitClicked = true;
        clerkFrame.dispose();
    }
    //get method to return the text field
    public JTextField getClerkTextField(){
        return clerkTextField;
    }
    //method to reset if the ship button is pressed
    public void setShipButtonValue(){
        if (isShipClicked){
            isShipClicked = false;
        }
        else{
            isShipClicked = true;
        }

    }

    //method to get if the ship button is pressed
    public boolean getShipButtonValue(){
        return isShipClicked;
    }
    //method to get the value if the quit button is pressed
    public boolean getQuitButtonValue(){
        return isQuitClicked;
    }
    //method to return the ship button
    public JButton getClerkShipButton() {
        return clerkShipButton;
    }
}
