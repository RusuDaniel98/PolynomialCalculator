package view;

import javax.swing.*;
import java.awt.*;

/*
 *Class used for designing the graphical user interface.
 *It is a frame that contains three panels for input, output and usage information.
 *I have added borders to all three panels to make them look better and to let the user know what that particular area
 * of the interface is used for.
 */

public class UserInterface extends JFrame {

    public JFrame frame;
    public JPanel inputDetailsPanel;
    public JPanel outputDetailsPanel;
    public JPanel infoPanel;
    public JButton addButton;
    public JButton subtractButton;
    public JButton multiplyButton;
    public JButton divideButton;
    public JButton deriveButton;
    public JButton integrateButton;
    public JTextField polyField1;
    public JTextField polyField2;
    public JLabel operationResult;
    public JLabel polyLabel1;
    public JLabel polyLabel2;
    public JLabel resultLabel;
    public JLabel infoLabel;

    public UserInterface() {

        frame = new JFrame("Polynomials Calculus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //to stop running the program when clicking X button
        frame.setVisible(true);
        frame.setSize(600, 230);

        //set layout manager (decide how to range components on the frame)
        frame.setLayout(new BorderLayout());

        //create swing components
        inputDetailsPanel = new JPanel();
        outputDetailsPanel = new JPanel();
        infoPanel = new JPanel();

        //add swing components to content pane
        Container container = frame.getContentPane();
        container.add(outputDetailsPanel, BorderLayout.NORTH);
        container.add(inputDetailsPanel, BorderLayout.CENTER);
        container.add(infoPanel, BorderLayout.SOUTH);

        //make it look better with a border
        outputDetailsPanel.setBorder(BorderFactory.createTitledBorder("Input Information"));

        polyLabel1 = new JLabel("First Polynomial");
        polyLabel2 = new JLabel("Second Polynomial");

        polyField1 = new JTextField(25);
        polyField2 = new JTextField(25);

        //set a new layout
        outputDetailsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //GridBag Manager divides your panel into a grid. With these instructions I tell it that I want it
        // to start in the left-up corner: (Y increases going downwards; X increases going from left to right)

        //** First Column **//
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        outputDetailsPanel.add(polyLabel1, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        outputDetailsPanel.add(polyLabel2, gc);

        //** Second Column **//
        gc.anchor = GridBagConstraints.LINE_START;  //make the text fields stick to the left side of the column;

        gc.gridx = 1;
        gc.gridy = 0;
        outputDetailsPanel.add(polyField1, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        outputDetailsPanel.add(polyField2, gc);

        //***************** Second JPanel

        inputDetailsPanel.setBorder(BorderFactory.createTitledBorder("Output Information"));

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        deriveButton = new JButton("Derive");
        integrateButton = new JButton("Integrate");

        operationResult = new JLabel();

        inputDetailsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc2 = new GridBagConstraints();

        gc2.weightx = 0.5;
        gc2.weighty = 0.5;

        //add
        gc2.gridx = 0;
        gc2.gridy = 0;
        inputDetailsPanel.add(addButton, gc2);

        //subtract
        gc2.gridx = 1;
        gc2.gridy = 0;
        inputDetailsPanel.add(subtractButton, gc2);

        //multiply
        gc2.gridx = 2;
        gc2.gridy = 0;
        inputDetailsPanel.add(multiplyButton, gc2);

        //derive
        gc2.gridx = 3;
        gc2.gridy = 0;
        inputDetailsPanel.add(deriveButton, gc2);

        //integrate
        gc2.gridx = 4;
        gc2.gridy = 0;
        inputDetailsPanel.add(integrateButton, gc2);

        gc2.anchor = GridBagConstraints.CENTER;

        resultLabel = new JLabel("Operation Result:");
        gc2.gridx = 0;
        gc2.gridy = 1;
        inputDetailsPanel.add(resultLabel, gc2);

        gc2.anchor = GridBagConstraints.CENTER;
        gc2.gridwidth = 4;
        gc2.gridx = 1;
        gc2.gridy = 1;
        inputDetailsPanel.add(operationResult, gc2);

        //***************** Third JPanel

        //info label  -- used to tell the user how to use the operations (mainly for derive and integrate).
        infoPanel.setBorder(BorderFactory.createTitledBorder("Usage Information"));

        infoLabel = new JLabel("When using 'Derive' or 'Integrate', input the polynomial coefficients on the " +
                "first text field.");

        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc3 = new GridBagConstraints();

        gc3.weightx = 0.5;
        gc3.weighty = 0.5;

        gc3.gridheight = 2;

        gc3.anchor = GridBagConstraints.LINE_START;
        gc3.gridx = 0;
        gc3.gridy = 0;
        infoPanel.add(infoLabel, gc3);

        frame.setVisible(true);

    }

}