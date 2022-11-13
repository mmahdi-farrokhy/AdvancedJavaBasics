package shop;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ShoppingListUI {

    // Pictures Decleration
    public static final String FRAME_BG_PATH = "E:/User/work/MASTER DIAG/M.Mahdi Farrokhy/AdvancedJavaBasics/src/main//resources/frame_bg.jpg";
    public static final String SAVE_BG_PATH = "E:/User/work/MASTER DIAG/M.Mahdi Farrokhy/AdvancedJavaBasics/src/main//resources/save_bg.png";
    public static final String SEARCH_BG_PATH = "E:/User/work/MASTER DIAG/M.Mahdi Farrokhy/AdvancedJavaBasics/src/main//resources/search_bg.png";

    // Main Frame Properties
    public static final int FRAME_WIDTH = 405;
    public static final int FRAME_HEIGHT = 500;

    // Save Button Properties
    public static final int SAVE_BUTTON_X = 40;
    public static final int SAVE_BUTTON_Y = 10;
    public static final int SAVE_BUTTON_SIZE = 45;

    // Search Button Properties
    public static final int SEARCH_BUTTON_X = 120;
    public static final int SEARCH_BUTTON_Y = 10;
    public static final int SEARCH_BUTTON_SIZE = 45;

    // Name Text Field Properties
    public static final int NAME_FIELD_X = 40;
    public static final int NAME_FIELD_Y = 85;
    public static final int NAME_FIELD_W = 250;
    public static final int NAME_FIELD_H = 50;

    // Quantity Text Field Properties
    public static final int QUANTITY_FIELD_X = 300;
    public static final int QUANTITY_FIELD_Y = 85;
    public static final int QUANTITY_FIELD_W = 50;
    public static final int QUANTITY_FIELD_H = 50;
    public static final Color BORDER_COLOR = Color.DARK_GRAY;
    static JFrame list_frame = new JFrame("Shopping List");

    public static void main(String[] args){
        // Items Name Text Box
        JTextField itemName1 = newTextField(NAME_FIELD_X, NAME_FIELD_Y, NAME_FIELD_W, NAME_FIELD_H);
        JTextField itemName2 = newTextField(NAME_FIELD_X, NAME_FIELD_Y + 56 , NAME_FIELD_W, NAME_FIELD_H);
        JTextField itemName3 = newTextField(NAME_FIELD_X, NAME_FIELD_Y + 112, NAME_FIELD_W, NAME_FIELD_H);
        JTextField itemName4 = newTextField(NAME_FIELD_X, NAME_FIELD_Y + 168, NAME_FIELD_W, NAME_FIELD_H);
        JTextField itemName5 = newTextField(NAME_FIELD_X, NAME_FIELD_Y + 224, NAME_FIELD_W, NAME_FIELD_H);
        // Items Quantity Text Box
        JTextField itemQuantity1 = newTextField(QUANTITY_FIELD_X, QUANTITY_FIELD_Y, QUANTITY_FIELD_W, QUANTITY_FIELD_H);
        JTextField itemQuantity2 = newTextField(QUANTITY_FIELD_X, QUANTITY_FIELD_Y + 56 , QUANTITY_FIELD_W, QUANTITY_FIELD_H);
        JTextField itemQuantity3 = newTextField(QUANTITY_FIELD_X, QUANTITY_FIELD_Y + 112, QUANTITY_FIELD_W, QUANTITY_FIELD_H);
        JTextField itemQuantity4 = newTextField(QUANTITY_FIELD_X, QUANTITY_FIELD_Y + 168, QUANTITY_FIELD_W, QUANTITY_FIELD_H);
        JTextField itemQuantity5 = newTextField(QUANTITY_FIELD_X, QUANTITY_FIELD_Y + 224, QUANTITY_FIELD_W, QUANTITY_FIELD_H);

        // Name Text Field Configuration
        itemName1.setHorizontalAlignment(SwingConstants.CENTER);
        itemName2.setHorizontalAlignment(SwingConstants.CENTER);
        itemName3.setHorizontalAlignment(SwingConstants.CENTER);
        itemName4.setHorizontalAlignment(SwingConstants.CENTER);
        itemName5.setHorizontalAlignment(SwingConstants.CENTER);
        // Quantity Text Field Configuration
        itemQuantity1.setHorizontalAlignment(SwingConstants.CENTER);
        itemQuantity2.setHorizontalAlignment(SwingConstants.CENTER);
        itemQuantity3.setHorizontalAlignment(SwingConstants.CENTER);
        itemQuantity4.setHorizontalAlignment(SwingConstants.CENTER);
        itemQuantity5.setHorizontalAlignment(SwingConstants.CENTER);


        // Save Button
        JButton save = newButton(SAVE_BUTTON_X, SAVE_BUTTON_Y, SAVE_BUTTON_SIZE, "+");
        JLabel saveBG = setBackground(SAVE_BG_PATH, SAVE_BUTTON_X, SAVE_BUTTON_Y, SAVE_BUTTON_SIZE, SAVE_BUTTON_SIZE);
        save.add(saveBG);
        save.addActionListener(e -> saveItems());

        // Search Button
        JButton search = newButton(SEARCH_BUTTON_X, SEARCH_BUTTON_Y, SEARCH_BUTTON_SIZE, "O");
        JLabel searchBG = setBackground(SEARCH_BG_PATH, SEARCH_BUTTON_X, SEARCH_BUTTON_Y, SEARCH_BUTTON_SIZE, SEARCH_BUTTON_SIZE);
        search.add(searchBG);
        search.addActionListener(e -> findAllItems());

        // Background Image Of Main Frame
        JLabel backGround = setBackground(FRAME_BG_PATH, 0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        // Add Panel To The Main Frame
        list_frame.add(save);
        list_frame.add(search);
        list_frame.add(itemName1);
        list_frame.add(itemName2);
        list_frame.add(itemName3);
        list_frame.add(itemName4);
        list_frame.add(itemName5);
        list_frame.add(itemQuantity1);
        list_frame.add(itemQuantity2);
        list_frame.add(itemQuantity3);
        list_frame.add(itemQuantity4);
        list_frame.add(itemQuantity5);
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
        button.setBackground(Color.decode("#e9dfde"));
        button.setBorder((BorderFactory.createLineBorder(Color.decode("#e9dfde"))));
        return button;
    }
    public static void saveItems(){

        JOptionPane.showMessageDialog(list_frame, "List Saved In Database!");
    }
    private static void findAllItems() {
        JOptionPane.showMessageDialog(list_frame, "Search Finished!");
    }
    public static JTextField newTextField(int x, int y, int width, int height){
        JTextField itemName = new JTextField();
        itemName.setBounds(x, y, width, height);
        itemName.setEnabled(true);
        itemName.setEditable(true);
        itemName.setBackground(Color.white);
        itemName.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
        return itemName;
    }
    public static JLabel setBackground(String path, int x, int y ,int width, int height){
        JLabel bg;
        ImageIcon img = new ImageIcon(path);
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(x, y, width, height);
        return bg;
    }
}