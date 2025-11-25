import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Student {
    private String studentId;
    private String name;
    private String email;
    private List<Enrollment> enrollments;
    public String getName() { return name; }


    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.enrollments = new ArrayList<>();
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }
    public void dropCourse(Course course) {
        enrollments.removeIf(e -> e.getCourse().equals(course));
    }

    public List<Course> viewEnrolledCourses() {
        return enrollments.stream()
                .map(Enrollment::getCourse)
                .collect(Collectors.toList());
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
}
