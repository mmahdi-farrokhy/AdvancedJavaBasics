package Calculator;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CalculatorUI {
    public static void main(String args[]){

        // Main Frame
        JFrame calc_frame = new JFrame("Calculator");
        calc_frame.setSize(500, 500);
        calc_frame.setResizable(false);
        calc_frame.setLayout(null);
        calc_frame.setVisible(true);

        // Operator Buttons
        JButton[] calc_ops = calc_operators(50);
        for (int i=0; i<5; i++)
            calc_frame.add(calc_ops[i]);

        // Last Row Of Calculator Keyboard
        JButton[] calc_lr = calc_last_row(50);
        for (int i=0; i<3; i++)
            calc_frame.add(calc_lr[i]);

        // Text Field
        JTextField display = new JTextField();
        display.setBounds(0,0,150,50);
        calc_frame.add(display);
        display.setEnabled(true);
        display.setEditable(false);
        display.setBackground(Color.white);
        display.setBorder(BorderFactory.createLineBorder(Color.black));

        // Number Buttons
        JButton[][] calc_nums = calc_numbers_btn(50);
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                calc_frame.add(calc_nums[i][j]);
    }

    public static JButton[][] calc_numbers_btn(int size){
        JButton[][] numbers = new JButton[3][3];
        int index;
        String btn_txt;

        for (int i =0; i<3; i++)
            for (int j=0; j<3; j++)
            {
                index = (i*3) + (j+1);
                btn_txt = String.valueOf(index);
                int xPos = j*50;
                int yPos = (i+1)*50;
                numbers[i][j] = new JButton(btn_txt);
                numbers[i][j].setBounds(xPos,yPos,size,size);
                numbers[i][j].setBackground(Color.lightGray);
                numbers[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
            }

        return numbers;
    }

    public static JButton[] calc_operators(int size){
        JButton[] op = new JButton[5];
        String[] op_txt = {"C", "+", "-", "*", "/"};

        for (int i=0; i<5; i++) {
            int xPos = 150;
            int yPos = i*50;
            op[i] = new JButton(op_txt[i]);
            op[i].setBounds(xPos, yPos, size, size);
            op[i].setBackground(Color.lightGray);
            op[i].setBorder(BorderFactory.createLineBorder(Color.black));
        }

        return op;
    }


    public static JButton[] calc_last_row(int size){
        JButton[] lr = new JButton[3];
        String[] lr_txt = {".", "0", "="};

        for (int i=0; i<3; i++) {
            int xPos = i*50;
            int yPos = 200;
            lr[i] = new JButton(lr_txt[i]);
            lr[i].setBounds(xPos, yPos, size, size);
            lr[i].setBackground(Color.lightGray);
            lr[i].setBorder(BorderFactory.createLineBorder(Color.black));
        }

        return lr;
    }
}
