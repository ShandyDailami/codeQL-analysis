public class java_27328_SessionManager_A01 {
    private HashMap<String, String> sessionData;

    public java_27328_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionData.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    public void deleteUserFromSession(String userId) {
        for (String sessionId : sessionData.keySet()) {
            if (sessionData.get(sessionId).equals(userId)) {
                sessionData.remove(sessionId);
                break;
            }
        }
    }

    public void updateSessionUser(String sessionId, String newUserId) {
        if (sessionData.containsKey(sessionId)) {
            sessionData.replace(sessionId, newUserId);
        }
    }
}