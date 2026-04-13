import java.util.HashMap;

public class java_33167_SessionManager_A08 {
    private HashMap<String, User> sessionMap;

    public java_33167_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(User user) {
        sessionMap.put(user.getId(), user);
    }

    public User getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static class User {
        private String id;

        public java_33167_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}