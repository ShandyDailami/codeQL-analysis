import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_27479_SessionManager_A03 {

    private static SessionFactory sessionFactory;   // hibernate the session factory;
    private Session session;

    // This method will be called by the thread that will run the test.
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.openSession();
        sessionManager.beginSession();
        sessionManager.saveUser(new User("admin", "password"));
        sessionManager.closeSession();
        sessionManager.close();
    }

    public SessionFactory openSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public Session openSession() {
        if (sessionFactory == null) {
            openSessionFactory();
        }
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public void beginSession() {
        session = openSession();
        session.beginTransaction();
    }

    public void saveUser(User user) {
        session.save(user);
        session.getTransaction().commit();
    }

    public void closeSession() {
        session.close();
    }

    public static class User {
        private String name;
        private String password;

        public java_27479_SessionManager_A03(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}