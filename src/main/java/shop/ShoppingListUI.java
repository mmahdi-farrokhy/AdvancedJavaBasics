package shop;

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
    public static final String EMAIL_BG_PATH = "E:/User/work/MASTER DIAG/M.Mahdi Farrokhy/AdvancedJavaBasics/src/main//resources/email_bg.png";
    public static final String PDF_BG_PATH = "E:/User/work/MASTER DIAG/M.Mahdi Farrokhy/AdvancedJavaBasics/src/main//resources/pdf_bg.png";

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

    // E-Mail Button Properties
    private static final int EMAIL_BUTTON_X = 200;
    public static final int EMAIL_BUTTON_Y = 10;
    public static final int EMAIL_BUTTON_SIZE = 45;

    // PDF Button Properties
    private static final int PDF_BUTTON_X = 280;
    public static final int PDF_BUTTON_Y = 10;
    public static final int PDF_BUTTON_SIZE = 45;


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
    private static EmailService emailService;
    private static PDFService pdfService;
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
            itemQuantities[i] = newTextField(QUANTITY_FIELD_X, QUANTITY_FIELD_Y + (56*i), QUANTITY_FIELD_W, QUANTITY_FIELD_H);
        }

        // Labels Above Text Fields
        newLabel("Name", 145, LABEL_Y, 70, LABEL_H);
        newLabel("Quantity", 295, LABEL_Y,60, LABEL_H );

        // Save To Database Button
        JButton save = newButton(SAVE_BUTTON_X, SAVE_BUTTON_Y, SAVE_BUTTON_SIZE, "Save");
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
        JButton search = newButton(SEARCH_BUTTON_X, SEARCH_BUTTON_Y, SEARCH_BUTTON_SIZE, "Search");
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
                search.setBorder((BorderFactory.createLineBorder(Color.decode("#ffffff"))));
            }
        });

        // Send E-Mail Button
        JButton email = newButton(EMAIL_BUTTON_X, EMAIL_BUTTON_Y, EMAIL_BUTTON_SIZE, "E-Mail");
        JLabel emailBG = setBackground(EMAIL_BG_PATH, EMAIL_BUTTON_X, EMAIL_BUTTON_Y, EMAIL_BUTTON_SIZE, EMAIL_BUTTON_SIZE);
        email.add(emailBG);
        email.addActionListener(e -> sendEmail());
        email.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                email.setBorder((BorderFactory.createLineBorder(Color.decode("#6a6267"))));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                email.setBorder((BorderFactory.createLineBorder(Color.decode("#ffffff"))));
            }
        });

        // Save To PDF Button
        JButton pdf = newButton(PDF_BUTTON_X, PDF_BUTTON_Y, PDF_BUTTON_SIZE, ".PDF");
        JLabel pdfBG = setBackground(PDF_BG_PATH, PDF_BUTTON_X, PDF_BUTTON_Y, PDF_BUTTON_SIZE, PDF_BUTTON_SIZE);
        pdf.add(pdfBG);
        pdf.addActionListener(e -> saveToPDF());
        pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pdf.setBorder((BorderFactory.createLineBorder(Color.decode("#6a6267"))));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pdf.setBorder((BorderFactory.createLineBorder(Color.decode("#ffffff"))));
            }
        });

        // Background Image Of Main Frame
        JLabel backGround = setBackground(FRAME_BG_PATH, 0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        // Add Panel To The Main Frame
        list_frame.add(save);
        list_frame.add(search);
        list_frame.add(email);
        list_frame.add(pdf);
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

    private static void saveToPDF() {
        // This Method Should Save The List To A PDF File

    }

    private static boolean sendEmail() {
        String from = "";
        String to = "";
        String emailText = "";
        String emailPassword = "";
        emailService = new EmailServiceImpl("Shopping List");

        from = (String)JOptionPane.showInputDialog(list_frame, "Please Enter Your E-Mail", "Your E-Mail", JOptionPane.OK_CANCEL_OPTION);
        if (from == null || from.isEmpty()) {
            JOptionPane.showMessageDialog(list_frame, "Enter Your E-Mail Correctly", "Invalid E-Mail!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        emailPassword = (String)JOptionPane.showInputDialog(list_frame, "Please Enter Your E-Mail Password", "Recipient E-Mail", JOptionPane.OK_CANCEL_OPTION);
        if (emailPassword == null || emailPassword.isEmpty()) {
            JOptionPane.showMessageDialog(list_frame, "Enter Your Password", "Invalid Password!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        to = (String)JOptionPane.showInputDialog(list_frame, "Please Enter Recipient E-Mail", "Recipient E-Mail", JOptionPane.OK_CANCEL_OPTION);
        if (to == null || to.isEmpty()) {
            JOptionPane.showMessageDialog(list_frame, "Enter Recipient E-Mail", "Invalid E-Mail!", JOptionPane.ERROR_MESSAGE);
            return false;
        }


        emailText = "Testing Function";

        emailService.sendEmail(from, emailPassword,to, emailText);
        JOptionPane.showMessageDialog(list_frame, "E-Mail Sent!");
        return true;
    }
//
//    private static void getEmailForm(){
//        JFrame emailFrame = new JFrame();
//        emailFrame.setSize(300, 300);
//        emailFrame.setResizable(false);
//        emailFrame.setLayout(null);
//        emailFrame.setVisible(true);
//        emailFrame.setLocationRelativeTo(null);
//        list_frame.add(emailFrame);
//    }

    private static void newLabel(String Name, int x, int y, int width,  int height) {
        JLabel nameLabel = new JLabel(Name);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setBounds(x,y, width,height);
        nameLabel.setForeground(Color.black); //
        nameLabel.setBackground(Color.decode("#ffdfdf"));
        nameLabel.setOpaque(true);
        nameLabel.setFont(new Font("Times New Romance", Font.BOLD, 14));
        list_frame.add(nameLabel);
    }

    private static JButton newButton(int x, int y, int size, String text){
        JButton button = new JButton(text);
        button.setBounds(x, y, size, size);
        button.setBackground(Color.decode("#ffffff"));
        button.setBorder((BorderFactory.createLineBorder(Color.decode("#ffffff"))));
        return button;
    }
    private static JTextField newTextField(int x, int y, int width, int height){
        JTextField itemField = new JTextField();
        itemField.setBounds(x, y, width, height);
        itemField.setEnabled(true);
        itemField.setEditable(true);
        itemField.setBackground(Color.white);
        itemField.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        itemField.setHorizontalAlignment(SwingConstants.CENTER);
        return itemField;
    }
    private static JLabel setBackground(String path, int x, int y ,int width, int height){
        JLabel bg;
        ImageIcon img = new ImageIcon(path);
        bg = new JLabel("", img, JLabel.CENTER);
        bg.setBounds(x, y, width, height);
        return bg;
    }
    private static boolean emptyList(){
        int emptyCount = 0;

        for (int i=0; i<ITEMS_NUM; i++)
            if(emptyItemNameOrQuantity(itemNames[i], itemQuantities[i]) == -2)
                emptyCount++;

        if (emptyCount == ITEMS_NUM)
            return true;
        else
            return false;
    }
    private static int emptyItemNameOrQuantity(JTextField nameField, JTextField quantityField){
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
    private static boolean saveItems() {
        shoppingList.clearList();

        boolean[] isAdded = new boolean[ITEMS_NUM];
        String[] names = new String[ITEMS_NUM];
        String[] quantities = new String[ITEMS_NUM];

        // Read Items Names And Quantities
        for (int i = 0; i < ITEMS_NUM; i++) {
            names[i] = itemNames[i].getText();
            quantities[i] = itemQuantities[i].getText();
        }

        // Check The Items Names And Quantities And Add To List If Allowed
        if (emptyList()){
            JOptionPane.showMessageDialog(list_frame, "List Is Empty!\nPlease Insert At Least 1 Name & Quantity",  "Inane warning", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else {
            for (int i = 0; i < ITEMS_NUM; i++) {
                if (emptyItemNameOrQuantity(itemNames[i], itemQuantities[i]) == -1){
                    JOptionPane.showMessageDialog(list_frame, "Item " + (i + 1) + " Name Is Empty!",  "Inane warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                else if (emptyItemNameOrQuantity(itemNames[i], itemQuantities[i]) == 0){
                    JOptionPane.showMessageDialog(list_frame, "Item " + (i + 1) + " Quantity Is Empty!",  "Inane warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                else if (emptyItemNameOrQuantity(itemNames[i], itemQuantities[i]) == 1) {
                    itemList.add(new Item(names[i], Integer.parseInt(quantities[i])));
                    isAdded[i] = true;
                }
            }
        }

        int result = JOptionPane.showConfirmDialog((Component) null, "Are You Sure You Want To Save The List?", "alert", JOptionPane.YES_NO_OPTION);
        if (result == 0){
            shoppingList.saveItems(itemList);
            JOptionPane.showMessageDialog(list_frame, "List Saved In Database!");
            for (int i=0; i<ITEMS_NUM; i++)
                if (isAdded[i])
                    JOptionPane.showMessageDialog(list_frame, names[i] + " - " + quantities[i]);
            return true;
        }
        else
            return false;
    }
    private static boolean findAllItems() {
        int numOfRecords = shoppingList.countRecords();
        if (numOfRecords == 0){
            JOptionPane.showMessageDialog(list_frame, "No List Is Saved",  "Inane warning", JOptionPane.ERROR_MESSAGE);

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