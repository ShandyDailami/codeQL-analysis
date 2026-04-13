public class java_04195_SessionManager_A03 {

    private Session session;

    public java_04195_SessionManager_A03() {
        this.session = this.getSession();
    }

    private Session getSession() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "password";

            Session session = SessionFactory.openSession(url, username, password);

            return session;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void openSession() {
        if (session == null || !session.isOpen()) {
            session = this.getSession();
        }
    }

    public void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void persist(Object object) {
        if (session != null) {
            session.persist(object);
        } else {
            throw new RuntimeException("Session is null, cannot persist object");
        }
    }

    public void merge(Object object) {
        if (session != null) {
            session.merge(object);
        } else {
            throw new RuntimeException("Session is null, cannot merge object");
        }
    }

    public void delete(Object object) {
        if (session != null) {
            session.delete(object);
        } else {
            throw new RuntimeException("Session is null, cannot delete object");
        }
    }

    public void beginTransaction() {
        if (session != null) {
            session.beginTransaction();
        } else {
            throw new RuntimeException("Session is null, cannot begin transaction");
        }
    }

    public void commitTransaction() {
        if (session != null) {
            session.getTransaction().commit();
        } else {
            throw new RuntimeException("Session is null, cannot commit transaction");
        }
    }

    public void rollbackTransaction() {
        if (session != null) {
            session.getTransaction().rollback();
        } else {
            throw new RuntimeException("Session is null, cannot rollback transaction");
        }
    }
}