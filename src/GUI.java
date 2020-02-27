import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JFrame administratorPanel = new JFrame();
    private JFrame waiterPanel = new JFrame();
    private JFrame ordersFrame = new JFrame();
    private JButton buttonAdministrator = new JButton("Administrator");
    private JButton buttonWaiter = new JButton("Waiter");
    private JTextField menuItemName = new JTextField();
    private JTextField menuItemPrice = new JTextField();
    private JButton createButton = new JButton("Create");
    private JButton deleteButton = new JButton("Delete");
    private JButton editButton = new JButton("Edit");
    private JButton compositeButton = new JButton("Composite");
    private JButton addComposite = new JButton("Add");
    private JButton backButton = new JButton("Back");
    private JButton backOrderButton = new JButton("Back");
    private JButton viewOrders = new JButton("Orders");
    private JButton addToOrder = new JButton("Add");
    private JTable listOfMenuItems = new JTable();
    private JTable listOfMenuItems2 = new JTable();
    private JTable listOfOrders = new JTable();
    private JLabel labelName = new JLabel("Name");
    private JLabel labelPrice = new JLabel("Price");
    private JLabel labelID = new JLabel("Order ID");
    private JLabel labelDate = new JLabel("Order Date");
    private JLabel labelTable = new JLabel("Order table");
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel model2 = new DefaultTableModel();
    private JTextField orderID = new JTextField();
    private JTextField orderDate = new JTextField();
    private JTextField orderTable = new JTextField();

    private JButton createOrderButton = new JButton("Create");

    public JTable getListOfMenuItems() {
        return listOfMenuItems;
    }

    public JTable getListOfMenuItems2() {
        return listOfMenuItems2;
    }

    public JTextField getOrderID() {
        return orderID;
    }

    public JTextField getOrderDate() {
        return orderDate;
    }


    public JTextField getOrderTable() {
        return orderTable;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTextField getMenuItemName() {
        return menuItemName;
    }

    public JTextField getMenuItemPrice() {
        return menuItemPrice;
    }

    public JTable getListOfOrders() {
        return listOfOrders;
    }

    public DefaultTableModel getModel2() {
        return model2;
    }

    public JButton getCompositeButton() {
        return compositeButton;
    }

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainPanel);
        mainPanel.setLayout(null);
        administratorPanel.setVisible(false);
        waiterPanel.setVisible(false);
        ordersFrame.setVisible(false);


        //Main
        buttonAdministrator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                administratorPanel.setVisible(true);

            }
        });

        buttonWaiter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                waiterPanel.setVisible(true);

            }
        });

        buttonAdministrator.setBounds(151, 64, 118, 25);
        mainPanel.add(buttonAdministrator);

        buttonWaiter.setBounds(151, 125, 118, 25);
        mainPanel.add(buttonWaiter);

        //Tabel model - Administrator % Waiter
        Object[] columns = {"Name", "Price"};

        model.setColumnIdentifiers(columns);

        listOfMenuItems.setModel(model);

        listOfMenuItems.setBackground(Color.LIGHT_GRAY);
        listOfMenuItems.setForeground(Color.black);
        listOfMenuItems.setRowHeight(30);

        //Administrator
        menuItemName.setBounds(400, 230, 100, 25);
        menuItemPrice.setBounds(400, 270, 100, 25);

        createButton.setBounds(150, 220, 100, 25);
        deleteButton.setBounds(150, 265, 100, 25);
        editButton.setBounds(150, 310, 100, 25);

        labelName.setBounds(350, 230, 100, 25);
        labelPrice.setBounds(350, 270, 100, 25);

        administratorPanel.add(labelName);
        administratorPanel.add(labelPrice);


        backButton.setBounds(600, 220, 100, 25);
        compositeButton.setBounds(600, 265, 100, 25);
        addComposite.setBounds(600, 310, 100, 25);
        administratorPanel.add(backButton);
        administratorPanel.add(compositeButton);
        administratorPanel.add(addComposite);

        JScrollPane scrollPane = new JScrollPane(listOfMenuItems);
        scrollPane.setBounds(0, 0, 880, 200);

        administratorPanel.setLayout(null);
        administratorPanel.add(scrollPane);

        administratorPanel.add(menuItemName);
        administratorPanel.add(menuItemPrice);

        administratorPanel.add(createButton);
        administratorPanel.add(deleteButton);
        administratorPanel.add(editButton);

        administratorPanel.setSize(900, 400);
        administratorPanel.setLocationRelativeTo(null);
        administratorPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorPanel.setVisible(false);
                mainPanel.setVisible(true);
            }
        });

        //Waiter
        waiterPanel.setSize(900, 400);
        waiterPanel.setLocationRelativeTo(null);
        waiterPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listOfMenuItems2.setModel(listOfMenuItems.getModel());

        listOfMenuItems2.setBackground(Color.LIGHT_GRAY);
        listOfMenuItems2.setForeground(Color.black);
        listOfMenuItems2.setRowHeight(30);

        JScrollPane scrollPane2 = new JScrollPane(listOfMenuItems2);
        scrollPane2.setBounds(0, 0, 880, 200);

        createOrderButton.setBounds(550, 220, 100, 25);
        addToOrder.setBounds(550, 265, 100, 25);
        viewOrders.setBounds(550, 310, 100, 25);
        viewOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                waiterPanel.setVisible(false);
                ordersFrame.setVisible(true);
            }
        });
        waiterPanel.add(createOrderButton);
        waiterPanel.add(addToOrder);
        waiterPanel.add(viewOrders);

        orderID.setBounds(380, 220, 100, 25);
        orderDate.setBounds(380, 250, 100, 25);
        orderTable.setBounds(380, 280, 100, 25);

        labelID.setBounds(250, 220, 100, 25);
        labelDate.setBounds(250, 250, 100, 25);
        labelPrice.setBounds(250, 280, 100, 25);

        waiterPanel.add(labelID);
        waiterPanel.add(labelDate);
        waiterPanel.add(labelPrice);

        waiterPanel.add(orderID);
        waiterPanel.add(orderDate);
        waiterPanel.add(orderTable);
        waiterPanel.add(scrollPane2);
        this.setVisible(true);

        //Orders
        ordersFrame.setSize(900, 400);
        ordersFrame.setLocationRelativeTo(null);
        ordersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[] columns2 = {"Order", "Date", "Table", "Price"};

        model2.setColumnIdentifiers(columns2);

        listOfOrders.setModel(model2);

        listOfOrders.setBackground(Color.LIGHT_GRAY);
        listOfOrders.setForeground(Color.black);
        listOfOrders.setRowHeight(30);

        JScrollPane scrollPane3 = new JScrollPane(listOfOrders);
        scrollPane3.setBounds(0, 0, 880, 200);

        ordersFrame.setLayout(null);
        ordersFrame.add(scrollPane3);

        backOrderButton.setBounds(400, 240, 100, 25);
        ordersFrame.add(backOrderButton);

        backOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordersFrame.setVisible(false);
                waiterPanel.setVisible(true);
            }
        });
    }

    void addCreateItemListener(ActionListener cal) {
        createButton.addActionListener(cal);
    }

    void deleteItemListener(ActionListener dal) {
        deleteButton.addActionListener(dal);
    }

    void editItemListener(ActionListener eal) {
        editButton.addActionListener(eal);
    }

    void compositeItemListener(ActionListener cal) {
        compositeButton.addActionListener(cal);
    }

    void addCompositeListener(ActionListener aal) {
        addComposite.addActionListener(aal);
    }

    void createOrderListener(ActionListener cal) {
        createOrderButton.addActionListener(cal);
    }

    void addToOrderListener(ActionListener oal) {
        addToOrder.addActionListener(oal);
    }


}
