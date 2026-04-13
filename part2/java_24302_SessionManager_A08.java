import java.util.HashMap;
import java.util.Map;

public class java_24302_SessionManager_A08 {
    private Map<String, Object> sessionMap;

    public java_24302_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void openSession(String id) {
        if (sessionMap.containsKey(id)) {
            System.out.println("Session " + id + " already opened");
        } else {
            System.out.println("Opening session " + id);
            sessionMap.put(id, null);
        }
    }

    public void closeSession(String id) {
        if (sessionMap.containsKey(id)) {
            if (sessionMap.get(id) != null) {
                System.out.println("Closing session " + id);
                sessionMap.put(id, null);
            } else {
                System.out.println("Session " + id + " already closed");
            }
        } else {
            System.out.println("No session " + id + " found");
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.openSession("session1");
        sm.openSession("session1"); // Should print "Session session1 already opened"
        sm.closeSession("session1");
        sm.closeSession("session2"); // Should print "No session session2 found"
    }
}