public class java_11221_SessionManager_A08 {
    private Session session;

    public java_11221_SessionManager_A08(String connectionUrl, String userName, String password) {
        this.session = HibernateUtil.getSessionFactory(connectionUrl, userName, password)
                .openSession();
    }

    public void save(Object obj) {
        this.session.beginTransaction();
        this.session.save(obj);
        this.session.getTransaction().commit();
    }

    public void update(Object obj) {
        this.session.beginTransaction();
        this.session.update(obj);
        this.session.getTransaction().commit();
    }

    public void delete(Object obj) {
        this.session.beginTransaction();
        this.session.delete(obj);
        this.session.getTransaction().commit();
    }

    public Object getById(Class cls, Serializable id) {
        return this.session.get(cls, id);
    }
}