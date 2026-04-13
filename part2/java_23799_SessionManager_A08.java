import java.util.HashMap;
import java.util.Map;

public class java_23799_SessionManager_A08 {
    private Map<String, User> sessionMap;

    public java_23799_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, User user) {
        sessionMap.put(sessionId, user);
    }

    public User retrieveUser(String sessionId) throws IntegrityFailure {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IntegrityFailure("Session not found");
        }

        return sessionMap.get(sessionId);
    }

    public static class User {
        private String name;

        public java_23799_SessionManager_A08(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class IntegrityFailure extends Exception {
        public java_23799_SessionManager_A08(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("session1", new SessionManager.User("User1"));

        try {
            User user = sessionManager.retrieveUser("session1");
            System.out.println("User name: " + user.getName());
        } catch (SessionManager.IntegrityFailure e) {
            System.out.println(e.getMessage());
        }
    }
}