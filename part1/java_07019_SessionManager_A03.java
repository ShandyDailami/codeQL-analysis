public class java_07019_SessionManager_A03 {
    private static SessionManager instance;
    private Session session;

    private java_07019_SessionManager_A03() {
        // Using standard libraries for session creation.
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applyConfiguration(configuration)
                .buildServiceRegistry();

        session = configuration.buildSessionFactory(serviceRegistry).openSession();
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

    public void commit() {
        session.getTransaction().commit();
    }

    public void rollback() {
        session.getTransaction().rollback();
    }

    public Object findById(Class cls, Integer id) {
        return session.get(cls, id);
    }

    public void save(Object obj) {
        session.save(obj);
    }

    public void update(Object obj) {
        session.update(obj);
    }

    public void delete(Object obj) {
        session.delete(obj);
    }
}