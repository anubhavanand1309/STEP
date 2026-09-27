public class Problem4_IdCard {

    static class IdCard {
        String name;
        int booksIssued;

        IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);

        // duplicate points at the SAME object as ravi — no new object is created.
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;

        // Seen through the first variable too, because it's the same object in memory.
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued); // 3
        System.out.println("duplicate == ravi: " + (duplicate == ravi)); // true

        // A separate object with identical field values is still a different object.
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi)); // false
    }
}