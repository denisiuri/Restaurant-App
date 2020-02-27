import java.util.ArrayList;

public class CompositeProduct extends MenuItem {

    private ArrayList<MenuItem> listOfItems = new ArrayList<MenuItem>();

    public ArrayList<MenuItem> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(ArrayList<MenuItem> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public CompositeProduct()
    {

    }
    public CompositeProduct(String name, float price) {
        super(name, price);
    }

    public float computePrice()
    {
        float compositePrice = 0;
        for(MenuItem it : this.listOfItems)
        {
           compositePrice = compositePrice + it.getPrice();
        }

        return compositePrice;
    }
}
