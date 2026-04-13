import java.util.HashMap;

public class java_10407_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_10407_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessionMap.containsKey(username)) {
            throw new SecurityException("Session already started for user: " + username);
        } else {
            sessionMap.put(username, "SESSION");
        }
    }

    public void endSession(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
        } else {
            throw new SecurityException("No session started for user: " + username);
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("Alice");
        manager.startSession("Bob");
        manager.endSession("Alice");
        manager.startSession("Charlie");
        manager.endSession("Bob");
        manager.endSession("Charlie"); // This should throw a SecurityException
    }
}