import java.util.HashMap;

public class java_03647_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_03647_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists. Please choose a unique id.");
        } else {
            sessionMap.put(sessionId, username);
            System.out.println("Session started with id " + sessionId + " and username " + username);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with id " + sessionId + " and username " + username);
        } else {
            System.out.println("No session with id " + sessionId + " exists.");
        }
    }

    public void checkSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            System.out.println("Session with id " + sessionId + " exists and the username is " + username);
        } else {
            System.out.println("No session with id " + sessionId + " exists.");
        }
    }
}