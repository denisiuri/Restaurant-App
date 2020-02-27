import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class Controller {
    private Restaurant m_restaurant;
    private GUI m_GUI;
    private Order m_order;
    private ArrayList<MenuItem> orderList = new ArrayList<>();
    private ArrayList<MenuItem> compositeProduct = new ArrayList<>();

    public Controller(Restaurant restaurant, GUI gui, Order order) {
        m_restaurant = restaurant;
        m_GUI = gui;
        m_order = order;

        gui.addCreateItemListener(new CreateItemListener());
        gui.deleteItemListener(new DeleteItemListener());
        gui.editItemListener(new EditItemListener());
        gui.createOrderListener(new CreateOrderListener());
        gui.addToOrderListener(new AddToOrderListener());
        gui.addCompositeListener(new AddCompositeListener());
        gui.compositeItemListener(new CompositeItemListener());
    }


    class CreateItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object[] row = new Object[2];
            String name = m_GUI.getMenuItemName().getText();
            float price = Float.parseFloat(m_GUI.getMenuItemPrice().getText());

            BaseProduct base = new BaseProduct(name, price);
            m_GUI.getMenuItemName().setText("");
            m_GUI.getMenuItemPrice().setText("");
            m_restaurant.getMenu().add(base);
            row[0] = name;
            row[1] = price;

            m_GUI.getModel().addRow(row);
            System.out.println(m_restaurant.getMenu());
        }
    }

    class DeleteItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i = m_GUI.getListOfMenuItems().getSelectedRow();
            if (i >= 0) {
                m_restaurant.getMenu().remove(i);
                m_GUI.getModel().removeRow(i);
                System.out.println(m_restaurant.getMenu());
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "The menu is empty !");
            }
        }
    }

    class EditItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i = m_GUI.getListOfMenuItems().getSelectedRow();
            if (i >= 0) {
                m_GUI.getModel().setValueAt(m_GUI.getMenuItemName().getText(), i, 0);
                m_GUI.getModel().setValueAt(m_GUI.getMenuItemPrice().getText(), i, 1);
            }
        }
    }

    class CompositeItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {

            String name = m_GUI.getMenuItemName().getText();

            float computePrice = 0;
            for(MenuItem it : compositeProduct)
            {
                computePrice = computePrice + it.getPrice();
            }
            CompositeProduct composite = new CompositeProduct(name, computePrice);

            Object[] row = new Object[2];
            m_GUI.getMenuItemName().setText("");
            m_GUI.getMenuItemPrice().setText("");
            m_restaurant.getMenu().add(composite);
            row[0] = name;
            row[1] = computePrice;

            m_GUI.getModel().addRow(row);

            compositeProduct = new ArrayList();

        }
    }

    class AddCompositeListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            int i = m_GUI.getListOfMenuItems().getSelectedRow();
            compositeProduct.add(m_restaurant.getMenu().get(i));
        }
    }

    class AddToOrderListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i = m_GUI.getListOfMenuItems2().getSelectedRow();
            orderList.add(m_restaurant.getMenu().get(i));
        }
    }

    class CreateOrderListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int orderID = Integer.parseInt(m_GUI.getOrderID().getText());
            String orderDate = m_GUI.getOrderDate().getText();
            int orderTable = Integer.parseInt(m_GUI.getOrderTable().getText());

            float computePrice = 0;
            for(MenuItem it : orderList)
            {
                computePrice = computePrice + it.getPrice();
            }
            Object[] row = new Object[4];
            row[0] = orderID;
            row[1] = orderDate;
            row[2] = orderTable;
            row[3] = computePrice;

            File file = new File("bill.txt");
            try {
                FileWriter fw = new FileWriter(file);
                PrintWriter pw = new PrintWriter(fw);

                pw.println("Order ID: " + orderID);
                pw.println("Order Date: " + orderDate);
                pw.println("Order Table: " + orderTable);

                pw.println("Name: " + "Price: ");
                for(MenuItem it :orderList)
                {
                    pw.println(it.getName() + " " + it.getPrice());
                }

                pw.println("Total: " + computePrice);

                pw.close();

            }catch(IOException ex)
            {
                ex.printStackTrace();
            }


            m_GUI.getModel2().addRow(row);
            m_order = new Order(orderID, orderDate, orderTable);
            m_restaurant.getHashMap().put(m_order, orderList);
            System.out.println(m_restaurant.getHashMap());

            orderList = new ArrayList<>();
        }
    }

}
