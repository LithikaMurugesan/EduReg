import java.util.*;

public class Course {
    private String courseId;
    private String courseName;
    private String instructor;
    private int maxSeats;
    private List<Enrollment> enrollments;

    private Queue<Student> waitlist;

    public Course(String courseId, String courseName, String instructor, int maxSeats) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.maxSeats = maxSeats;
        this.enrollments = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }

    public String getCourseName() { return courseName; }
    public int getMaxSeats() { return maxSeats; }
    public int getEnrolledCount() { return enrollments.size(); }

    public boolean hasSeat() {
        return enrollments.size() < maxSeats;
    }

    public boolean addEnrollment(Enrollment enrollment) {
        if (!hasSeat()) return false;
        enrollments.add(enrollment);
        return true;
    }


    public void addToWaitlist(Student student) {
        waitlist.offer(student);
        System.out.println(student.getName() + " added to waitlist for " + courseName);
    }


    public Student popWaitlistedStudent() {
        return waitlist.poll(); // FIFO
    }

    public boolean hasWaitlist() {
        return !waitlist.isEmpty();
    }

    public void removeEnrollment(Student student) {
        enrollments.removeIf(e -> e.getStudent().equals(student));
    }
}
