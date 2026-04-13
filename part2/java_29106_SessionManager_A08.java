import java.util.HashMap;

public class java_29106_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_29106_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session Already Started: " + sessionId);
        } else {
            sessionMap.put(sessionId, "Started");
            System.out.println("Session Started: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            if (sessionMap.get(sessionId).equals("Started")) {
                sessionMap.put(sessionId, "Ended");
                System.out.println("Session Ended: " + sessionId);
            } else {
                System.out.println("Session Already Ended: " + sessionId);
            }
        } else {
            System.out.println("Session Not Found: " + sessionId);
        }
    }
}