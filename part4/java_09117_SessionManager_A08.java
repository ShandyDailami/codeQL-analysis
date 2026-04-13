import java.util.HashMap;
import java.util.Map;

public class java_09117_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09117_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void updateSession(String sessionId, String data) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, data);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Insert data
        sessionManager.updateSession("session1", "data1");
        sessionManager.updateSession("session2", "data2");

        // Get data
        System.out.println(sessionManager.getSession("session1")); // prints "data1"
        System.out.println(sessionManager.getSession("session2")); // prints "data2"

        // Delete data
        sessionManager.deleteSession("session1");

        // Get data after deletion
        System.out.println(sessionManager.getSession("session1")); // prints null
    }
}