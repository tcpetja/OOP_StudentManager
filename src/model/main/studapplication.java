
package model.main;

import java.util.List;
import java.util.Scanner;
import model.entity.Student;
import model.manager.studManager;

public class studapplication {
    
    
    
    public static void main(String[] args) {
        Integer stNumber;
        String fullName;
        char gender;
        String course;
        boolean status ;
        
        studManager stManager = new studManager();
        Scanner sc = new Scanner(System.in);
        Integer option = getOption();
        
        switch(option){
            case 1:
                System.out.print("Enter student number:");
                stNumber = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Enter student fullname:");
                fullName = sc.nextLine();
                
                System.out.print("Enter student Gender:");
                gender = sc.next().charAt(0);
                sc.nextLine();
                
                System.out.print("Enter student Course:");
                course = sc.nextLine();
                
                Student student = new Student(stNumber, fullName, gender, course);
                status = stManager.addStudent(student);
                
                if (status) {
                    System.out.println("Student addend successfully!");
                } else {
                    System.err.println("Error adding student!");
                }
                break;
            
            case 2:
                
                System.out.print("Enter student numebr to delete: ");
                stNumber = sc.nextInt();
                sc.nextLine();
                
                status = stManager.removeStudent(stNumber);
                
                if (status) {
                    System.out.println("Student Deleted successfully!");
                } else {
                    System.err.println("Error deleting student!");
                }
                
                break;
             
            case 3:
                System.out.println("Enter student number to change course: ");
                stNumber = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the name of the new course: ");
                course = sc.nextLine();
                
                status = stManager.changecourse(stNumber, course);
                
                if (status) {
                    System.out.println("Student course changed succeffuly!");
                } else {
                    System.err.println("Error Updating student course!");
                }
                
                break;
                
            case 4:
                System.out.println("Please enter student numeber:");
                stNumber = sc.nextInt();
                sc.nextLine();
                
                Student stud = stManager.getStudent(stNumber);
                System.out.println(stud.toString());
                
                break;
                
            case 5:
                List<Student> students = stManager.getAll();
                
                for (Student student1 : students) {
                    System.out.println(student1.toString());
                }
                break;
        }               
    }
    
    
    public static Integer getOption(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose your option below:\n"
                + "1.Add Student\n"
                + "2.Remove Student\n"
                + "3.Change Student course\n"
                + "4.View Student\n"
                + "5.View all Students\n"
                + "Your Option: ");
        return sc.nextInt();
        
    }
}
