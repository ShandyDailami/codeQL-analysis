public class java_04837_SessionManager_A01 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_04837_SessionManager_A01() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void save(Object object) {
        Session session = openSession();
        session.save(object);
        closeSession(session);
    }

    public void update(Object object) {
        Session session = openSession();
        session.update(object);
        closeSession(session);
    }

    public void delete(Object object) {
        Session session = openSession();
        session.delete(object);
        closeSession(session);
    }

    public void query(String hql) {
        Session session = openSession();
        Query query = session.createQuery(hql);
        List results = query.list();
        closeSession(session);

        // Print results
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}