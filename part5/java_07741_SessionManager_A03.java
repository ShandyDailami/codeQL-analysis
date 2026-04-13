public class java_07741_SessionManager_A03 {
    private Session session;
    private String queryString;

    public java_07741_SessionManager_A03(String connectionUrl, String userName, String password) {
        this.queryString = "SELECT * FROM USERS WHERE USERNAME = ?";
        try {
            session = HibernateUtil.buildSessionFactory(connectionUrl, userName, password).openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        User user = null;
        try {
            user = (User) session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByName(String name) {
        User user = null;
        try {
            Query query = session.createQuery(queryString);
            query.setParameter(0, name);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}