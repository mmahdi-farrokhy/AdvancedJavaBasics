package shop;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

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
    public static final int NAME_FIELD_Y = 100;
    public static final int NAME_FIELD_W = 250;
    public static final int NAME_FIELD_H = 50;

    // Quantity Text Field Properties
    public static final int QUANTITY_FIELD_X = 300;
    public static final int QUANTITY_FIELD_Y = 100;
    public static final int QUANTITY_FIELD_W = 50;
    public static final int QUANTITY_FIELD_H = 50;
    public static final int LABEL_Y = 80;
    public static final int LABEL_H = 15;
    static JFrame list_frame = new JFrame("Shopping List");

    // Shopping List Objects
    private static ShoppingListService shoppingList;
    private static List<Item> itemList = new LinkedList<>();

    public static final int ITEMS_NUM = 5;
    // Items Name Text Box
    static JTextField[] itemNames = new JTextField[ITEMS_NUM];

    // Items Quantity Text Box
    static JTextField[] itemQuantities = new JTextField[ITEMS_NUM];

    public static void main(String[] args){
        shoppingList = new ShoppingListServiceImpl(new ShoppingListDAOImpl());

        for (int i=0; i<ITEMS_NUM; i++){
            itemNames[i] = newTextField(NAME_FIELD_X, NAME_FIELD_Y + (56*i), NAME_FIELD_W, NAME_FIELD_H);
            itemNames[i].setHorizontalAlignment(SwingConstants.CENTER);
            itemQuantities[i] = newTextField(QUANTITY_FIELD_X, QUANTITY_FIELD_Y + (56*i), QUANTITY_FIELD_W, QUANTITY_FIELD_H);
            itemQuantities[i].setHorizontalAlignment(SwingConstants.CENTER);
        }

        // Label Above Text Fields
        newLabel("Name", 145, LABEL_Y, 50, LABEL_H);
        newLabel("Quantity", 295, LABEL_Y,60, LABEL_H );

        // Save Button
        JButton save = newButton(SAVE_BUTTON_X, SAVE_BUTTON_Y, SAVE_BUTTON_SIZE, "+");
        JLabel saveBG = setBackground(SAVE_BG_PATH, SAVE_BUTTON_X, SAVE_BUTTON_Y, SAVE_BUTTON_SIZE, SAVE_BUTTON_SIZE);
        save.add(saveBG);
        save.addActionListener(e -> saveItems());
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                save.setBorder((BorderFactory.createLineBorder(Color.decode("#6a6267"))));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                save.setBorder((BorderFactory.createLineBorder(Color.decode("#e9dfde"))));
            }
        });

        // Search Button
        JButton search = newButton(SEARCH_BUTTON_X, SEARCH_BUTTON_Y, SEARCH_BUTTON_SIZE, "O");
        JLabel searchBG = setBackground(SEARCH_BG_PATH, SEARCH_BUTTON_X, SEARCH_BUTTON_Y, SEARCH_BUTTON_SIZE, SEARCH_BUTTON_SIZE);
        search.add(searchBG);
        search.addActionListener(e -> findAllItems());
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                search.setBorder((BorderFactory.createLineBorder(Color.decode("#6a6267"))));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                search.setBorder((BorderFactory.createLineBorder(Color.decode("#e9dfde"))));
            }
        });

        // Background Image Of Main Frame
        JLabel backGround = setBackground(FRAME_BG_PATH, 0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        // Add Panel To The Main Frame
        list_frame.add(save);
        list_frame.add(search);
        for (int i=0; i<ITEMS_NUM; i++) {
            list_frame.add(itemNames[i]);
            list_frame.add(itemQuantities[i]);
        }
        list_frame.add(backGround);

        // Main Frame Configuration
        list_frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        list_frame.setResizable(false);
        list_frame.setLayout(null);
        list_frame.setVisible(true);
        list_frame.setLocationRelativeTo(null);
        list_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void newLabel(String Name, int x, int y, int width,  int height) {
        JLabel nameLabel = new JLabel(Name);
        nameLabel.setBounds(x,y, width,height);
        nameLabel.setFont(new Font("Times New Romance", Font.BOLD, 14));
        list_frame.add(nameLabel);
    }
    public static JButton newButton(int x, int y, int size, String text){
        JButton button = new JButton(text);
        button.setBounds(x, y, size, size);
        button.setBackground(Color.decode("#e9dfde"));
        button.setBorder((BorderFactory.createLineBorder(Color.decode("#e9dfde"))));
        return button;
    }
    public static JTextField newTextField(int x, int y, int width, int height){
        JTextField itemName = new JTextField();
        itemName.setBounds(x, y, width, height);
        itemName.setEnabled(true);
        itemName.setEditable(true);
        itemName.setBackground(Color.white);
        itemName.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        return itemName;
    }
    public static JLabel setBackground(String path, int x, int y ,int width, int height){
        JLabel bg;
        ImageIcon img = new ImageIcon(path);
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(x, y, width, height);
        return bg;
    }
    public static boolean emptyList(){
        int emptyCount = 0;

        for (int i=0; i<ITEMS_NUM; i++)
            if(emptyItemNameOrQuantity(itemNames[i], itemQuantities[i]) == -2)
                emptyCount++;

        if (emptyCount == ITEMS_NUM)
            return true;
        else
            return false;
    }
    public static int emptyItemNameOrQuantity(JTextField nameField, JTextField quantityField){
        String name = nameField.getText();
        String quantity = quantityField.getText();

        if((name == null || name.isEmpty()) && (quantity == null || quantity.isEmpty()))
            return -2;
        if((name == null || name.isEmpty()) && (quantity != null || !(quantity.isEmpty())))
            return -1;
        else if((name != null || !(name.isEmpty())) && (quantity == null || quantity.isEmpty()))
            return 0;
        else
            return 1;
    }
    public static boolean saveItems() {
        boolean[] isAdded = new boolean[ITEMS_NUM];
        String[] names = new String[ITEMS_NUM];
        String[] quantities = new String[ITEMS_NUM];

        shoppingList.clearList();

        // Read Items Names And Quantities
        for (int i = 0; i < ITEMS_NUM; i++) {
            names[i] = itemNames[i].getText();
            quantities[i] = itemQuantities[i].getText();
        }

        // Check The Items Names And Quantities And Add To List If Allowed
        if (emptyList()){
            JOptionPane.showMessageDialog(list_frame, "List Is Empty!\nPlease Insert At Least 1 Name & Quantity");
            return false;
        }
        else {
            for (int i = 0; i < ITEMS_NUM; i++) {
                if (emptyItemNameOrQuantity(itemNames[i], itemQuantities[i]) == -1){
                    JOptionPane.showMessageDialog(list_frame, "Item " + (i + 1) + " Name Is Empty!");
                    return false;
                }
                else if (emptyItemNameOrQuantity(itemNames[i], itemQuantities[i]) == 0){
                    JOptionPane.showMessageDialog(list_frame, "Item " + (i + 1) + " Quantity Is Empty!");
                    return false;
                }
                else if (emptyItemNameOrQuantity(itemNames[i], itemQuantities[i]) == 1) {
                    itemList.add(new Item(names[i], Integer.parseInt(quantities[i])));
                    isAdded[i] = true;
                }
            }
        }

        shoppingList.saveItems(itemList);
        JOptionPane.showMessageDialog(list_frame, "List Saved In Database!");

        for (int i=0; i<ITEMS_NUM; i++)
            if (isAdded[i])
                JOptionPane.showMessageDialog(list_frame, names[i] + " - " + quantities[i]);

        return true;
    }
    private static boolean findAllItems() {
        int numOfRecords = shoppingList.countRecords();
        if (numOfRecords == 0){
            JOptionPane.showMessageDialog(list_frame, "No List Is Saved");
            return false;
        }

        List<Item> items = shoppingList.findAllItems();
        String[] names = new String[numOfRecords];
        int[] quantities = new int[numOfRecords];
        String[] message = new String[(numOfRecords/8)+1];
        int i =0;

        for (int y=0; y<message.length; y++)
            message[y] = new String("");

        for (Item item : items) {
            names[i] = item.getName();
            quantities[i] = item.getQuantity();
            i++;
        }

        for (int j=0; j<numOfRecords; j++) {
            message[j/8] += "Item " + (j+1) + ":\n" +
                            "Name: " + names[j] + ",\n" +
                            "Quantity: " + quantities[j] +
                            "\n __________________\n";
            }

        JOptionPane.showMessageDialog(list_frame, message[0]);
        for (int l=1; l<message.length; l++)
            if (message[l] !=null || !(message[l].isEmpty()))
                JOptionPane.showMessageDialog(list_frame, message[l]);

        JOptionPane.showMessageDialog(list_frame, "Search Finished!");

        return true;
    }
}