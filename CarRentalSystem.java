abstract class Vehicle {
    protected String model;
    protected int year;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

interface Rentable {
    double rent(int days, boolean hasInsurance, int mileageTier);
}

class Car extends Vehicle implements Rentable {
    public Car(String model, int year) {
        super(model, year);
    }

    @Override
    public double rent(int days, boolean hasInsurance, int mileageTier) {
        double baseRate = 50.0;
        double total = baseRate * days;
        if (hasInsurance) {
            total *= 1.2;
        }
        if (mileageTier == 2) {
            total *= 1.1;
        } else if (mileageTier == 3) {
            total *= 1.2;
        }
        return total;
    }
}

class Bike extends Vehicle implements Rentable {
    public Bike(String model, int year) {
        super(model, year);
    }

    @Override
    public double rent(int days, boolean hasInsurance, int mileageTier) {
        double baseRate = 20.0;
        double total = baseRate * days;
        if (hasInsurance) {
            total *= 1.15;
        }
        if (mileageTier == 2) {
            total *= 1.05;
        } else if (mileageTier == 3) {
            total *= 1.1;
        }
        return total;
    }
}

class Truck extends Vehicle implements Rentable {
    public Truck(String model, int year) {
        super(model, year);
    }

    @Override
    public double rent(int days, boolean hasInsurance, int mileageTier) {
        double baseRate = 100.0;
        double total = baseRate * days;
        if (hasInsurance) {
            total *= 1.3;
        }
        if (mileageTier == 2) {
            total *= 1.2;
        } else if (mileageTier == 3) {
            total *= 1.4;
        }
        return total;
    }
}

class RentalAgreement {
    private Rentable vehicle;
    private int days;
    private boolean hasInsurance;
    private int mileageTier;

    public RentalAgreement(Rentable vehicle, int days, boolean hasInsurance, int mileageTier) {
        this.vehicle = vehicle;
        this.days = days;
        this.hasInsurance = hasInsurance;
        this.mileageTier = mileageTier;
    }

    public double calculateTotalRent() {
        return vehicle.rent(days, hasInsurance, mileageTier);
    }

    public void printAgreement() {
        System.out.println("Renting " + ((Vehicle)vehicle).getModel() + " for " + days + " days.");
        System.out.println("Insurance: " + (hasInsurance ? "Yes" : "No"));
        System.out.println("Mileage Tier: " + mileageTier);
        System.out.println("Total Rent: $" + calculateTotalRent());
    }
}

public class CarRentalSystem {
    public static void main(String[] args) {

        Rentable car = new Car("Toyota Camry", 2020);
        Rentable bike = new Bike("Honda CBR", 2019);
        Rentable truck = new Truck("Ford F-150", 2021);


        RentalAgreement agreement1 = new RentalAgreement(car, 5, true, 2);
        RentalAgreement agreement2 = new RentalAgreement(bike, 3, false, 1);
        RentalAgreement agreement3 = new RentalAgreement(truck, 7, true, 3);


       


        agreement1.printAgreement();
        agreement2.printAgreement();
        agreement3.printAgreement();
    }
}