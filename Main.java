import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GradeTracker tracker = new GradeTracker();

    public static void main(String[] args) {
        System.out.println("=== Student Grade Tracker ===");
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add student");
            System.out.println("2. Add grades to a student");
            System.out.println("3. View summary report");
            System.out.println("4. View one student's details");
            System.out.println("5. Remove student");
            System.out.println("6. Exit");
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addGrades();
                case 3 -> tracker.printReport();
                case 4 -> viewDetails();
                case 5 -> removeStudent();
                case 6 -> { System.out.println("Goodbye!"); running = false; }
                default -> System.out.println("Invalid option. Enter 1-6.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) { System.out.println("Name cannot be empty."); return; }
        System.out.println(tracker.addStudent(name) ? "Student added." : "That student already exists.");
    }

    private static void addGrades() {
        if (tracker.isEmpty()) { System.out.println("Add a student first."); return; }
        tracker.printStudents();
        System.out.print("Enter student name: ");
        Student s = tracker.findStudent(scanner.nextLine().trim());
        if (s == null) { System.out.println("Student not found."); return; }

        System.out.println("Enter grades (0-100). Type -1 to stop.");
        while (true) {
            double g = readDouble("Grade: ");
            if (g == -1) break;
            if (g < 0 || g > 100) { System.out.println("Grade must be 0-100."); continue; }
            s.addGrade(g);
        }
    }

    private static void viewDetails() {
        System.out.print("Enter student name: ");
        Student s = tracker.findStudent(scanner.nextLine().trim());
        if (s == null) { System.out.println("Student not found."); return; }
        System.out.println("Name   : " + s.getName());
        System.out.println("Grades : " + s.getGrades());
        if (s.hasGrades()) {
            System.out.printf("Average: %.2f%n", s.getAverage());
            System.out.printf("Highest: %.2f%n", s.getHighest());
            System.out.printf("Lowest : %.2f%n", s.getLowest());
            System.out.println("Letter : " + s.getLetterGrade());
        }
    }

    private static void removeStudent() {
        System.out.print("Enter student name to remove: ");
        System.out.println(tracker.removeStudent(scanner.nextLine().trim()) ? "Removed." : "Student not found.");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Please enter a whole number."); }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Double.parseDouble(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Please enter a number."); }
        }
    }
}