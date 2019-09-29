package se.ecutb.cai;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.cai.data_access.Course.Course;
import se.ecutb.cai.data_access.Student.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CourseTest {

    private Course courseObject;
    private Student studentObject;

    @Before
    public void setUp() {
        courseObject = new Course(1, "Java", LocalDate.parse("2019-09-26"), 15);
        studentObject = new Student(2, "cai", "mail@live.se", "hemma");
    }

    @Test
    public void register_test() {
        courseObject.register(studentObject);
        Student expected = studentObject;
        Assert.assertNotNull(String.valueOf(expected));
    }

    @Test
    public void unregister_test() {
        Student temp = new Student(1, "test", "email", "address");
        List<Student> expected = new ArrayList<>();
        expected.add(temp);
        expected.remove(temp);
        courseObject.register(studentObject);
        courseObject.unregister(studentObject);
        Assert.assertEquals(expected, courseObject.getStudents());
    }
}


