import java.util.HashMap;

public class java_14561_SessionManager_A03 {
    // A simple in-memory representation of a Session
    private static HashMap<Integer, String> sessionMap = new HashMap<>();
    private static int sessionId = 0;

    public static void openSession() {
        sessionMap.put(++sessionId, "Active");
        System.out.println("Session opened with ID: " + sessionId);
    }

    public static void closeSession(int sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, "Inactive");
            System.out.println("Session with ID: " + sessionId + " has been closed.");
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public static String getSessionState(int sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void main(String[] args) {
        SessionManager.openSession();
        SessionManager.closeSession(1);
        System.out.println("Session state: " + SessionManager.getSessionState(1));
    }
}