package se.ecutb.cai.data_access.Course;

import se.ecutb.cai.data_access.Student.Student;
import se.ecutb.cai.data_access.Student.StudentDaoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private static int courseCounter;
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student>students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration){
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = new ArrayList<>();

    }
    public Course(String courseName, LocalDate startDate, int courseDuration) {

        this (++courseCounter,courseName,startDate,courseDuration);

    }

    public void register(Student student ) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void unregister(Student student) {
        students.remove(student);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }

}
