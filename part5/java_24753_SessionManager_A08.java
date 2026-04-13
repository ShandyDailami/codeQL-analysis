public class java_24753_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_24753_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void setSession(String sessionId, String sessionData) {
        sessions.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void integrityCheck(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("A08_IntegrityFailure: Session " + sessionId + " does not exist.");
        }
    }
}