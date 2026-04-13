public class java_33903_SessionManager_A01 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_33903_SessionManager_A01() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession(boolean create) {
        return sessionFactory.openSession(create);
    }

    public void closeSession(Session session) {
        session.close();
    }

    public void save(Object object) {
        Session session = getSession(true);
        session.save(object);
        closeSession(session);
    }

    public void update(Object object) {
        Session session = getSession(true);
        session.update(object);
        closeSession(session);
    }

    public void delete(Object object) {
        Session session = getSession(true);
        session.delete(object);
        closeSession(session);
    }

    public void query(Criteria criteria) {
        Session session = getSession(true);
        Query query = session.createCriteria(criteria.getEntity());
        criteria.getProperties().forEach((property, value) -> {
            query.add(Criteria.Property(property).value(value));
        });
        List results = query.list();
        results.forEach(result -> {
            // Perform operations on each result, for example:
            // System.out.println(result);
        });
        closeSession(session);
    }
}

public class Criteria {
    private Class entity;
    private Map<String, Object> properties;

    public java_33903_SessionManager_A01(Class entity) {
        this.entity = entity;
        this.properties = new HashMap<>();
    }

    public Class getEntity() {
        return entity;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Criteria addProperty(String name, Object value) {
        properties.put(name, value);
        return this;
    }
}