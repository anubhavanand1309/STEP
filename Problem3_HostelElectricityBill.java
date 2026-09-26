import java.util.Scanner;

abstract class Room {
    protected int units;

    Room(int units) { this.units = units; }

    abstract double getBill();

    abstract String getType();
}

class SingleRoom extends Room {
    SingleRoom(int units) { super(units); }

    @Override
    double getBill() {
        return units * 8.0;
    }

    @Override
    String getType() { return "SINGLE"; }
}

class SharedRoom extends Room {
    private int occupants; // extra param stored right here, alongside this type's own state

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double getBill() {
        double totalBill = units * 6.0;
        return totalBill / occupants;
    }

    @Override
    String getType() { return "SHARED"; }
}

class ACRoom extends Room {
    ACRoom(int units) { super(units); }

    @Override
    double getBill() {
        return units * 10.0 + 200.0;
    }

    @Override
    String getType() { return "AC"; }
}

class RoomFactory {
    // Handles the type-specific parsing (including the optional occupants field)
    // so the main loop can just call getBill() on whatever comes back.
    static Room create(String[] parts) {
        String type = parts[0];
        int units = Integer.parseInt(parts[1]);

        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                int occupants = Integer.parseInt(parts[2]);
                return new SharedRoom(units, occupants);
            case "AC":
                return new ACRoom(units);
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }
}

public class Problem3_HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");

            Room room = RoomFactory.create(parts);
            double bill = room.getBill(); // no if-else here
            grandTotal += bill;

            System.out.printf("%s: %.2f%n", room.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        sc.close();
    }
}