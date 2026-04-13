import java.util.HashMap;

public class java_39536_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_39536_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started with id: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with id: " + sessionId);
        } else {
            System.out.println("No session found with id: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found with id: " + sessionId);
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.startSession("A08_IntegrityFailure", "User1");
        sm.startSession("A08_IntegrityFailure2", "User2");
        sm.endSession("A08_IntegrityFailure");
        sm.startSession("A08_IntegrityFailure3", "User3");

        System.out.println("User1: " + sm.getUserId("A08_IntegrityFailure"));
        System.out.println("User2: " + sm.getUserId("A08_IntegrityFailure2"));
        System.out.println("User3: " + sm.getUserId("A08_IntegrityFailure3"));
    }
}