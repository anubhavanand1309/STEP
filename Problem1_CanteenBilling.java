import java.util.Scanner;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }


    abstract double getFinalAmount();

    abstract String getType();
}
class Student extends Customer {
    Student(double amount) { super(amount); }

    @Override
    double getFinalAmount() {
        return amount - (amount * 0.10); 
    }

    @Override
    String getType() { return "STUDENT"; }
}

class Staff extends Customer {
    Staff(double amount) { super(amount); }

    @Override
    double getFinalAmount() {
        return amount - (amount * 0.05); 
    }

    @Override
    String getType() { return "STAFF"; }
}

class Guest extends Customer {
    Guest(double amount) { super(amount); }

    @Override
    double getFinalAmount() {
        return amount + 10; 
    }

    @Override
    String getType() { return "GUEST"; }
}

class CustomerFactory {
    static Customer create(String type, double amount) {
        switch (type) {
            case "STUDENT": return new Student(amount);
            case "STAFF":   return new Staff(amount);
            case "GUEST":   return new Guest(amount);
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }
}

public class Problem1_CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            Customer customer = CustomerFactory.create(type, amount);
            double finalAmount = customer.getFinalAmount(); 
            grandTotal += finalAmount;

            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}