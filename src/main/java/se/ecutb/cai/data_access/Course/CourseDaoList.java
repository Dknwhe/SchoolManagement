package se.ecutb.cai.data_access.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {

    private static List<Course> courses;
    public CourseDaoList() {
        courses = new ArrayList<>();
    }


    @Override
    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for(Course course : courses) {
            if (course.getId() == id ) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> c = new ArrayList<>();
        for(Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(name)) {
                c.add(course);
            }
        }
        return c;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> c = new ArrayList<>();
        for(Course course : courses) {
            if (course.getStartDate().isEqual(date)) {
                c.add(course);
            }
        }
        return c;
    }

    public static List<Course> getCourses() {
        return courses;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
            return courses.remove(course);
    }
}
