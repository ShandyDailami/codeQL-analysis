public class java_13226_SessionManager_A08 {
    private Session session;

    // Constructor
    public java_13226_SessionManager_A08(String url, String username, String password) {
        try {
            session = HibernateUtil.buildSessionFactory(url, username, password).openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CRUD operations
    public void create(Object entity) {
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read(Object id) {
        try {
            Object entity = session.get(Object.class, id);
            System.out.println("Entity: " + entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Object entity) {
        try {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Object id) {
        try {
            Object entity = session.get(Object.class, id);
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class HibernateUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory() {
        return buildSessionFactory(URL, USERNAME, PASSWORD);
    }

    public static SessionFactory buildSessionFactory(String url, String username, String password) {
        try {
            return new Configuration().configure().configure(url, username, password).buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}