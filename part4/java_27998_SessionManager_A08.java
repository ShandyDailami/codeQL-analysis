public class java_27998_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_27998_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        this.sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }
}