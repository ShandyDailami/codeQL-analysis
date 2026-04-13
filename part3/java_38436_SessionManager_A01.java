import java.util.HashMap;
import java.util.Map;

public class java_38436_SessionManager_A01 {
    private Map<String, String> sessionData;

    public java_38436_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    public String getSessionData(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            throw new IllegalArgumentException("Session not found: " + sessionId);
        }
    }

    public void setSessionData(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Attempt to retrieve session data
        try {
            String sessionId = "123";
            String sessionData = manager.getSessionData(sessionId);
            System.out.println("Session data: " + sessionData);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Set new session data
        String newData = "This is new session data";
        manager.setSessionData("123", newData);

        // Retrieve session data again to confirm new data was set
        try {
            String sessionData = manager.getSessionData("123");
            System.out.println("Session data after setting: " + sessionData);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}