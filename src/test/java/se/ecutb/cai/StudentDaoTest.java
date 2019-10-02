package se.ecutb.cai;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.cai.data_access.Student.Student;
import se.ecutb.cai.data_access.Student.StudentDaoList;
//Hej
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    private StudentDaoList testObject;
    private Student studentTest;

    @Before
    public void setUp() {
        studentTest = new Student(1, "cai","cai.se@lise.se","hemma");
        testObject = new StudentDaoList();
    }

    @Test
    public void saveStudent_test() {
        Student expected = studentTest;
        Student actual = testObject.saveStudent(studentTest);
        Assert.assertEquals(expected, actual);
        assertNull(testObject.saveStudent(studentTest));

    }

    @Test
    public void find_email_test() {
        testObject.saveStudent(studentTest);
        Student expected = studentTest;
        Student actual = testObject.findByEmail("cai.se@lise.se");
        Assert.assertEquals(expected, actual);
        assertNull(testObject.findByEmail(" "));

    }

    @Test
    public void find_name_test() {
        testObject.saveStudent(studentTest);
        List<Student> list = new ArrayList<>();
        list.add(studentTest);
        Assert.assertEquals(list, testObject.findByName("cai"));


    }

    @Test
    public void find_id_test() {
        testObject.saveStudent(studentTest);
        Student expected = studentTest;
        Student actual = testObject.findById(1);
        Assert.assertEquals(expected, actual);
        assertNull(testObject.findById(0));

    }

    @Test
    public void find_all_test() {
        List<Student> find = testObject.findAll();
        assertEquals(StudentDaoList.getStudents(),find);
    }

    @Test
    public void delete_student_test() {
        boolean delete = testObject.deleteStudent(studentTest);
        Assert.assertFalse(delete);
    }
}
