import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentManager {

	 private static ArrayList<Student> students = new ArrayList<>();
	    private static Scanner scan = new Scanner(System.in);

	    public static void main(String[] args) {

	        boolean running = true;

	        while (running) {
	            System.out.println("\n--- Student Record Management System ---");
	            System.out.println("1. Add Student");
	            System.out.println("2. View All Students");
	            System.out.println("3. Update Student");
	            System.out.println("4. Delete Student");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");

	            int choice = 0;
	            if (scan.hasNextInt()) {
	                choice = scan.nextInt();
	            } else {
	                System.out.println("Invalid input. Please enter a number.");
	                scan.next(); // consume invalid input
	                continue;
	            }

	            switch (choice) {
	                case 1 -> addStudent();
	                case 2 -> viewStudent();
	                case 3 -> updateStudent();
	                case 4 -> deleteStudent();
	                case 5 -> {
	                    running = false;
	                    System.out.println("Exiting the system...");
	                    break;
	                }
	                default -> System.out.println("Invalid option. Please try again.");
	            }

	            if (running) {
	                System.out.println("\nPress Enter to continue...");
	                scan.nextLine(); 
	                scan.nextLine(); // wait for user
	            }
	        }

	        scan.close();
	    }

	    private static void addStudent() {
	        try {
	            System.out.print("Enter ID: ");
	            int id = scan.nextInt();
	            scan.nextLine(); 

	            System.out.print("Enter Name: ");
	            String name = scan.nextLine();

	            System.out.print("Enter Marks: ");
	            double marks = scan.nextDouble();

	            students.add(new Student(id, name, marks));
	            System.out.println("Student added successfully.");
	        } catch (Exception e) {
	            System.out.println("Invalid input. Please try again.");
	            scan.nextLine(); // consume invalid input
	        }
	    }

	    public static void viewStudent() {
	        if (students.isEmpty()) {
	            System.out.println("No records found.");
	        } else {
	            for (Student student : students) {
	                System.out.println(student);
	            }
	        }
	    }

	    public static void updateStudent() {
	        System.out.print("Enter ID to update: ");
	        int id = scan.nextInt();

	        for (Student student : students) {
	            if (student.getId() == id) {
	                scan.nextLine(); 

	                System.out.print("Enter new Name: ");
	                String name = scan.nextLine();

	                System.out.print("Enter new Marks: ");
	                double marks = scan.nextDouble();

	                student.setName(name);
	                student.setMarks(marks);

	                System.out.println("Student record updated.");
	                return;
	            }
	        }

	        System.out.println("Student with ID " + id + " not found.");
	    }

	    private static void deleteStudent() {
	        System.out.print("Enter ID to delete: ");
	        int id = scan.nextInt();

	        Iterator<Student> iterator = students.iterator();
	        while (iterator.hasNext()) {
	            Student student = iterator.next();
	            if (student.getId() == id) {
	                iterator.remove();
	                System.out.println("Student deleted.");
	                return;
	            }
	        }

	        System.out.println("Student with ID " + id + " not found.");
	    }

}
