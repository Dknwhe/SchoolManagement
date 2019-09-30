package se.ecutb.cai.data_access;

import se.ecutb.cai.data_access.Course.Course;
import se.ecutb.cai.data_access.Course.CourseDaoList;
import se.ecutb.cai.data_access.Student.Student;
import se.ecutb.cai.data_access.Student.StudentDaoList;

import java.time.LocalDate;
import java.util.Scanner;

public class SchoolManagement1 {

    private StudentDaoList studentDaoList = new StudentDaoList();
    private CourseDaoList courseDaoList = new CourseDaoList();
    private Student student = new Student(1, "hej", "hej@live.se", "hemma");
    private Student student2 = new Student(2, "hejdå", "då@liive.se", "hemmaigen");
    private Course course = new Course(3, "java", LocalDate.parse("2019-09-30"), 10);
    private Course course2 = new Course(4, "cc", LocalDate.parse("2019-10-01"), 11);
    private Scanner scanner = new Scanner(System.in);



     /*
   • Create new Courses and Students
   • Register and remove Students to/from Courses
   • Finding Students and Courses in various ways
   • Edit Students and Courses
    */

    public void UserinterFace() {
        //ublic static void main(String[] args) {

        boolean play = true;
        while (play) {
            System.out.println("SchoolManagement" + scanner.nextLine());
            System.out.println("[1] Create Student & Create Course " + " [2] Register Student To Course & Remove Student From Course ");
            System.out.println("[3] Find Student   & Find Course   " + " [4] Edit Students              & Edit Courses ");
            System.out.println("--------------------------------------------[5] Exit-------------------------------------------");

            String menu = scanner.nextLine();
            switch (menu) {
                case "1":
                        System.out.println("New Student 1 New Course 2");
                        String choose = scanner.nextLine();
                    if  (choose.equalsIgnoreCase("1")) {
                        System.out.println("Student ID ");
                        String studentID = scanner.nextLine();
                        int studentId = Integer.parseInt(studentID);
                        System.out.println("Student Name: ");
                        String studentName = scanner.nextLine();
                        System.out.println("Student Email: ");
                        String studentEmail = scanner.nextLine();
                        System.out.println("Student Address: ");
                        String studentAddress = scanner.nextLine();
                        Student createStudent = new Student(studentId, studentName, studentEmail, studentAddress);
                        System.out.println("Student Vaild " + createStudent   );
                    } else if (choose.equalsIgnoreCase("2")) ;
                {
                        System.out.println("Course Name");
                        String courseName = scanner.nextLine();
                        System.out.println("Course ID: ");
                        String courseID = scanner.nextLine();
                        int courseId = Integer.parseInt(courseID);
                        System.out.println("Date: ex 1992-06-08 ");
                        String start = scanner.nextLine();
                        LocalDate duration = LocalDate.parse(start);
                        System.out.println("Duration Course Week: ");
                        String courseDuration = scanner.nextLine();
                        int end = Integer.parseInt(courseDuration);
                        Course createCourse = new Course(courseId, courseName, duration, end);
                        System.out.println(" Course Valid " + createCourse);
                }
                    break;
                case "2":
                        System.out.println("Register Student 1 Remove Student 2");
                        String menu2 = scanner.nextLine();
                    if  (menu2.equalsIgnoreCase("1")) {
                        System.out.println("Add Student :" + student.getId() + "  " + student.getName());
                        System.out.println("Enter Course ID: ");
                        int courseInput = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter Student ID: ");
                        int studentInput = Integer.parseInt(scanner.nextLine());
                        courseDaoList.findById(courseInput).register(studentDaoList.findById(studentInput));
                    } else if (menu2.equalsIgnoreCase("2")) {
                        System.out.println("Remove Course ID: " + course.getId() + "  " + course.getCourseName());

                        System.out.println("Enter Course ID: ");
                        int courseInput = Integer.parseInt(scanner.nextLine());
                        System.out.println("Students Valid " + courseDaoList.findById(courseInput).getCourseName() + courseDaoList.findById(courseInput).getStudents().toString());
                        System.out.println("Remove Student: ");
                        int studentInput = Integer.parseInt(scanner.nextLine());
                        courseDaoList.findById(courseInput).unregister(studentDaoList.findById(studentInput));
                    }
                    break;
                case "3":
                        System.out.println("Find Student 1 Find Course 2");
                        String menu3 = scanner.nextLine();
                    if  (menu3.equalsIgnoreCase("1")) {
                        System.out.println("Find Student Name: ");
                        String findStudent = scanner.nextLine();
                        System.out.println(studentDaoList.findByName(findStudent));
                    } else if (menu3.equalsIgnoreCase("2")) {
                        System.out.println("Find Course Name: ");
                        String findCourse = scanner.nextLine();
                        System.out.println(courseDaoList.findByName(findCourse));
                    }
                    break;
                case "4":
                        System.out.println("Edit Student 1 Edit Course 2");
                        String menu4 = scanner.nextLine();
                    if  (menu4.equalsIgnoreCase("1")) {
                        System.out.println("Edit Student Name: ");
                        String editName = scanner.nextLine();
                        System.out.println("Edit Student Email: ");
                        String editEmail = scanner.nextLine();
                        System.out.println("Edit Student Address: ");
                        String editAddress = scanner.nextLine();
                        Student studentEdit = new Student(1, editName, editEmail, editAddress);
                        studentDaoList.saveStudent(studentEdit);
                        System.out.println("Student Done!");
                    } else if (menu4.equalsIgnoreCase("2")) {
                        System.out.println("Edit Course Name: ");
                        String editCourseName = scanner.nextLine();
                        System.out.println("Edit Duration Date: ex 1992-09-22 ");
                        LocalDate editDate = LocalDate.parse(scanner.next());
                        System.out.println("Change Date");
                        int newDate = Integer.parseInt(scanner.next());
                        System.out.println("Course Done!");
                        Course courseEdit = new Course(1, editCourseName, editDate, newDate);
                        courseDaoList.saveCourse(courseEdit);
                    }
                    break;
                case "5":
                        System.out.println("Exit 5");
                        String exit = scanner.nextLine();
                    if  (exit.equalsIgnoreCase("5"));
                    break;

            }
        }
    }








    public static void main(String[] args) {
        SchoolManagement1 startSchool = new SchoolManagement1();
        startSchool.UserinterFace();
    }
}

