
package model.manager;

import java.util.List;
import model.entity.Student;
import model.interf.stInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class studManager implements stInterface<Student>{
    String url = "jdbc:mysql://localhost:3306/sedimadatabase";
    String username = "root";
    String password = "Clement02";
    Connection connection = null;
    
    public studManager(){
        connection = getConnection(url, username, password);
    
    }
 
    @Override
    public boolean addStudent(Student stud) {
        
        try {
            String sql = "INSERT INTO tblstudents VALUE(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,stud.getStNumber());
            ps.setString(2, stud.getFullName());
            ps.setString(3,String.valueOf(stud.getGender()));
            ps.setString(4, stud.getCourse());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            System.err.println(e.toString());
            System.err.println("error adding student");
            return false;
        }
    }

    @Override
    public boolean removeStudent(Integer stnumber) {
        try {
            String sql = " Delete FROM tblstudents WHERE stnum = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, stnumber);
            
            ps.executeUpdate();
            System.out.println("Student "+stnumber+" Deleted succefully!");
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            System.err.println("Error Deleting student!");
            return false;
        }
    }

    @Override
    public boolean changecourse(Integer stnumber, String newCourse) {
        try {
            String sql = "UPDATE tblstudents SET course = ? WHERE stnum = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newCourse);
            ps.setInt(2, stnumber);
            ps.executeUpdate();
            
            System.out.println("Course for "+stnumber+" has been updated Successfully to "+newCourse);
            return true;
            
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "Select * from tblstudents ORDER BY stnum ASC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer studentNumber = rs.getInt("stnum");
                String fullName = rs.getString("full_name");
                String gender = rs.getString("gender");
                char genderChar = gender.charAt(0);
                String course = rs.getString("course");
            
                Student student = new Student(studentNumber, fullName, genderChar, course);
                students.add(student);
            }
            
            
        } catch (Exception e) {
            System.err.println(e.toString());
            System.err.println("Error getting students!");
        }
        
        return students;
    }

    @Override
    public Student getStudent(Integer stNumber) {
        Student student = null;
        try {
            String sql = "Select * FROM tblStudents WHERE stnum = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,stNumber);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Integer studentNumber = rs.getInt("stnum");
                String fullName = rs.getString("full_name");
                String gender = rs.getString("gender");
                char genderChar = gender.charAt(0);
                String course = rs.getString("course");
            
                student = new Student(studentNumber, fullName, genderChar, course);
            } else{
                System.err.println("Empty ResultSet");
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            System.err.println("Error getting student!");
        }
        return student;
    }
    
    public Connection getConnection(String url,String username,String password){
        
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url, username, password);
        
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
        return connect;
        
    }
    
    
}
