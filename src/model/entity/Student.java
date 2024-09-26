package model.entity;


public class Student {
    Integer stNumber;
    String fullName;
    char gender;
    String course;

    public Student(Integer stNumber, String fullName, char gender, String course) {
        this.stNumber = stNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.course = course;
    }

    public Integer getStNumber() {
        return stNumber;
    }

    public void setStNumber(Integer stNumber) {
        this.stNumber = stNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" + "stNumber=" + stNumber + ", fullName=" + fullName + ", gender=" + gender + ", course=" + course + '}';
    }
    
    
    
    
    
}
