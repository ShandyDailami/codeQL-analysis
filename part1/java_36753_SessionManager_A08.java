import java.util.HashMap;
import java.util.Map;

public class java_36753_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_36753_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName, String password) {
        if (isPasswordWeak(password)) {
            return null;
        }

        String sessionId = generateSessionId(userName);
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserNameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private boolean isPasswordWeak(String password) {
        return password.length() < 8;
    }

    private String generateSessionId(String userName) {
        // Here you could implement a logic to generate a more secure session ID,
        // for example by using the user's ID and a timestamp. But for this example,
        // we'll just use a simple random string for simplicity.
        return userName + System.currentTimeMillis();
    }
}