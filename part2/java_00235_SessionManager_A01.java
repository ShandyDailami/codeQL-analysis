public class java_00235_SessionManager_A01 {
    private static SessionManager instance;
    private HashMap<String, String> sessionMap;

    private java_00235_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public String getSessionId(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            String newSessionId = UUID.randomUUID().toString();
            sessionMap.put(userId, newSessionId);
            return newSessionId;
        }
    }

    public void endSession(String sessionId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                sessionMap.remove(entry.getKey());
                break;
            }
        }
    }

    public boolean validateSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId).equals(sessionId);
        } else {
            return false;
        }
    }
}