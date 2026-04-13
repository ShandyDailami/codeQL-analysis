import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_19652_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_19652_SessionManager_A03() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    public static void main(String[] args) {
        // creating the User
        User user = new User("John", "Doe", "john@example.com", "123456789");

        // creating the SessionManager
        SessionManager sessionManager = new SessionManager();

        // saving the user
        sessionManager.saveUser(user);
    }
}