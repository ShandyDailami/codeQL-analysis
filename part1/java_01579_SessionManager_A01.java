public class java_01579_SessionManager_A01 {
    private static SessionFactory sessionFactory = null;
    private java_01579_SessionManager_A01() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            } catch (ExceptionInInitializerError e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

public interface Session {
    void openSession();
    void closeSession();
    Object get(String id);
    void save(Object entity);
    void update(Object entity);
    void delete(Object entity);
}

public class MySession implements Session {
    org.hibernate.Session session = null;

    @Override
    public void openSession() {
        session = SessionFactory.getSessionFactory().openSession();
    }

    @Override
    public void closeSession() {
        session.close();
    }

    @Override
    public Object get(String id) {
        return session.get(id);
    }

    @Override
    public void save(Object entity) {
        session.save(entity);
    }

    @Override
    public void update(Object entity) {
        session.update(entity);
    }

    @Override
    public void delete(Object entity) {
        session.delete(entity);
    }
}