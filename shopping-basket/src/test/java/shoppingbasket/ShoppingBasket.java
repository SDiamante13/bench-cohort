package shoppingbasket;

import java.util.Map;

class ShoppingBasket {

    private Map<String, Item> items;

    public ShoppingBasket(Map<String, Item> items) {
        this.items = items;
    }

    public float calculateTotal() {
        float total = 0;
        for (Item item : items.values()) {
            total += item.calculateSubTotal();
        }
        


        if(total > 200){
            return total * 0.9f;
        }

        if (total > 100) {
            return total * 0.95f;
        }


        return total;
    }

}
