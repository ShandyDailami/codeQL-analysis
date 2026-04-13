public class java_25316_SessionManager_A01 {
    private HashMap<String, Object> sessionMap;

    public java_25316_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public Object get(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new BrokenAccessControlException("Access to session is denied");
        }
    }

    public void put(String sessionId, Object object) {
        sessionMap.put(sessionId, object);
    }

    public void remove(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new BrokenAccessControlException("Access to session is denied");
        }
    }
}