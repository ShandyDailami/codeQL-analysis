import java.util.HashMap;
import java.util.Map;

public class java_27954_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27954_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Started session for user: " + userName);
    }

    public String getUserNameForSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user: " + userName);
    }

    private String generateSessionId() {
        // Generate session ID here. For simplicity, let's generate a random string.
        // In a real-world application, you should use a more secure way to generate session IDs.
        String sessionId = "";
        for (int i = 0; i < 10; i++) {
            sessionId += (char) ((Math.random() * 26) + 65); // A-Z
        }
        return sessionId;
    }
}