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
    private Student studentObject, student1;

    @Before
    public void setUp() {
        courseObject = new Course(1,"Java",LocalDate.parse("2019-09-26"),15);
        studentObject = new Student(2,"cai","mail@live.se","hemma");
        student1 = new Student(0,"null", "null", "noll");
    }

    @Test
    public void register_test() {
        courseObject.register(studentObject);
        Student expected = studentObject;
        Student actual = new Student(3,"hej","mail@live.se","hemma");
        Assert.assertNotNull(String.valueOf(expected), actual);
    }

    @Test
    public void unregister_test() {








    }
}
