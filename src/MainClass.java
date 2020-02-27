public class MainClass {
    public static void main(String[] args)
    {
        GUI view = new GUI();
        Restaurant restaurant = new Restaurant();
        Order order = new Order();

        Controller c = new Controller(restaurant, view, order);
    }
}
