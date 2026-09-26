import java.time.LocalDate;
import java.util.Scanner;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    // Common operation built on top of each plan's own validity period.
    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    String getName() { return name; }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) { super(name, startDate); }

    @Override
    int getValidityDays() { return 30; }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) { super(name, startDate); }

    @Override
    int getValidityDays() { return 90; }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }

    @Override
    int getValidityDays() { return 365; }
}

class PlanFactory {
    static Plan create(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC":    return new BasicPlan(name, startDate);
            case "STANDARD": return new StandardPlan(name, startDate);
            case "PREMIUM":  return new PremiumPlan(name, startDate);
            default: throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }
}

public class Problem5_StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]); // expects YYYY-MM-DD

            Plan plan = PlanFactory.create(type, name, startDate);
            LocalDate renewalDate = plan.getRenewalDate(); // no if-else here

            System.out.println(plan.getName() + ": " + renewalDate);
        }

        sc.close();
    }
}