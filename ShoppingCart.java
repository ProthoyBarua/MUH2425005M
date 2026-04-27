
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

    double priceAfterDiscount() {
        return price * 0.90; // 10% discount
    }
}

class Clothing extends Product {
    Clothing(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }

    double priceAfterDiscount() {
        return price * 0.80;
    }
}

class Grocery extends Product {
    Grocery(int id, String name, double price, int stock) {
        super(id, name, price, stock);
    }

    double priceAfterDiscount() {
        return price * 0.95;
    }
}


class User {
    String name;

    User(String name) {
        this.name = name;
    }
}


class Cart {
    Product[] products = new Product[10];
    int[] qty = new int[10];
    int count = 0;

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

    Order checkout(User user) {
        return new Order(user, products, qty, count);
    }
}


class Order {
    User user;
    Product[] products;
    int[] qty;
    int count;

    Order(User user, Product[] products, int[] qty, int count) {
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

            System.out.println(products[i].name +
                           "  Qty: " + qty[i] +
                    "  Price: " + price +
                    " |Total: " + itemTotal);

            total += itemTotal;
        }


        System.out.println("TOTAL: " + total);
    }
}

public class ShoppingCart{
    public static void main(String[] args) {

        User user = new User("Prothoy");

        Product p1 = new Electronics(1, "Laptop", 1000, 5);
        Product p2 = new Clothing(2, "Shirt", 50, 10);
        Product p3 = new Grocery(3, "Rice", 20, 15);

        Cart cart = new Cart();

        cart.addProduct(p1, 1);
        cart.addProduct(p2, 2);
        cart.addProduct(p3, 3);

        cart.showCart();

        Order order = cart.checkout(user);
        order.generateInvoice();
    }
}
