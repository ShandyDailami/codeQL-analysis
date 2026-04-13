import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;

public class java_01921_SessionManager_A07 {

    // Create a private HashMap to store session data.
    private HashMap<String, String> sessionMap;

    // Create a constructor to initialize the session map.
    public java_01921_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Create a method to add a session.
    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    // Create a method to get a session.
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Create a method to remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Create a method to check if a session exists.
    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Create a method to clear all sessions.
    public void clearAllSessions() {
        sessionMap.clear();
    }

    // Create a method to get all session IDs.
    public Collection<String> getAllSessionIds() {
        return sessionMap.keySet();
    }

    // Create a method to iterate over all sessions.
    public Iterator<String> getAllSessionIterator() {
        return sessionMap.keySet().iterator();
    }
}