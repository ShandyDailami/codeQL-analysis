import java.util.HashMap;

public class java_23821_SessionManager_A03 {

    // Using a HashMap to store session objects
    private HashMap<String, Session> sessionMap;

    public java_23821_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return "Error: Session already exists with ID: " + sessionId;
        } else {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            return "Success: Session created with ID: " + sessionId;
        }
    }

    // Method to get session
    public Session getSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to remove session
    public String removeSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Success: Session removed with ID: " + sessionId;
        } else {
            return "Error: No session exists with ID: " + sessionId;
        }
    }
}