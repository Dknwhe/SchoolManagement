package se.ecutb.cai.data_access;

import se.ecutb.cai.data_access.Course.Course;
import se.ecutb.cai.data_access.Course.CourseDaoList;
import se.ecutb.cai.data_access.Student.Student;
import se.ecutb.cai.data_access.Student.StudentDaoList;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentManagement2 {

    private StudentDaoList studentDaoList = new StudentDaoList();
    private CourseDaoList courseDaoList = new CourseDaoList();
    private Student student3 = new Student("Cai","hemma@live.se","heemma");
    private Course course3 = new Course("Java",LocalDate.parse("2019-09-29"),15);

    public void School() {
        Scanner scanner = new Scanner(System.in);
        boolean play = true;
        while (play) {

            System.out.println("SchoolManagement" + scanner.nextLine());
            System.out.println("[1] Create Student & Create Course " + " [2] Register Student To Course & Remove Student From Course ");
            System.out.println("[3] Find Student   & Find Course   " + " [4] Edit Students              & Edit Courses ");
            System.out.println("--------------------------------------------[5] Exit-------------------------------------------");

            String menu = scanner.nextLine();
            switch (menu) {
                case "1":
                        System.out.println("1: Create Student 2: Create Course ");
                        String menu1 = scanner.nextLine();
                    if (menu1.equalsIgnoreCase("1"))
                    {
                        System.out.println("Student ID: ");
                        String studentID = scanner.nextLine();
                        int studentId = Integer.parseInt(studentID);

                        System.out.println("Student Name: ");
                        String studentName = scanner.nextLine();
                        System.out.println("Student Email: ");
                        String studentEmail = scanner.nextLine();
                        System.out.println("Student Address: ");
                        String studentAddress = scanner.nextLine();

                        Student createStudent = new Student(studentId, studentName, studentEmail, studentAddress);
                        System.out.println("Successfully Created " + createStudent + "\n3 Menu");
                        studentDaoList.saveStudent(createStudent);
                    } else if
                        (menu1.equalsIgnoreCase("2"))
                    {
                        System.out.println("Course ID ");
                        String courseID = scanner.nextLine();
                        int courseId = Integer.parseInt(courseID);

                        System.out.println("Course Name: ");
                        String createCourse = scanner.nextLine();
                        System.out.println("Date: ex 1992-06-08 ");
                        String date = scanner.nextLine();
                        LocalDate start = LocalDate.parse(date);

                        System.out.println("Duration Course Week: ");
                        String courseDuration = scanner.nextLine();
                        int end = Integer.parseInt(courseDuration);

                        Course createdCourse = new Course(courseId, createCourse, start, end);
                        System.out.println("Successfully Created " + createdCourse + "\n3 Menu ");
                        courseDaoList.saveCourse(createdCourse);
                    }
                    break;

                case "2":
                        System.out.println("1: Register Student 2: Remove Student ");
                        String menu2 = scanner.nextLine();
                    if  (menu2.equalsIgnoreCase("1"))
                    {
                        System.out.println("Enter the Student ID: ");
                        String studentID = scanner.nextLine();
                        int getStudentID = Integer.parseInt(studentID);

                        studentDaoList.findById(getStudentID);
                        course3.register(student3);
                        System.out.println(student3);
                        System.out.println("Save Student: Enter");
                        System.out.println(scanner.nextLine() + studentDaoList.saveStudent(student3)
                                                              + "\nSuccessfully" +  "\nMenu 3");

                    } else if (menu2.equalsIgnoreCase("2"))
                    {
                        System.out.println("Enter the Course ID: ");
                        String courseID = scanner.nextLine();
                        int getCourseID = Integer.parseInt(courseID);

                        courseDaoList.findById(getCourseID);
                        System.out.println(course3.getCourseName() + "\nDetails: Enter");
                        System.out.println("Remove Student: \n "+ scanner.nextLine()+  "-"
                                + courseDaoList.saveCourse(course3) + "\nPress Enter to Remove");
                        course3.unregister(student3);
                        System.out.println(scanner.nextLine() + "Successfully\n" + "\nMenu 3");
                    }
                    break;

                case "3":
                        System.out.println("1: Find Student 2: Find Course ");
                        String menu3 = scanner.nextLine();
                    if (menu3.equalsIgnoreCase("1"))
                    {
                        System.out.println("Student Name: ");
                        String studentName = scanner.nextLine();
                        System.out.println(studentDaoList.findByName(studentName)
                                +" Name: " + student3.getName()
                                +" Email: " + student3.getEmail()
                                +" Address: " + student3.getAdress() + "\nMenu 3");

                    } else if (menu3.equalsIgnoreCase("2")) {
                        System.out.println("Course Name: ");
                        String courseName = scanner.nextLine();
                        System.out.println(courseDaoList.findByName(courseName)
                                +" Name: " + course3.getCourseName()
                                +" StartDay: " + course3.getStartDate()
                                +" Week: " + course3.getWeekDuration() + "\nMenu 3");
                    }
                    break;

                case "4":
                        System.out.println("1: Edit Student: Name Email Address 2: Edit Course: Name Duration Week ");
                        String menu4 = scanner.nextLine();
                    if (menu4.equalsIgnoreCase("1"))
                    {
                        System.out.println("Edit Student Name: " + student3.getName());
                        String editName = scanner.nextLine();
                        student3.setName(editName);
                        System.out.println("Done!\n" + editName);

                        System.out.println("\nEdit Student Email: " + student3.getEmail());
                        String editEmail = scanner.nextLine();
                        student3.setEmail(editEmail);
                        System.out.println("Done!\n" + editEmail);

                        System.out.println("\nEdit Student Address: " + student3.getAdress());
                        String editAddress = scanner.nextLine();
                        student3.setAdress(editAddress);
                        System.out.println("Done!\n" + editAddress);
                        System.out.println("Save settings: " + student3 + ("\n3 Menu"));


                    } else if (menu4.equalsIgnoreCase("2"))
                    {
                        System.out.println("Edit Course Name: " + course3.getCourseName());
                        String editCourse = scanner.nextLine();
                        course3.setCourseName(editCourse);
                        System.out.println("Done!\n" + editCourse);

                        System.out.println("\nEdit Course Duration: Ex 2019-09-22");
                        String editDuration = scanner.nextLine();
                        LocalDate date = LocalDate.parse(editDuration);
                        course3.setStartDate(date);
                        System.out.println(date);
                        System.out.println("Done!\n");

                        System.out.println("Edit Course Week: ");
                        String editWeek = scanner.nextLine();
                        try {
                            int week = Integer.parseInt(editWeek);
                            course3.setWeekDuration(week);
                            System.out.println(week);
                        } catch (NumberFormatException ex) {
                        }
                        System.out.println("Save settings:" + course3 + ("\n3 Menu"));
                    }
                    break;

                case "5":
                    System.out.println("Exit");
                    play = false;
                    break;
                }
            }
        }
    public static void main(String[] args) {
        StudentManagement2 run = new StudentManagement2();
        run.School();
    }
}
