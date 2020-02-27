public interface RestaurantProcessing {
    public void createMenuItem(String name, float price);

    public void deleteMenuItem(String name);

    public void editMenuItem(String name);

    public void createOrder(int orderID, String date, int tableID);

    public void computePrice(int orderID);


}
