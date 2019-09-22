package se.ecutb.cai.data_access.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student>students;
    public StudentDaoList() {
        students = new ArrayList<>();
    }

    @Override
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
         for (Student student : students){
             if (student.getEmail().equalsIgnoreCase(email)) {
                 return student;
             }
         }
         return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> s = new ArrayList<>();
        for (Student student : students){
            if (student.getName().equalsIgnoreCase(name)) {
                s.add(student);
            }
        }
        return s;
    }

    @Override
    public Student findById(int id) {
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    public static List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return students.remove(student);
    }
}
