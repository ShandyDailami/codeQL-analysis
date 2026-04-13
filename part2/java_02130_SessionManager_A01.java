import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_02130_SessionManager_A01 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            // start transaction
            session.beginTransaction();

            // Security-sensitive operation
            session.save(new User(1, "User1"));

            // commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}

class User {
    private int id;
    private String name;

    public java_02130_SessionManager_A01() { }

    public java_02130_SessionManager_A01(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters and setters
}