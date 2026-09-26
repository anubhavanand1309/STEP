import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double getBonus();

    String getName() { return name; }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) { super(name, salary); }

    @Override
    double getBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) { super(name, salary); }

    @Override
    double getBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }

    @Override
    double getBonus() {
        return 2000.0; // fixed, regardless of salary
    }
}

class EmployeeFactory {
    static Employee create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN":   return new Intern(name, salary);
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }
}

public class Problem4_FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            Employee employee = EmployeeFactory.create(type, name, salary);
            double bonus = employee.getBonus(); // no if-else here
            grandTotal += bonus;

            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", grandTotal);
        sc.close();
    }
}