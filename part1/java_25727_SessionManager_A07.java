import java.util.HashMap;

public class java_25727_SessionManager_A07 {
    private HashMap<String, Session> sessionMap;

    public java_25727_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSession(String sessionId, Session session) {
        sessionMap.put(sessionId, session);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean login(String username, String password) {
        // Simulate authentication by checking if username and password match
        if (username.equals("admin") && password.equals("password")) {
            // Generate a session ID if authentication is successful
            String sessionId = username + System.currentTimeMillis();
            setSession(sessionId, new Session(username));
            return true;
        } else {
            return false;
        }
    }

    public void logout(String sessionId) {
        removeSession(sessionId);
    }
}