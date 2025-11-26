
public class Enrollment {
    private Student student;
    private Course course;
    private String grade;

    public Enrollment(Student student, Course course) {

        if (!course.hasSeat()) {
            throw new RuntimeException("Cannot enroll. Course is full.");
        }

        this.student = student;
        this.course = course;
        course.addEnrollment(this);
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public String getGrade() { return grade; }

    public void assignGrade(String grade) {
        this.grade = grade;
    }
}
