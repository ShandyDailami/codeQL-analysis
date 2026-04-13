public class java_08293_SessionManager_A07 {

    private static final Map<String, Session> sessionMap = new HashMap<>();

    public static Session getSession(String userId) {
        return sessionMap.get(userId);
    }

    public static void createSession(String userId, Session session) {
        sessionMap.put(userId, session);
    }

    public static void closeSession(String userId) {
        sessionMap.remove(userId);
    }

    public static void updateSession(String userId) {
        // In a real-world application, you would need to implement this.
        // For example, you might want to invalidate the session and create a new one.
        sessionMap.remove(userId);
        Session newSession = new Session(userId);
        sessionMap.put(userId, newSession);
    }
}

class Session {
    private String userId;

    public java_08293_SessionManager_A07(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}