import java.util.HashMap;

public class java_41550_SessionManager_A08 {
    private HashMap<String, String> sessionMap;
    private HashMap<String, String> validationMap;

    public java_41550_SessionManager_A08() {
        sessionMap = new HashMap<>();
        validationMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = "A08_SESSION_" + userName;
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void validateSession(String sessionId, String expectedUserName) {
        String userName = sessionMap.get(sessionId);
        if (userName != null && userName.equals(expectedUserName)) {
            validationMap.put(sessionId, "VALID");
        } else {
            validationMap.put(sessionId, "INVALID");
        }
    }

    public String getValidationStatus(String sessionId) {
        return validationMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
        validationMap.remove(sessionId);
    }
}