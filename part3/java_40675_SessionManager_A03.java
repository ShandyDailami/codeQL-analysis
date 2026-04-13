public class java_40675_SessionManager_A03 {
    private static HashMap<String, String> sessionMap;

    public java_40675_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Session started");
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }

    // Simple session validation
    public boolean validateSession(String userId, String sessionId) {
        if (sessionMap.containsKey(userId) && sessionMap.get(userId).equals(sessionId)) {
            return true;
        } else {
            return false;
        }
    }
}