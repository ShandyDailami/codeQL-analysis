public class java_36714_SessionManager_A08 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_36714_SessionManager_A08() {
        initializeSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        StandardServiceRegistry registry = builder.build();
        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void save(Object entity) {
        Session session = openSession();
        try {
            session.save(entity);
            session.flush();
        } finally {
            session.close();
        }
    }

    public void update(Object entity) {
        Session session = openSession();
        try {
            session.update(entity);
            session.flush();
        } finally {
            session.close();
        }
    }

    public void delete(Object entity) {
        Session session = openSession();
        try {
            session.delete(entity);
            session.flush();
        } finally {
            session.close();
        }
    }

    public void deleteById(Class clazz, int id) {
        Session session = openSession();
        try {
            Object entity = session.get(clazz, id);
            if (entity != null) {
                session.delete(entity);
            }
            session.flush();
        } finally {
            session.close();
        }
    }

    public void deleteAll(Class clazz) {
        Session session = openSession();
        try {
            Query query = session.createQuery("delete from " + clazz.getName());
            query.executeUpdate();
        } finally {
            session.close();
        }
    }
}