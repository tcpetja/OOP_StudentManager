
package model.interf;

import java.util.List;
import model.entity.Student;

public interface stInterface<T> {
    boolean addStudent(T t);
    boolean removeStudent(Integer stnumber);
    boolean changecourse(Integer stnumber, String newCourse);
    List<T> getAll();
    Student getStudent(Integer stNumber);
    
}
