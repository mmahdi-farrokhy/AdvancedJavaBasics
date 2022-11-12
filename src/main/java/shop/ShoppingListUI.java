package shop;

import javax.swing.*;
import java.awt.*;

public class ShoppingListUI {

    public static final String FRAME_BG_PATH = "E:/Learning/Java - 7Learn/AdvancedJavaBasics/src/main/resources/frame_bg.jpg";
    public static final String BUTTON_BG_PATH = "E:/Learning/Java - 7Learn/AdvancedJavaBasics/src/main/resources/plus_bg.png";
    public static final int FRAME_WIDTH = 405;
    public static final int FRAME_HEIGHT = 600;
    public static final int BUTTON_SIZE = 50;
    public static final int BUTTON_X = 320;
    public static final int BUTTON_Y = 25;

    public static void main(String args[]){
        JFrame list_frame = new JFrame("Shpping List");
        JButton plus = newButton(BUTTON_X, BUTTON_Y, BUTTON_SIZE, "+");
        JLabel plusBG = setBackground(BUTTON_BG_PATH, BUTTON_X, BUTTON_Y, BUTTON_SIZE, BUTTON_SIZE);
        plus.add(plusBG);

        // Add Elements To The MAin Frame
        list_frame.add(plus);
        JLabel backGround = setBackground(FRAME_BG_PATH, 0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        list_frame.add(backGround);

        // Main Frame Configuration
        list_frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        list_frame.setResizable(false);
        list_frame.setLayout(null);
        list_frame.setVisible(true);
        list_frame.setLocationRelativeTo(null);
        list_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JButton newButton(int x, int y, int size, String text){
        JButton button = new JButton(text);
        button.setBounds(x, y, size, size);
        button.setBorder(BorderFactory.createLineBorder(Color.white));
        return button;
    }

    public static JLabel setBackground(String path, int x, int y ,int width, int height){
        JLabel bg;
        ImageIcon img = new ImageIcon(path);
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(x, y, width, height);
        return bg;
    }
}
