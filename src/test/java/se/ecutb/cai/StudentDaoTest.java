package se.ecutb.cai;

import org.junit.Before;
import org.junit.Test;
import se.ecutb.cai.data_access.Student.Student;
import se.ecutb.cai.data_access.Student.StudentDao;
import se.ecutb.cai.data_access.Student.StudentDaoList;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    private StudentDao testObject = new StudentDaoList();
    private Student studentTest;
    private int studentId;

    @Before
    public void setUp() {
        studentTest = new Student(1, "cai","cai.se@lise.se","hemma");
        testObject.saveStudent(studentTest);
        studentId = studentTest.getId();
    }

    @Test
    public void saveStudent_test() {
        Student expected = new Student(2,"test","test@mai.se","hejhej");
        assertEquals(expected, testObject.saveStudent(expected));

    }

    @Test
    public void find_email_test() {
        assertNull(testObject.findByEmail("12@live.se"));

    }

    @Test
    public void find_name_test() {
        String name = "hej";
        List<Student> test = testObject.findByName(name);
        for (Student s : test) {
            assertEquals(name, s.getName());
        }
    }

    @Test
    public void find_id_test() {
        assertEquals(studentTest, testObject.findById(studentId));
    }

    @Test
    public void find_all_test() {
        List<Student> find = testObject.findAll();
        assertEquals(StudentDaoList.getStudents(),find);
    }

    @Test
    public void delete_student_test() {
        boolean delete = testObject.deleteStudent(studentTest);
        assertTrue(delete);
    }
}
