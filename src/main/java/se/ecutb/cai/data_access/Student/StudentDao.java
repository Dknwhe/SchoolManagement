package se.ecutb.cai.data_access.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student); //Student saveStudent(Student student) and Course saveCourse(Course course) should add objects to the collection and return the same object back.
    Student findByEmail(String email); //The find methods should find and return object(s) matching the search criteria.
    List<Student>findByName(String name); //The find methods should find and return object(s) matching the search criteria.
    Student findById(int id); //The find methods should find and return object(s) matching the search criteria.
    List<Student>findAll(); //The find methods should find and return object(s) matching the search criteria.
    boolean deleteStudent(Student student); // The remove methods should remove matching object from the collection.
}
