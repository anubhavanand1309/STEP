public class Problem5_Student {

    static class Student {
        String name;
        int attendance;

        // Shared by every instance — one copy, not duplicated per object.
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++; // increments once per object created
        }

        // Belongs to the class, not any one object — touches only static fields.
        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 90);
        Student s2 = new Student("Anitha", 85);

        // Called through the class name, not through s1 or s2.
        Student.printCollegeInfo();
    }
}