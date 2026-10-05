import java.util.ArrayList;
import java.util.List;

public class GradeTracker {
    private final List<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public boolean addStudent(String name) {
        if (findStudent(name) != null) {
            return false;
        }

        students.add(new Student(name));
        return true;
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }

        return null;
    }

    public boolean removeStudent(String name) {
        Student student = findStudent(name);

        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

    public void printStudents() {
        System.out.println("\nStudents:");

        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }

    public void printReport() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n=== Summary Report ===");

        for (Student student : students) {
            System.out.println("\nName: " + student.getName());

            if (student.hasGrades()) {
                System.out.printf("Average: %.2f%n", student.getAverage());
                System.out.printf("Highest: %.2f%n", student.getHighest());
                System.out.printf("Lowest : %.2f%n", student.getLowest());
                System.out.println("Letter : " + student.getLetterGrade());
            } else {
                System.out.println("No grades entered.");
            }
        }
    }
}

