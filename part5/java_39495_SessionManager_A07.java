public class java_39495_SessionManager_A07 {
    private static SessionManager instance;
    private Map<String, String> database; // A simple in-memory database

    private java_39495_SessionManager_A07() {
        database = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession(String sessionId) {
        database.put(sessionId, "open");
    }

    public void closeSession(String sessionId) {
        database.put(sessionId, "closed");
    }

    public String getSessionState(String sessionId) {
        return database.get(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();

        String sessionId = "session1";
        sessionManager.openSession(sessionId);

        System.out.println("Session state: " + sessionManager.getSessionState(sessionId));

        sessionManager.closeSession(sessionId);

        System.out.println("Session state after closing: " + sessionManager.getSessionState(sessionId));
    }
}