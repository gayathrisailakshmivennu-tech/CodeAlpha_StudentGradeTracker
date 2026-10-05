import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public boolean hasGrades() {
        return !grades.isEmpty();
    }

    public double getAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double total = 0;

        for (double grade : grades) {
            total += grade;
        }

        return total / grades.size();
    }

    public double getHighest() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double highest = grades.get(0);

        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }

        return highest;
    }

    public double getLowest() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double lowest = grades.get(0);

        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }

        return lowest;
    }

    public String getLetterGrade() {
        double average = getAverage();

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

    

