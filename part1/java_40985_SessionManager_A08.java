import java.util.HashSet;
import java.util.Set;

public class java_40985_SessionManager_A08 {

    private String name;
    private Set<Student> enrolledStudents;
    private Session session;

    public java_40985_SessionManager_A08(String name) {
        this.name = name;
        enrolledStudents = new HashSet<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.enroll(this);
    }

    public void dropStudent(Student student) {
        enrolledStudents.remove(student);
        student.drop(this);
    }

    public void createSession(String date, String time) {
        session = new Session(date, time);
    }

    public void closeSession() {
        session.close();
    }

    public static class Student {

        private String name;
        private Course enrolledCourse;

        public java_40985_SessionManager_A08(String name) {
            this.name = name;
        }

        public void enroll(Course course) {
            enrolledCourse = course;
        }

        public void drop(Course course) {
            enrolledCourse = null;
        }
    }

    public static class Session {

        private String date;
        private String time;

        public java_40985_SessionManager_A08(String date, String time) {
            this.date = date;
            this.time = time;
        }

        public void close() {
            // some logic to close the session
        }
    }
}