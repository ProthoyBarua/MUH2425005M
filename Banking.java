class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid deposit amount");
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid withdraw amount");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
}


class SavingsAccount extends Account {

    public SavingsAccount(String name, double balance) {
        super(name, balance);
    }

    public void addInterest() {
        double interest = getBalance() * 0.05;
        System.out.println("Interest added: " + interest);
    }
}


class CurrentAccount extends Account {

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    public void serviceFee() {
        System.out.println("Service fee applied: 50");
    }
}


public class Banking {
    public static void main(String[] args) {

        SavingsAccount s1 = new SavingsAccount("Rahul", 1000);
        CurrentAccount c1 = new CurrentAccount("Imtiaz", 2000);

        try {
            s1.deposit(500);
            s1.withdraw(200);
            s1.addInterest();

            System.out.println("Savings Balance: " + s1.getBalance());

            c1.deposit(1000);
            c1.withdraw(500);
            c1.serviceFee();

            System.out.println("Current Balance: " + c1.getBalance());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}