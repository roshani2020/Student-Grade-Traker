import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of students:");
        int numStudents = getValidIntegerInput(scanner);
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter grade for student " + (i + 1) + " (0-100):");
            int grade = getValidGrade(scanner);
            grades.add(grade);
        }
        
        double average = computeAverage(grades);
        int highest = findHighest(grades);
        int lowest = findLowest(grades);
        
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
        
        scanner.close();
    }
    
    public static int getValidIntegerInput(Scanner scanner) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Please enter a positive integer:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer:");
            }
        }
    }
    
    public static int getValidGrade(Scanner scanner) {
        int grade;
        while (true) {
            try {
                grade = Integer.parseInt(scanner.nextLine());
                if (grade >= 0 && grade <= 100) {
                    return grade;
                } else {
                    System.out.println("Please enter a grade between 0 and 100:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade (0-100):");
            }
        }
    }
    
    public static double computeAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
    
    public static int findHighest(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }
    
    public static int findLowest(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}