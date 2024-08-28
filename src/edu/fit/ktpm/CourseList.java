package edu.fit.ktpm;

/**
 * @description: This class is used to represent a course list
 * @author: Dung, Dao Tien Dung
 * @version: 1.0
 * @created: 8/22/2024 8:34 PM
 */
public class CourseList {

    private Course[] courses;
    private static int count = 0;


    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n]; // create an array of n elements
    }

    /**
     * Description: Add a course to the list
     * @param course
     * @return true if the course is added successfully, false otherwise
     * @throws IllegalArgumentException if the course is null, the course already exists, or the array is full
     */
    public boolean addCourse(Course course) {
        //  check if course is null
        if(course == null)
            return false;
        //  check if course already exists
        if(exists(course)) //Check if id of course duplicate
            return false;
        //  check if the array is full
        if (count == courses.length)
            return false;
        //  add course to the array
        courses[count++] = course;
        return true;
    }
    /**
     * Description: Remove a course to the list
     * @param id
     * @return true if the course is removed successfully, false otherwise
     * @throws IllegalArgumentException if the id is null or the array is empty
     */
    public boolean removeCourse(String id) {
        //  check if id is null
        if(id == null)
            return false;
        //  check if the array is empty
        if (count == 0)
            return false;
        //  find the course with the given id
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                index = i;
                break;
            }
        }
        //  check if the course is not found
        if (index == -1)
            return false;
        //  remove the course from the array
        for (int i = index; i < count - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courses[--count] = null;
        return true;
    }
    /**
     * Description: Check if the course exists in the list, based on the course ID
     * @param course The course to check
     * @return true if the course exists, false otherwise
     */
    private boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }

    public Course[] getCourses() {
        return courses;
    }
}
