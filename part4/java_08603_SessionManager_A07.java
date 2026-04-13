import java.util.*;

public class java_08603_SessionManager_A07 {
    private Map<String, UserSession> sessions;

    public java_08603_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(User user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new UserSession(user));
        return sessionId;
    }

    public void addUserToSession(String sessionId, User user) {
        if (sessions.containsKey(sessionId)) {
            sessions.get(sessionId).addUser(user);
        } else {
            System.out.println("Session not found!");
        }
    }

    public User getUserFromSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId).getUser();
        } else {
            System.out.println("Session not found!");
            return null;
        }
    }

    // UserSession and User classes are not shown in the question, create them as per your requirements.
    private class UserSession {
        private User user;

        public java_08603_SessionManager_A07(User user) {
            this.user = user;
        }

        public void addUser(User user) {
            this.user = user;
        }

        public User getUser() {
            return this.user;
        }
    }
}