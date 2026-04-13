import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_37686_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    // This method is called when we want to open a session
    public static Session openSession() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                ex.printStackTrace();
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory.openSession();
    }

    // This method is called when we want to close a session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // This method is called when we want to get a session and then close it
    public static Session getSessionAndClose(boolean autoCommit) {
        Session session = openSession();
        session.beginTransaction(autoCommit);
        return session;
    }

    // This method is called when we want to get a session and then commit it
    public static Session getSessionAndCommit(boolean autoCommit) {
        Session session = openSession();
        session.beginTransaction(autoCommit);
        return session;
    }

    // This method is used to close all open sessions
    public static void closeAllSessions(boolean commit) {
        for (Session session : openSessions()) {
            if (session != null) {
                if (commit) {
                    session.getTransaction().commit();
                } else {
                    session.close();
                }
            }
        }
    }
}