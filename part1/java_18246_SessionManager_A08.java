import java.util.HashMap;

public class java_18246_SessionManager_A08 {

    private HashMap<String, String> sessionMap;

    public java_18246_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
        return "Session Created Successfully!";
    }

    public String getSessionValue(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public String updateSessionValue(String sessionId, String sessionValue) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionValue);
            return "Session Value Updated Successfully!";
        } else {
            return "No session found with the provided ID!";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session Deleted Successfully!";
        } else {
            return "No session found with the provided ID!";
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("A08_IntegrityFailure", "Session Value A08_IntegrityFailure");

        System.out.println("Session Value: " + sessionManager.getSessionValue("A08_IntegrityFailure"));

        sessionManager.updateSessionValue("A08_IntegrityFailure", "Updated Session Value A08_IntegrityFailure");

        System.out.println("Updated Session Value: " + sessionManager.getSessionValue("A08_IntegrityFailure"));

        sessionManager.deleteSession("A08_IntegrityFailure");

        System.out.println("Deleted Session Value: " + sessionManager.getSessionValue("A08_IntegrityFailure"));
    }
}