import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_08784_SessionManager_A07 {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        // create session
        Session session = factory.openSession();

        // start transaction
        session.beginTransaction();

        // insert the user
        User user = new User("John", "Doe");
        session.save(user);

        // commit transaction
        session.getTransaction().commit();

        // close session factory
        factory.close();
    }
}

class User {
    private String firstName;
    private String lastName;

    public java_08784_SessionManager_A07(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // getters and setters
}