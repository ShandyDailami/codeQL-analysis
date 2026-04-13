public class java_25776_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_25776_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void beginSession() {
        try {
            sessionFactory.openSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void save(Object obj) {
        sessionFactory.getCurrentSession().save(obj);
    }

    public void update(Object obj) {
        sessionFactory.getCurrentSession().update(obj);
    }

    public void delete(Object obj) {
        sessionFactory.getCurrentSession().delete(obj);
    }

    public void beginTransaction() {
        sessionFactory.getCurrentSession().beginTransaction();
    }

    public void commitTransaction() {
        sessionFactory.getCurrentSession().getTransaction().commit();
    }
}