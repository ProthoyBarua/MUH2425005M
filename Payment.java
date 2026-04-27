interface PaymentMethod {
    void makePayment(double amount) throws Exception;
    void refund(double amount);
}


class UPI implements PaymentMethod {
    String upiId;
    double balance;

    public UPI(String upiId, double balance) {
        this.upiId = upiId;
        this.balance = balance;
    }

    public void makePayment(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("UPI balance low");
        }
        balance -= amount;
        System.out.println("Paid using UPI");
    }

    public void refund(double amount) {
        balance += amount;
        System.out.println("Refund to UPI");
    }
}


class CreditCard implements PaymentMethod {
    String cardNumber;
    double limit;

    public CreditCard(String cardNumber, double limit) {
        this.cardNumber = cardNumber;
        this.limit = limit;
    }

    public void makePayment(double amount) throws Exception {
        if (cardNumber.length() < 5) {
            throw new Exception("Invalid Card");
        }
        if (amount > limit) {
            throw new Exception("Limit exceeded");
        }
        limit -= amount;
        System.out.println("Paid using Credit Card");
    }

    public void refund(double amount) {
        limit += amount;
        System.out.println("Refund to Card");
    }
}


class PayPal implements PaymentMethod {
    String email;
    double balance;

    public PayPal(String email, double balance) {
        this.email = email;
        this.balance = balance;
    }

    public void makePayment(double amount) throws Exception {
        if (!email.contains("@")) {
            throw new Exception("Invalid Email");
        }
        if (amount > balance) {
            throw new Exception("PayPal balance low");
        }
        balance -= amount;
        System.out.println("Paid using PayPal");
    }

    public void refund(double amount) {
        balance += amount;
        System.out.println("Refund to PayPal");
    }
}


class BankTransfer implements PaymentMethod {
    String accountNo;
    double balance;

    public BankTransfer(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void makePayment(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Bank balance low");
        }
        balance -= amount;
        System.out.println("Paid using Bank Transfer");
    }

    public void refund(double amount) {
        balance += amount;
        System.out.println("Refund to Bank");
    }
}


public class Payment {
    public static void main(String[] args) {

        PaymentMethod p1 = new UPI("rahul@upi", 1000);
        PaymentMethod p2 = new CreditCard("12345", 5000);
        PaymentMethod p3 = new PayPal("user@gmail.com", 2000);
        PaymentMethod p4 = new BankTransfer("ACC123", 3000);

        PaymentMethod[] list = {p1, p2, p3, p4};

        for (int i = 0; i < list.length; i++) {
            try {
                list[i].makePayment(700);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}