package Calculator;
import javax.swing.*;
import java.awt.*;

public class CalculatorUI {
    public static void main(String args[]){

        // Main Frame
        JFrame calc_frame = new JFrame("Calculator");
        calc_frame.setSize(500, 500);
        calc_frame.setResizable(false);
        calc_frame.setLayout(null);
        calc_frame.setVisible(true);
        calc_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text Field
        JTextField display = new JTextField();
        display.setBounds(0,0,150,50);
        calc_frame.add(display);
        display.setEnabled(true);
        display.setEditable(false);
        display.setBackground(Color.white);
        display.setBorder(BorderFactory.createLineBorder(Color.black));

        // Cancel Button
        JButton btn_C     = crateButton("C", 150, 0);
        JButton btn_1     = crateButton("1", 0,   50);
        JButton btn_2     = crateButton("2", 50,  50);
        JButton btn_3     = crateButton("3", 100, 50);
        JButton btn_4     = crateButton("4", 0,   100);
        JButton btn_5     = crateButton("5", 50,  100);
        JButton btn_6     = crateButton("6", 100, 100);
        JButton btn_7     = crateButton("7", 0,   150);
        JButton btn_8     = crateButton("8", 50,  150);
        JButton btn_9     = crateButton("9", 100, 150);
        JButton btn_plus  = crateButton("+", 150, 50);
        JButton btn_minus = crateButton("+", 150, 100);
        JButton btn_multi = crateButton("x", 150, 150);
        JButton btn_point = crateButton(".", 0,   200);
        JButton btn_0     = crateButton("0", 50,  200);
        JButton btn_equal = crateButton("=", 100, 200);
        JButton btn_div   = crateButton("/", 150, 200);

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
    }

    private static JButton crateButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 50, 50);
        btn.setBackground(Color.lightGray);
        btn.setBorder(BorderFactory.createLineBorder(Color.black));
        return btn;
    }
}
