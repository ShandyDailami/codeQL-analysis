public class java_32474_SessionManager_A08 {
    // Define a HashMap to store session ids and corresponding objects
    private HashMap<String, Session> sessionMap;

    public java_32474_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists");
        }
        Session session = new Session();
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to retrieve a session by id
    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session with id " + sessionId + " does not exist");
        }
        return session;
    }

    // Method to remove a session by id
    public void removeSession(String sessionId) {
        Session session = sessionMap.remove(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session with id " + sessionId + " does not exist");
        }
    }
}