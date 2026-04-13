public class java_13013_SessionManager_A08 {
    private static SessionManager instance;
    private Session session;

    private java_13013_SessionManager_A08() {
        // Loading the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java Connector couldn'
at loading");
            e.printStackTrace();
        }

        // Creating a new session with the MySQL server
        session = Session.getActiveSession();
        if (session == null || session.getTransaction().isActive()) {
            session = Session.builder().build();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commitTransaction() {
        session.getTransaction().commit();
    }

    public void rollbackTransaction() {
        session.getTransaction().rollback();
    }

    public void save(Object object) {
        session.save(object);
    }

    public <T> T find(Class<T> clazz, Object id) {
        return session.find(clazz, id);
    }

    public <T> List<T> findAll(Class<T> clazz) {
        Criteria criteria = session.createCriteria(clazz);
        return (List<T>) criteria.list();
    }

    public <T> void delete(T object) {
        session.delete(object);
    }

    public void closeSession() {
        session.close();
    }
}