import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_09238_SessionManager_A01 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // The following code is secure. The session is opened and a transaction is started.
        // The session is then used to execute a query to select a user, which is secure because the user's password is not included in the query.
        // After running the query, the session is closed and the transaction is committed.

        session.getTransaction().commit();
        session.close();
    }
}