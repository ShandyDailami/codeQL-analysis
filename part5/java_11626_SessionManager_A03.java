import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.function.Supplier;

public class java_11626_SessionManager_A03 {

    private static Supplier<Session> sessionSupplier;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            SessionFactory sessionFactory = configuration.buildSessionFactory();
            sessionSupplier = () -> sessionFactory.openSession();
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return sessionSupplier.get();
    }

    public static void main(String[] args) {
        Session session = getSession();
        session.beginTransaction();
        // Do some security-sensitive operations
        session.getTransaction().commit();
        session.close();
    }
}