public class Main {
    public static void main(String[] args) {

        CourseRegistrationSystem system = new CourseRegistrationSystem();


        Student s1 = new Student("S101", "Lithika", "lithika@gmail.com");
        Student s2 = new Student("S102", "Seetha", "seetha@gmail.com");
        Student s3 = new Student("S103", "Ram", "ram@gmail.com");

        system.registerStudent(s1);
        system.registerStudent(s2);
        system.registerStudent(s3);


        Schedule sA = new Schedule("Monday", "10:00", "12:00");
        Schedule sB = new Schedule("Monday", "11:00", "13:00");
        Schedule sC = new Schedule("Tuesday", "09:00", "10:00");


        Course c1 = new Course("CSE101", "Data Structures", "Dr. Arjun", 2, sA);
        Course c2 = new Course("CSE102", "Algorithms", "Dr. Priya", 2, sB);
        Course c3 = new Course("CSE103", "Operating Systems", "Dr. Kumar", 1, sC);

        system.addCourse(c1);
        system.addCourse(c2);
        system.addCourse(c3);

        System.out.println("------- ENROLL STUDENTS (NORMAL + WAITLIST) --------");


        system.enrollStudent(s1, c1);
        system.enrollStudent(s2, c1);


        system.enrollStudent(s3, c1);

        System.out.println("\n------- SCHEDULE CONFLICT CHECK --------");


        system.enrollStudent(s1, c2);

        System.out.println("\n------- NO-CONFLICT COURSE ENROLL --------");


        system.enrollStudent(s1, c3);

        System.out.println("\n------- DROP COURSE (AUTO ENROLL FROM WAITLIST) --------");

        system.dropCourse(s1, c1);
        c1.showEnrolledStudents();

        c2.showEnrolledStudents();
    }
}
