package control;

import model.Polynomial;
import model.PolynomialFloating;
import view.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
*Class used for 'linking' the user interface to the functionality of the app (View - Model).
* It contains action listeners for the GUI buttons, and some methods that take and validate the
* input from the user (showing pop-ups in case it is invalid): getInput() and check();
 - when a button is pressed, the used input will be read (depending on which button was pressed),
   the right operation will be performed and the output will be displayed on the Result field.
 */

public class Action extends UserInterface implements ActionListener {

    public Action() {
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        deriveButton.addActionListener(this);
        integrateButton.addActionListener(this);
    }

    public int[] getInput(JTextField f) {
        String[] input = f.getText().split(" ");  //splits the input into parts delimited by " ";
        int[] coef = new int[input.length];

        try {
            for (int i = 0; i < input.length; i++) {
                coef[i] = Integer.parseInt(input[i]);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please input integers only!",
                    "Invalid input", JOptionPane.ERROR_MESSAGE);
        }

        return coef;
    }

    //method that checks for invalid input in both text fields
    public boolean check(JTextField f1, JTextField f2) {
        if (f1.getText().isEmpty() || f2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input both polynomials.",
                    "Invalid input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    //overloading the previous method  -- checks for invalid input in one text field
    public boolean check(JTextField f) {
        if (f.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please input a valid polynomial.",
                    "Invalid input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        Polynomial a = new Polynomial(getInput(polyField1));
        Polynomial b = new Polynomial(getInput(polyField2));
        if (e.getSource() == addButton) {
            if (check(polyField1, polyField2)) {
                operationResult.setText(a.add(b).toString());
            }
        } else {
            if (e.getSource() == subtractButton) {
                if (check(polyField1, polyField2)) {
                    operationResult.setText(a.subtract(b).toString());
                }
            } else {
                if (e.getSource() == multiplyButton) {
                    if (check(polyField1, polyField2)) {
                        operationResult.setText(a.multiply(b).toString());
                    }
                } else {
                    if (e.getSource() == deriveButton) {
                        if (check(polyField1)) {
                            operationResult.setText(a.derive().toString());
                        }
                    } else {
                        if (e.getSource() == integrateButton) {
                            if (check(polyField1)) {
                                int[] fieldInput = getInput(polyField1);
                                float[] aCoeff = new float[fieldInput.length];
                                for (int i = 0; i < fieldInput.length; i++) {
                                    aCoeff[i] = (float) (fieldInput[i]);
                                }
                                PolynomialFloating x = new PolynomialFloating(aCoeff);
                                operationResult.setText(x.integrate().toString() + "x");
                            }
                        }
                    }
                }
            }
        }
    }
}

