import java.util.HashMap;

public class java_30089_SessionManager_A03 {

    private HashMap<String, String> sessionMap;

    public java_30089_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, "Active");
            System.out.println("Session started with id: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, "Inactive");
            System.out.println("Session ended with id: " + sessionId);
        } else {
            System.out.println("Session does not exist with id: " + sessionId);
        }
    }

    public String isActiveSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Session does not exist with id: " + sessionId;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("Session1");
        sessionManager.startSession("Session2");
        sessionManager.startSession("Session1"); // This should print a message
        sessionManager.endSession("Session2");
        sessionManager.isActiveSession("Session1"); // This should print "Active"
        sessionManager.isActiveSession("Session3"); // This should print "Session does not exist with id: Session3"
    }
}