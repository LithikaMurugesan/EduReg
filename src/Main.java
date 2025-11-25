public class Main {
    public static void main(String[] args) {

        CourseRegistrationSystem system = new CourseRegistrationSystem();

        Student s1 = new Student("S101", "Lithika", "lithika@gmail.com");
        Student s2 = new Student("S102", "Seetha", "seetha@gmail.com");
        Student s3 = new Student("S103", "Ram", "ram@gmail.com");

        system.registerStudent(s1);
        system.registerStudent(s2);
        system.registerStudent(s3);

        Course c1 = new Course("CSE101", "Data Structures", "Dr. Arjun", 2);

        system.addCourse(c1);

        system.enrollStudent(s1, c1);
        system.enrollStudent(s2, c1);
        system.enrollStudent(s3, c1);

        System.out.println("\nDropping a course...");
        system.dropCourse(s1, c1);
    }
}
