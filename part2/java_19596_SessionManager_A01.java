import java.util.HashMap;

public class java_19596_SessionManager_A01 {

    private HashMap<String, String> sessionData;

    public java_19596_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    public String getSessionData(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            return "Invalid session id";
        }
    }

    public void setSessionData(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    public void deleteSessionData(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            sessionData.remove(sessionId);
        } else {
            System.out.println("Invalid session id");
        }
    }

    // This method will be used to simulate a broken access control.
    public void accessControl(String sessionId, String requiredRole) {
        if (sessionData.containsKey(sessionId)) {
            if (sessionData.get(sessionId).equals("admin") || sessionData.get(sessionId).equals(requiredRole)) {
                System.out.println("Access granted for session: " + sessionId);
            } else {
                System.out.println("Access denied for session: " + sessionId);
            }
        } else {
            System.out.println("Invalid session id");
        }
    }
}