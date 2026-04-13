import java.util.HashMap;

public class java_38927_SessionManager_A01 {
    private HashMap<String, UserSession> sessionMap;

    public java_38927_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(User user) {
        String sessionId = user.getUserId() + System.currentTime();
        UserSession userSession = new UserSession(user);
        sessionMap.put(sessionId, userSession);
        return sessionId;
    }

    public User getUserFromSession(String sessionId) {
        UserSession userSession = sessionMap.get(sessionId);
        if (userSession != null) {
            return userSession.getUser();
        }
        return null;
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This is a simple example of a UserSession class. It is not secure against brute-force attacks.
    private class UserSession {
        private User user;

        public java_38927_SessionManager_A01(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}