import java.util.HashMap;
import java.util.Map;

public class java_38645_SessionManager_A07 {

    private Map<String, Object> storage;

    public java_38645_SessionManager_A07() {
        this.storage = new HashMap<>();
    }

    public void createSession(String sessionId) {
        this.storage.put(sessionId, new HashMap<>());
    }

    public void addToSession(String sessionId, String key, Object value) {
        if (this.storage.containsKey(sessionId)) {
            this.storage.get(sessionId).put(key, value);
        } else {
            System.out.println("Session not found");
        }
    }

    public Object getFromSession(String sessionId, String key) {
        if (this.storage.containsKey(sessionId)) {
            return this.storage.get(sessionId).get(key);
        } else {
            System.out.println("Session not found");
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (this.storage.containsKey(sessionId)) {
            this.storage.remove(sessionId);
        } else {
            System.out.println("Session not found");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.createSession("session1");
        manager.addToSession("session1", "username", "user1");
        manager.addToSession("session1", "password", "password1");

        String username = (String) manager.getFromSession("session1", "username");
        String password = (String) manager.getFromSession("session1", "password");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}