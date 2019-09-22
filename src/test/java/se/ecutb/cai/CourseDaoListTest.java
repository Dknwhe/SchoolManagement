package se.ecutb.cai;

import org.junit.Before;
import org.junit.Test;
import se.ecutb.cai.data_access.Course.Course;
import se.ecutb.cai.data_access.Course.CourseDao;
import se.ecutb.cai.data_access.Course.CourseDaoList;
import se.ecutb.cai.data_access.Student.Student;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class CourseDaoListTest
{

    private CourseDao testObject = new CourseDaoList();
    private Course courseTest;
    private int courseId;
    private Student student;
    private List<Student> studentTest;

    @Before
    public void setup() {
        courseTest = new Course(1,"java", LocalDate.of(2019, 9, 22),10);
        testObject.saveCourse(courseTest);
        courseId = courseTest.getId();
        student = new Student(2, "hej","mail@ki.se","hemma");

    }

    @Test
    public void save_Course_Test() {
        Course expected = new Course(3, "matte", LocalDate.of(2019,10, 5), 10 );
        assertEquals(expected,testObject.saveCourse(expected));
        assertTrue(testObject.removeCourse(expected));

    }

    @Test
    public void find_id_test() {
        assertEquals(courseTest, testObject.findById(courseId));

    }

    @Test
    public void find_name_test() {
        String name = "hej";
        List<Course> test = testObject.findByName(name);
        for ( Course c : test) {
            assertEquals(name,c.getCourseName());
        }
    }

    @Test
    public void find_date_test(){
        LocalDate test = LocalDate.of(2019,9,22);
        List<Course> find = testObject.findByDate(test);
        for (Course c : find) {
            assertEquals(test,c.getStartDate());
        }
    }
    @Test
    public void find_all_test() {
        List<Course> test = testObject.findAll();
        assertEquals(CourseDaoList.getCourses(),test);

    }
    @Test
    public void remove_Course_test() {
        boolean remove = testObject.removeCourse(courseTest);
        assertTrue(remove);
    }

    @Test
    public void register_Test() {



    }

    @Test
    public void unregister_Test() {

    }

}
