import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private Map<Order, ArrayList<MenuItem>> hashMap = new HashMap<Order, ArrayList<MenuItem>>();
    private ArrayList<MenuItem> menu = new ArrayList<MenuItem>();

    public Map<Order, ArrayList<MenuItem>> getHashMap() {
        return hashMap;
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }


}
