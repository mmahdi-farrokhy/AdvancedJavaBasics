package calculator;
import javax.swing.*;
import java.awt.*;


public class CalculatorUI {

    // Parameters and Status
    private static String num1 = "";
    private static String num2 = "";
    private static String result = "";
    private static boolean plus = false;
    private static boolean minus = false;
    private static boolean mult = false;
    private static boolean div = false;
    private static boolean equal = false;
    private static int point = 0;


    public static void main(String args[]){

        // Main Frame
        JFrame calc_frame = new JFrame("calculator");

        // Text Field
        JTextField display = new JTextField();
        display.setBounds(0,0,150,50);
        calc_frame.add(display);
        display.setEnabled(true);
        display.setEditable(false);
        display.setBackground(Color.white);
        display.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton btn_C     = crateButton("C", 150, 0);
        btn_C.addActionListener(e -> {
            display.setText("");
        });

        JButton btn_1     = crateButton("1", 0,   50);
        btn_1.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_1.getText());
        });

        JButton btn_2     = crateButton("2", 50,  50);
        btn_2.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_2.getText());
        });

        JButton btn_3     = crateButton("3", 100, 50);
        btn_3.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_3.getText());
        });

        JButton btn_4     = crateButton("4", 0,   100);
        btn_4.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_4.getText());
        });

        JButton btn_5     = crateButton("5", 50,  100);
        btn_5.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_5.getText());
        });

        JButton btn_6     = crateButton("6", 100, 100);
        btn_6.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_6.getText());
        });

        JButton btn_7     = crateButton("7", 0,   150);
        btn_7.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_7.getText());
        });

        JButton btn_8     = crateButton("8", 50,  150);
        btn_8.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_8.getText());
        });

        JButton btn_9     = crateButton("9", 100, 150);
        btn_9.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_9.getText());
        });

        JButton btn_plus  = crateButton("+", 150, 50);
        btn_plus.addActionListener(e -> {
            num1 = display.getText();
            display.setText("");
            plus = true;
            minus = false;
            mult = false;
            div = false;
            point = 0;
        });

        JButton btn_minus = crateButton("-", 150, 100);
        btn_minus.addActionListener(e -> {
            num1 = display.getText();
            display.setText("");
            plus = false;
            minus = true;
            mult = false;
            div = false;
            point = 0;
        });

        JButton btn_multi = crateButton("x", 150, 150);
        btn_multi.addActionListener(e -> {
            num1 = display.getText();
            display.setText("");
            plus = false;
            minus = false;
            mult = true;
            div = false;
            point = 0;
        });

        JButton btn_point = crateButton(".", 0,   200);
        btn_point.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            if(point == 0) {
                point++;
                display.setText(display.getText() + btn_point.getText());
            }
        });

        JButton btn_0     = crateButton("0", 50,  200);
        btn_0.addActionListener(e -> {
            if (equal) {
                display.setText("");
                equal = false;
            }
            display.setText(display.getText() + btn_0.getText());
        });

        JButton btn_equal = crateButton("=", 100, 200);
        btn_equal.addActionListener(e -> {
            Calculator calc = new Calculator();
            num2 = display.getText();

            if(plus){
                result = calc.add(num1, num2);
            }
            else if(minus){
                result = calc.substract(num1, num2);
            }
            else if(mult){
                result = calc.multiply(num1, num2);
            }
            else if(div){
                result = calc.divide(num1, num2);
            }

            equal = true;
            point = 0;
            display.setText(result);

        });

        JButton btn_div   = crateButton("÷", 150, 200);
        btn_div.addActionListener(e -> {
            num1 = display.getText();
            display.setText("");
            plus = false;
            minus = false;
            mult = false;
            div = true;
        });

        // Add Buttons To The Main Frame
        calc_frame.add(btn_C);
        calc_frame.add(btn_4);
        calc_frame.add(btn_5);
        calc_frame.add(btn_6);
        calc_frame.add(btn_1);
        calc_frame.add(btn_2);
        calc_frame.add(btn_3);
        calc_frame.add(btn_7);
        calc_frame.add(btn_8);
        calc_frame.add(btn_9);
        calc_frame.add(btn_plus);
        calc_frame.add(btn_minus);
        calc_frame.add(btn_multi);
        calc_frame.add(btn_point);
        calc_frame.add(btn_0);
        calc_frame.add(btn_equal);
        calc_frame.add(btn_div);

        // Main Frame Configuration
        calc_frame.setSize(216, 288);
        calc_frame.setResizable(false);
        calc_frame.setLayout(null);
        calc_frame.setVisible(true);
        calc_frame.setLocationRelativeTo(null);
        calc_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static JButton crateButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 50, 50);
        btn.setBackground(Color.lightGray);
        btn.setBorder(BorderFactory.createLineBorder(Color.black));
        return btn;
    }
}
