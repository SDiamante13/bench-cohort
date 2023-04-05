package shoppingbasket;

class Item {
    private int price;

    private int quantity;

    public Item(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    int calculateSubTotal() {
        return price * quantity;
    }
}
