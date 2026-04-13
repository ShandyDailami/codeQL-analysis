import java.util.HashMap;

public class java_40109_SessionManager_A01 {
    private HashMap<Integer, String> sessionMap;
    private int sessionIdCounter;

    public java_40109_SessionManager_A01() {
        sessionMap = new HashMap<>();
        sessionIdCounter = 0;
    }

    public int createSession() {
        sessionIdCounter++;
        sessionMap.put(sessionIdCounter, "Session ID: " + sessionIdCounter);
        return sessionIdCounter;
    }

    public void deleteSession(int sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSession(int sessionId) {
        return sessionMap.get(sessionId);
    }
}