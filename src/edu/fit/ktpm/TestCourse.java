package edu.fit.ktpm;

import java.util.Scanner;

/**
 * @description: This class is a test class for Course
 * @author: Dung, Dao Tien Dung
 * @version: 1.0
 * @created: 8/22/2024 8:34 PM
 */
public class TestCourse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, department,credit);
                    if (courseList.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }
                }
                case 2 -> {
                    System.out.println("Course List");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    System.out.println("-------------------------------------------------------------");
                }
                case 3 -> {
                    System.out.println("Remove a course");
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    Course course = new Course();
                    course.setId(id);
                    if (courseList.removeCourse(id)) {
                        System.out.println("Course removed successfully!");
                    } else {
                        System.out.println("Course not removed!");
                    }

                }
                default ->
                        System.out.println("Invalid choice!");
            }
        } while (choice != 0);

    }

    private static void initData(CourseList courseList) {
        Course course1 = new Course("FIT101", "Java Programming","FIT",3);
        Course course2 = new Course("FIT102", "Web Programming", "FIT",3);
        Course course3 = new Course("FIT103", "Database Programming", "FIT",3);
        Course course4 = new Course("FIT104", "Mobile Programming", "FIT",3);
        Course course5 = new Course("FIT105", "Software Engineering", "FIT",3);
        Course course6 = new Course("FIT106", "Data Science", "FIT",3);
        Course course7 = new Course("FIT107", "Machine Learning","FIT",3);
        Course course8 = new Course("FIT108", "Artificial Intelligence","FIT",3);


        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        courseList.addCourse(course6);
        courseList.addCourse(course7);
        courseList.addCourse(course8);
    }
}
