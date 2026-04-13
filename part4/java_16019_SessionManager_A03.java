import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_16019_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_16019_SessionManager_A03() {
        configure();
    }

    private void configure() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session getSession() {
        Session session = sessionFactory.openSession();
        session.setCallback(new MyCallback());
        return session;
    }

    private class MyCallback implements SessionCallback {
        public void beforeTransaction(Session session) {
            System.out.println("Starting session: " + session.getId());
        }

        public void afterTransaction(Session session) {
            System.out.println("Ending session: " + session.getId());
        }

        public void afterTransactionCompletion(Session session, Transaction tx) {
            System.out.println("Completed session: " + session.getId());
        }

        public void beforeQuery(Session session, String query) {
            System.out.println("Executing query: " + query);
        }

        public void afterQuery(Session session, String query, Object result) {
            System.out.println("Query result: " + result);
        }
    }
}