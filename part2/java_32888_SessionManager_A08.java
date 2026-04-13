import java.util.*;

public class java_32888_SessionManager_A08 {
    private Map<String, String> sessions;
    private Map<String, Integer> lifetimes;
    private Map<String, Long> lastAccessTimes;
    private Map<String, String> userPasswords;

    public java_32888_SessionManager_A08() {
        sessions = new HashMap<>();
        lifetimes = new HashMap<>();
        lastAccessTimes = new HashMap<>();
        userPasswords = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        lifetimes.put(sessionId, 0);
        lastAccessTimes.put(sessionId, System.currentTimeMillis());
        return sessionId;
    }

    public void setLifetime(String sessionId, int lifetime) {
        if (sessions.containsKey(sessionId)) {
            lifetimes.put(sessionId, lifetime);
        }
    }

    public void accessSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            lastAccessTimes.put(sessionId, System.currentTimeMillis());
        }
    }

    public void changePassword(String sessionId, String password) {
        if (sessions.containsKey(sessionId)) {
            userPasswords.put(sessionId, password);
        }
    }

    public boolean checkPassword(String sessionId, String password) {
        if (sessions.containsKey(sessionId)) {
            return userPasswords.get(sessionId).equals(password);
        }
        return false;
    }

    public boolean checkLifetime(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return System.currentTimeMillis() - lastAccessTimes.get(sessionId) < lifetimes.get(sessionId);
        }
        return false;
    }
}