import java.util.Collection;
import java.util.HashMap;

public class java_09145_SessionManager_A07 {
    private HashMap<String, Collection> sessionMap;

    public java_09145_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session already exists with id: " + sessionId);
        }

        Collection collection = new HashMap();
        sessionMap.put(sessionId, collection);
    }

    public void addToSession(String sessionId, Object object) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session found with id: " + sessionId);
        }

        Collection collection = sessionMap.get(sessionId);
        collection.add(object);
    }

    public Object getFromSession(String sessionId, int index) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session found with id: " + sessionId);
        }

        Collection collection = sessionMap.get(sessionId);
        return collection.toArray()[index];
    }

    public void removeFromSession(String sessionId, Object object) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session found with id: " + sessionId);
        }

        Collection collection = sessionMap.get(sessionId);
        collection.remove(object);
    }
}