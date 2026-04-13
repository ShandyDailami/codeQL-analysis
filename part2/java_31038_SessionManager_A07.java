import java.util.HashMap;
import java.util.Map;

public class java_31038_SessionManager_A07 {
    // Define a hash map to simulate session storage
    private Map<String, Session> sessionMap;

    // Initialize the hash map
    public java_31038_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String userName) {
        if (sessionMap.containsKey(userName)) {
            throw new RuntimeException("Session already exists for user " + userName);
        }
        Session session = new Session(userName);
        sessionMap.put(userName, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String userName) {
        if (!sessionMap.containsKey(userName)) {
            throw new RuntimeException("No session exists for user " + userName);
        }
        return sessionMap.get(userName);
    }

    // Session class
    public static class Session {
        private String userName;

        public java_31038_SessionManager_A07(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}