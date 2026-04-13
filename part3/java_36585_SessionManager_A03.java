import java.util.HashMap;

public class java_36585_SessionManager_A03 {

    private HashMap<String, String> sessionMap;

    public java_36585_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // This is a security-sensitive operation that may involve
        // inserting malicious code here to perform an injection attack
        // For the purpose of this example, we'll just print a message
        System.out.println("Starting session with user ID: " + userId);
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        // This is a security-sensitive operation that may involve
        // retrieving sensitive information here
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // This is a security-sensitive operation that may involve
        // deleting or modifying information here
        sessionMap.remove(sessionId);
    }
}