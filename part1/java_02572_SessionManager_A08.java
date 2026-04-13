public class java_02572_SessionManager_A08 {
    private Session session;

    public java_02572_SessionManager_A08() {
        session = null;
    }

    public Session openSession() {
        if (session != null) {
            throw new RuntimeException("Session is already open");
        }

        // In a real application, you would normally connect to a database here
        // For this example, we'll just open a session
        session = new Session();
        return session;
    }

    public void closeSession() {
        if (session == null) {
            throw new RuntimeException("Session is already closed");
        }

        // In a real application, you would normally close the session here
        session = null;
    }

    // Other methods as necessary
}

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Open a session
        manager.openSession();

        // Try to open another session
        manager.openSession();
    }
}