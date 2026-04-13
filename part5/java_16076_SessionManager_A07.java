import java.util.HashMap;
import java.util.Map;

public class java_16076_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private String expectedPassword;

    public java_16076_SessionManager_A07(String expectedPassword) {
        this.sessionMap = new HashMap<>();
        this.expectedPassword = expectedPassword;
    }

    public String createSession(String userID, String password) {
        if (!password.equals(expectedPassword)) {
            throw new AuthFailureException("Password incorrect");
        }

        String sessionID = userID + System.currentTimeMillis(); // Create a session ID based on user ID and current time
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}