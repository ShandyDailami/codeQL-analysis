public class java_23226_SessionManager_A08 {
    private SessionFactory sessionFactory;

    public java_23226_SessionManager_A08(String driver, String url, String username, String password, String dialect) {
        this.sessionFactory = createSessionFactory(driver, url, username, password, dialect);
    }

    private SessionFactory createSessionFactory(String driver, String url, String username, String password, String dialect) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClass(DriverManager.getDriver(driver));
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        Properties properties = new Properties();
        properties.setProperty("dialect", dialect);
        properties.setProperty("show_sql", "true");

        return new org.hibernate.cfg.Configuration().configure(properties).buildSessionFactory(dataSource);
    }

    public Session openSession() {
        return this.sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void save(Object object) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        closeSession(session);
    }

    public void update(Object object) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        closeSession(session);
    }

    public void delete(Object object) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        closeSession(session);
    }

    public <T> T findById(Class<T> clazz, Serializable id) {
        Session session = openSession();
        T entity = session.get(clazz, id);
        closeSession(session);
        return entity;
    }
}