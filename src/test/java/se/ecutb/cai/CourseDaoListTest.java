package se.ecutb.cai;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutb.cai.data_access.Course.Course;
import se.ecutb.cai.data_access.Course.CourseDaoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseDaoListTest
{

    private CourseDaoList testObject;
    private Course courseTest;


    @Before
    public void setup() {
        courseTest = new Course(1,"java", LocalDate.parse("2019-09-25"),10);
        testObject = new CourseDaoList();

    }

    @Test
    public void save_Course_Test() {
        Course expected = courseTest;
        Course actual = testObject.saveCourse(courseTest);
        Assert.assertEquals(expected, actual);
        assertNull(testObject.saveCourse(courseTest));

    }

    @Test
    public void find_id_test() {
      testObject.saveCourse(courseTest);
      Course expected = courseTest;
      Course actual = testObject.findById(1);
      Assert.assertEquals(expected, actual);
      assertNull(testObject.findById(0));

    }

    @Test
    public void find_name_test() {
        testObject.saveCourse(courseTest);
        List<Course> list = new ArrayList<>();
        list.add(courseTest);
        Assert.assertEquals(list, testObject.findByName("java"));
    }

    @Test
    public void find_date_test(){
        testObject.saveCourse(courseTest);
        List<Course> list = new ArrayList<>();
        list.add(courseTest);
        List<Course> result = testObject.findByDate(LocalDate.parse("2019-09-25"));
        Assert.assertEquals(list,result);
    }
    @Test
    public void find_all_test() {
        List<Course> test = testObject.findAll();
        assertEquals(CourseDaoList.getCourses(),test);

    }
    @Test
    public void remove_Course_test() {
        boolean remove = testObject.removeCourse(courseTest);
        assertFalse(remove);
    }


}
