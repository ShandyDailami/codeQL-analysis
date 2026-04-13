// A03_Injection - Security-sensitive operations

import java.util.HashMap;
import java.util.Map;

public class java_12203_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_12203_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public String getSessionValue(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Session not found!");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Session not found!");
        }
    }
}

// Main method for testing
public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // create session
        sessionManager.createSession("session1", "value1");

        // get session value
        System.out.println("Session Value: " + sessionManager.getSessionValue("session1"));

        // delete session
        sessionManager.deleteSession("session1");

        // try to get deleted session value
        try {
            System.out.println("Session Value: " + sessionManager.getSessionValue("session1"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}