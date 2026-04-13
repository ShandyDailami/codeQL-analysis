public class java_00178_SessionManager_A08 {
    private Session session;

    public java_00178_SessionManager_A08(String connectionUrl, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession(connectionUrl, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commitTransaction() {
        session.getTransaction().commit();
    }

    public void save(Object object) {
        session.save(object);
    }

    public void update(Object object) {
        session.update(object);
    }

    public void delete(Object object) {
        session.delete(object);
    }

    public Object findById(Class classEntity, Integer id) {
        return session.get(classEntity, id);
    }

    public List<Object> findAll(Class classEntity) {
        return session.createQuery("from " + classEntity.getName()).list();
    }

    public void close() {
        session.close();
    }
}