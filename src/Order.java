import java.util.ArrayList;

public class Order {
    private int orderID;
    private String date;
    private int table;
    private ArrayList<MenuItem> orderList = new ArrayList<>();

    public Order() {

    }

    public Order(int orderID, String date, int table) {
        this.orderID = orderID;
        this.date = date;
        this.table = table;
    }

    public ArrayList<MenuItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<MenuItem> orderList) {
        this.orderList = orderList;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass())
            return false;
        Order order = (Order) o;
        return orderID == order.orderID && (date.equals(order.date)) && table == order.table;

    }

    @Override
    public int hashCode() {
        int result = (int) (orderID ^ (orderID >>> 32));
        result = 31 * result + date.hashCode();
        result = 31 * result + table;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                '}';
    }
}
