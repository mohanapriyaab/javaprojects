import java.util.*;
public class miniproject {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        List<String> allStudents = new ArrayList<>();
        Set<String> uniqueCourses = new HashSet<>();
        Map<Integer, String> studentDetails = new HashMap<>();

        System.out.print("How many students you want to add? ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            allStudents.add(name);

            uniqueCourses.add(course);


            studentDetails.put(roll, name);
        }


        System.out.println("\n--- STUDENT MANAGEMENT REPORT ---");
        System.out.println("All students (with possible duplicates): " + allStudents);
        System.out.println("Unique courses offered: " + uniqueCourses);
        System.out.println("Student Details (Roll No -> Name): " + studentDetails);
    }
}

        
    
    

