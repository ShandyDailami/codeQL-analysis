public class java_15940_SessionManager_A03 {
    // private SessionFactory sessionFactory;
    private Session currentSession;

    public java_15940_SessionManager_A03() {
        // sessionFactory = new Configuration().configure().buildSessionFactory();
        // currentSession = sessionFactory.openSession();
        // If you are using Hibernate, you would get a Session object by calling sessionFactory.openSession()
    }

    public void startSession() {
        // currentSession = sessionFactory.openSession();
        // If you are using Hibernate, you would get a Session object by calling sessionFactory.openSession()
    }

    public void update(String hql) {
        // currentSession.createQuery(hql).executeUpdate();
        // If you are using Hibernate, you would use currentSession.createQuery(hql).executeUpdate()
    }

    public void delete(String hql) {
        // currentSession.createQuery(hql).executeUpdate();
        // If you are using Hibernate, you would use currentSession.createQuery(hql).executeUpdate()
    }

    public void save(Object obj) {
        // currentSession.save(obj);
        // If you are using Hibernate, you would use currentSession.save(obj)
    }

    public void commit() {
        // currentSession.getTransaction().commit();
        // If you are using Hibernate, you would use currentSession.getTransaction().commit()
    }

    public void rollback() {
        // currentSession.getTransaction().rollback();
        // If you are using Hibernate, you would use currentSession.getTransaction().rollback()
    }

    public void closeSession() {
        // currentSession.close();
        // If you are using Hibernate, you would use currentSession.close()
    }
}