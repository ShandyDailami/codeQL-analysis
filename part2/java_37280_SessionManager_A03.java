import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_37280_SessionManager_A03 {

    private static SessionFactory sessionFactory;  

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();

                ServiceRegistry serviceRegistry = new ServiceRegistry();
                serviceRegistry.applySettings(configuration.getProperties());

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Session getSession(boolean create) {
        return getSessionFactory().openSession();
    }

    public static Session getCurrentSession() {
        return getSession(false);
    }

    public static void main(String[] args) {
        Session session = getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            // Perform your operations here
            // Example:
            // session.save(user);

            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        session.close();
    }
}