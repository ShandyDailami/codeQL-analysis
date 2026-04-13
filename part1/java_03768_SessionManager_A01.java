import java.util.HashMap;

public class java_03768_SessionManager_A01 {
    private HashMap<String, String> sessionData;

    public java_03768_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    public String getSessionData(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            // This is a place for security-sensitive operations.
            // For example, a request to the server to reset the session
            // or to check if the sessionId is still valid and still has access.
            System.out.println("Access Denied: Session Id " + sessionId + " is not valid or has expired.");
            return null;
        }
    }

    public void setSessionData(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    public void deleteSessionData(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            sessionData.remove(sessionId);
        } else {
            System.out.println("Error: Session Id " + sessionId + " does not exist.");
        }
    }
}