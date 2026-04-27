

abstract class Product3 {
    int id;
    String name;
    double price;
    int stock;

    Product3(int id, String name, double price, int stock) {
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

class Electronics3 extends Product3 {
    Electronics3(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }
    double priceAfterDiscount() { return price * 0.90; }
}

class Clothing3 extends Product3 {
    Clothing3(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }
    double priceAfterDiscount() { return price * 0.80; }
}

class Grocery3 extends Product3 {
    Grocery3(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }
    double priceAfterDiscount() { return price * 0.95; }
<<<<<<< HEAD
}

class User3 {
    String name;
    User3(String name) { this.name = name; }
}

class Cart3 {
    Product3[] products = new Product3[10];
    int[] qty = new int[10];
    int count = 0;

    void addProduct(Product3 p, int quantity) {
=======
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
>>>>>>> e769023c33d319f62017a1f66912117bcf541fc7
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

<<<<<<< HEAD
    Order3 checkout(User3 user) {
        return new Order3(user, products, qty, count);
    }
}

class Order3 {
    User3 user;
    Product3[] products;
    int[] qty;
    int count;

    Order3(User3 user, Product3[] products, int[] qty, int count) {
        this.user = user;
        this.products = products;
        this.qty = qty;
        this.count = count;
    }

    void generateInvoice() {
        double total = 0;
        System.out.println("Customer: " + user.name);
        for (int i = 0; i < count; i++) {
            double price = products[i].priceAfterDiscount();
            double itemTotal = price * qty[i];
            System.out.println(products[i].name + "  Qty: " + qty[i] +
                    "  Price: " + price + " | Total: " + itemTotal);
            total += itemTotal;
        }
=======

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

>>>>>>> e769023c33d319f62017a1f66912117bcf541fc7
        System.out.println("TOTAL: " + total);
    }
}

<<<<<<< HEAD
public class ShoppingCart {
    public static void main(String[] args) {

        User3 user = new User3("Prothoy");
        Cart3 cart = new Cart3();


        Product3[] allProducts = {
            new Electronics3(1, "Laptop", 1000, 5),
            new Clothing3(2, "Shirt", 50, 10),
            new Grocery3(3, "Rice", 20, 15)
        };


        int[] quantities = {1, 2, 3};


        for (int i = 0; i < allProducts.length; i++) {
            cart.addProduct(allProducts[i], quantities[i]);
        }
=======
public class SimpleShop {
    public static void main(String[] args) {

        // Cart বানাও, নাম দিয়ে দাও
        Cart cart = new Cart("Prothoy");

        // Product যোগ করো
        cart.addProduct(new Electronics(1, "Laptop", 1000, 5), 1);
        cart.addProduct(new Clothing(2, "Shirt", 50, 10), 2);
        cart.addProduct(new Grocery(3, "Rice", 20, 15), 3);
>>>>>>> e769023c33d319f62017a1f66912117bcf541fc7

        // দেখো কী আছে cart-এ
        cart.showCart();

<<<<<<< HEAD
        Order3 order = cart.checkout(user);
        order.generateInvoice();
=======
        // Invoice বের করো — এখন একদম সরাসরি!
        cart.generateInvoice();
>>>>>>> e769023c33d319f62017a1f66912117bcf541fc7
    }
}
