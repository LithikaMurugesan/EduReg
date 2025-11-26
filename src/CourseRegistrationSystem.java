import java.util.*;

public class CourseRegistrationSystem {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }


    public boolean enrollStudent(Student student, Course course) {


        for (Enrollment e : student.getEnrollments()) {
            if (e.getCourse().getSchedule().conflictsWith(course.getSchedule())) {
                System.out.println("Schedule conflict! "
                        + student.getName() + " cannot enroll in "
                        + course.getCourseName());
                return false;
            }
        }


        if (course.hasSeat()) {
            Enrollment enrollment = new Enrollment(student, course);
            student.addEnrollment(enrollment);
            System.out.println(student.getName() + " enrolled in " + course.getCourseName());
            return true;
        }

        System.out.println("Course full → Adding " + student.getName() + " to waitlist.");
        course.addToWaitlist(student);
        return false;
    }

    public void dropCourse(Student student, Course course) {
        student.dropCourse(course);
        course.removeEnrollment(student);

        System.out.println(student.getName() + " dropped " + course.getCourseName());

        if (course.hasWaitlist()) {
            Student nextStudent = course.popWaitlistedStudent();

            System.out.println("Seat freed! Auto-enrolling " + nextStudent.getName());
            enrollStudent(nextStudent, course);
        }
    }
}
