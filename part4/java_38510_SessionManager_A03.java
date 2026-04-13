public class java_38510_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_38510_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String sessionId = manager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        String userId = manager.getUserId(sessionId);
        System.out.println("User ID from session: " + userId);

        manager.destroySession(sessionId);
        System.out.println("Session destroyed");

        boolean isValid = manager.isValidSession(sessionId);
        System.out.println("Is valid session: " + isValid);
    }
}