import java.util.HashMap;
import java.util.Map;

public class java_25610_SessionManager_A08 {

    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_25610_SessionManager_A08() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public void addSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public boolean checkUserAccess(String sessionId, String password) {
        String username = sessionMap.get(sessionId);
        return username != null && userMap.get(username).equals(password);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.addUser("user1", "password1");
        manager.addUser("user2", "password2");

        String sessionId1 = manager.startSession("user1", "password1");
        String sessionId2 = manager.startSession("user2", "password2");

        System.out.println(manager.checkUserAccess(sessionId1, "password1")); // Should print: true
        System.out.println(manager.checkUserAccess(sessionId2, "password2")); // Should print: true

        manager.removeSession(sessionId2);

        System.out.println(manager.checkUserAccess(sessionId1, "password1")); // Should print: true
        System.out.println(manager.checkUserAccess(sessionId2, "password2")); // Should print: false
    }

    private String startSession(String username, String password) {
        String sessionId = UUID.randomUUID().toString();
        addSession(sessionId, username);
        return sessionId;
    }

}