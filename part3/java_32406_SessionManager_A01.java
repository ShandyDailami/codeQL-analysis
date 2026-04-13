import java.util.HashMap;

public class java_32406_SessionManager_A01 {

    private static int sessionCount = 0;
    private HashMap<Integer, String> sessionMap = new HashMap<>();

    public String createSession() {
        sessionCount++;
        String sessionId = "S" + sessionCount;
        sessionMap.put(sessionCount, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        Integer sessionCount = sessionMap.get(sessionId);
        if (sessionCount == null) {
            return null;
        }
        return "Session ID: " + sessionCount + ", Session ID: " + sessionMap.get(sessionCount);
    }

    public void deleteSession(String sessionId) {
        Integer sessionCount = sessionMap.get(sessionId);
        if (sessionCount == null) {
            return;
        }
        sessionMap.remove(sessionCount);
    }
}