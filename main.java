import java.util.Scanner;

class Student {
    String name;
    String id;
    int[] scores = new int[5];
    double average;
    String grade;
    String status;

    // Constructor
    public Student(String name, String id, int[] scores) {
        this.name = name;
        this.id = id;
        this.scores = scores;
        calculateAverageAndGrade();
    }

    // Method to calculate average and determine grade
    private void calculateAverageAndGrade() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        this.average = total / 5.0;
        
        if (average >= 75) {
            this.grade = "A";
            this.status = "PASS";
        } else if (average >= 60) {
            this.grade = "B";
            this.status = "PASS";
        } else if (average >= 50) {
            this.grade = "C";
            this.status = "PASS";
        } else {
            this.grade = "F";
            this.status = "FAIL";
        }
    }

    // Display student report
    public void displayReport() {
        System.out.println("--------------------------------");
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.print("Scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println("\nAverage: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------");
    }
}

public class ExaminationProcessingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[10];

        System.out.println("Enter details for 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();
            int[] scores = new int[5];
            
            for (int j = 0; j < 5; j++) {
                System.out.print("Enter score for subject " + (j + 1) + ": ");
                scores[j] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline
            
            students[i] = new Student(name, id, scores);
        }
        
        System.out.println("\nSTUDENT REPORT CARDS:");
        for (Student student : students) {
            student.displayReport();
        }
        
        scanner.close();
    }
}
