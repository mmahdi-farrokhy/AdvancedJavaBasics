package calculator;

import javax.swing.*;

import static java.lang.Double.parseDouble;

public class Calculator {
    public String add(String num1, String num2) {
        double result = 0;
        double d1 = 0;
        double d2 = 0;
        try {
            d1 = parseDouble(num1);
            d2 = parseDouble(num2);
        } catch (NumberFormatException nfe){
            showMessageBox("Entered Numbe Is Wrong!");
        }

        result = d1 + d2;
        return String.valueOf(result);
    }

    public String substract(String num1, String num2) {
        double result = 0;
        double d1 = 0;
        double d2 = 0;
        try {
            d1 = parseDouble(num1);
            d2 = parseDouble(num2);
        } catch (NumberFormatException nfe){
            showMessageBox("Entered Numbe Is Wrong!");
        }

        result = d1 - d2;
        return String.valueOf(result);
    }

    public String multiply(String num1, String num2) {
        double result = 0;
        double d1 = 0;
        double d2 = 0;
        try {
            d1 = parseDouble(num1);
            d2 = parseDouble(num2);
        } catch (NumberFormatException nfe){
            showMessageBox("Entered Numbe Is Wrong!");
        }

        result = d1 * d2;
        return String.valueOf(result);
    }

    public String divide(String num1, String num2) {
        double result = 0;
        double d1 = 0;
        double d2 = 0;

        try {
            d1 = parseDouble(num1);
            d2 = parseDouble(num2);
            if(d2 == 0)
                return "Division By Zero";
        } catch (NumberFormatException nfe) {
            showMessageBox("Entered Numbe Is Wrong!");
        }

        result = d1 / d2;
        return String.valueOf(result);
    }

    public static void showMessageBox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Error: ", JOptionPane.INFORMATION_MESSAGE);
    }
}
