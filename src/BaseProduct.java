public class BaseProduct extends MenuItem {

    public BaseProduct() {
        super();
    }

    public BaseProduct(String name, float price) {
        super(name, price);
    }

    public float computePrice()
    {
        return price;
    }

}
