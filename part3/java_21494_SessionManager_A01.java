import java.util.HashMap;

public class java_21494_SessionManager_A01 {
    private HashMap<String, Session> sessionMap;

    public java_21494_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id " + sessionId);
            return;
        }

        Session session = new Session();
        sessionMap.put(sessionId, session);
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists with id " + sessionId);
            return null;
        }

        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists with id " + sessionId);
            return;
        }

        sessionMap.remove(sessionId);
    }

    private class Session {
        // This is a simple session, you can add more fields and methods as per your requirement
    }
}