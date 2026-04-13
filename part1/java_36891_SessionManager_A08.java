public class java_36891_SessionManager_A08 {
    private static SessionManager sessionManager;
    private Session session;

    private java_36891_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory
                    .getInstance()
                    .openSession(
                            ConstraintMode.TRANSACTIONAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void saveUser(User user) {
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
        }
    }

    public User getUserById(int id) {
        User user = null;
        try {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
        }
    }

    public void deleteUser(User user) {
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null)
                session.getTransaction().rollback();
        }
    }
}