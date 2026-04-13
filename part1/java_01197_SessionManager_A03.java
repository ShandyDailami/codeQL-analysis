import java.util.HashMap;

public class java_01197_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_01197_SessionManager_A03() {
        sessionMap = new HashMap<String, String>();
    }

    public void createSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionId);
        } else {
            System.out.println("Session already exists!");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No such session exists!");
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }
}