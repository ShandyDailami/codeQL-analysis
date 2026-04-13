public class java_16774_SessionManager_A01 {
    private Session session;

    public java_16774_SessionManager_A01() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession() {
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.getSession().beginTransaction();
        manager.getSession().save(new User("username", "password"));
        manager.getSession().getTransaction().commit();
        manager.closeSession();
    }
}

class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
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
}

class User {
    private String username;
    private String password;

    public java_16774_SessionManager_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters
}