import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) { this.hours = hours; }

    abstract double getCharge();

    abstract String getType();
}

class Bike extends Vehicle {
    Bike(int hours) { super(hours); }

    @Override
    double getCharge() {
        return hours * 10.0;
    }

    @Override
    String getType() { return "BIKE"; }
}

class Car extends Vehicle {
    Car(int hours) { super(hours); }

    @Override
    double getCharge() {
        if (hours <= 1) return 30.0;
        return 30.0 + (hours - 1) * 20.0;
    }

    @Override
    String getType() { return "CAR"; }
}

class Truck extends Vehicle {
    Truck(int hours) { super(hours); }

    @Override
    double getCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }

    @Override
    String getType() { return "TRUCK"; }
}

class VehicleFactory {
    static Vehicle create(String type, int hours) {
        switch (type) {
            case "BIKE":  return new Bike(hours);
            case "CAR":   return new Car(hours);
            case "TRUCK": return new Truck(hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

public class Problem2_ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            Vehicle vehicle = VehicleFactory.create(type, hours);
            double charge = vehicle.getCharge(); // no if-else here
            grandTotal += charge;

            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}