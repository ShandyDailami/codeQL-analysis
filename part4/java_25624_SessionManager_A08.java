import java.util.*;

public class java_25624_SessionManager_A08 {
    // A map to store session IDs
    private Map<String, Boolean> sessionMap;

    // Constructor
    public java_25624_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public void startSession(String sessionID) {
        sessionMap.put(sessionID, Boolean.TRUE);
    }

    // Method to end a session
    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    // Method to check if a session is valid
    public boolean isSessionValid(String sessionID) {
        if (!sessionMap.containsKey(sessionID)) {
            return false;
        }

        if (!sessionMap.get(sessionID)) {
            return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionID1 = UUID.randomUUID().toString();
        String sessionID2 = UUID.randomUUID().toString();

        sessionManager.startSession(sessionID1);
        sessionManager.startSession(sessionID2);

        if (sessionManager.isSessionValid(sessionID1)) {
            System.out.println("Session ID 1 is valid.");
        } else {
            System.out.println("Session ID 1 is invalid.");
        }

        if (sessionManager.isSessionValid(sessionID2)) {
            System.out.println("Session ID 2 is valid.");
        } else {
            System.out.println("Session ID 2 is invalid.");
        }

        sessionManager.endSession(sessionID1);
        sessionManager.endSession(sessionID2);

        if (sessionManager.isSessionValid(sessionID1)) {
            System.out.println("Session ID 1 is valid.");
        } else {
            System.out.println("Session ID 1 is invalid.");
        }

        if (sessionManager.isSessionValid(sessionID2)) {
            System.out.println("Session ID 2 is valid.");
        } else {
            System.out.println("Session ID 2 is invalid.");
        }
    }
}