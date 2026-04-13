public class java_14324_SessionManager_A01 {
    private Session session;

    public java_14324_SessionManager_A01(String connectionUrl, String userName, String password) {
        try {
            session = Session.getSession(connectionUrl, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
            session = null;
        }
    }

    public void startTransaction() {
        if (session != null) {
            session.beginTransaction();
        }
    }

    public void commitTransaction() {
        if (session != null) {
            session.getTransaction().commit();
        }
    }

    public void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    public void performOperation(String operation, Object param) {
        if (session != null) {
            // Use session.performOperation(operation, param)
        }
    }
}