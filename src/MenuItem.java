public abstract class MenuItem {
    String name;
    float price;

    public MenuItem()
    {

    }

    public MenuItem(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float computePrice();

    public String toString()
    {
        return "Name: " + name + " Price: " + price;
    }
}
