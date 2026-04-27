
abstract class Product {
    int id;
    String name;
    double price;
    int stock;

    Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    abstract double priceAfterDiscount();

    boolean reduceStock(int qty) {
        if (qty > stock) {
            System.out.println(name + " is out of stock!");
            return false;
        }
        stock -= qty;
        return true;
    }
}

class Electronics extends Product {
    Electronics(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }
    double priceAfterDiscount() { return price * 0.90; }
}

class Clothing extends Product {
    Clothing(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }
    double priceAfterDiscount() { return price * 0.80; }
}

class Grocery extends Product {
    Grocery(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }
    double priceAfterDiscount() { return price * 0.95; }
}


class Cart {
    String customerName;         // User আলাদা class নেই, নাম সরাসরি রাখছি
    Product[] products = new Product[10];
    int[] qty = new int[10];
    int count = 0;

    Cart(String customerName) {
        this.customerName = customerName;
    }

    void addProduct(Product p, int quantity) {
        if (p.reduceStock(quantity)) {
            products[count] = p;
            qty[count] = quantity;
            count++;
            System.out.println(p.name + " added to cart.");
        }
    }

    void showCart() {
        System.out.println("\n--- CART ITEMS ---");
        for (int i = 0; i < count; i++) {
            System.out.println(products[i].name + " x " + qty[i]);
        }
    }


    void generateInvoice() {
        double total = 0;
        System.out.println("\n--- INVOICE ---");
        System.out.println("Customer: " + customerName);

        for (int i = 0; i < count; i++) {
            double price = products[i].priceAfterDiscount();
            double itemTotal = price * qty[i];
            System.out.println(products[i].name +
                    "  Qty: " + qty[i] +
                    "  Price: " + price +
                    " | Total: " + itemTotal);
            total += itemTotal;
        }

        System.out.println("TOTAL: " + total);
    }
}

public class SimpleShop {
    public static void main(String[] args) {

        // Cart বানাও, নাম দিয়ে দাও
        Cart cart = new Cart("Prothoy");

        // Product যোগ করো
        cart.addProduct(new Electronics(1, "Laptop", 1000, 5), 1);
        cart.addProduct(new Clothing(2, "Shirt", 50, 10), 2);
        cart.addProduct(new Grocery(3, "Rice", 20, 15), 3);

        // দেখো কী আছে cart-এ
        cart.showCart();

        // Invoice বের করো — এখন একদম সরাসরি!
        cart.generateInvoice();
    }
}
