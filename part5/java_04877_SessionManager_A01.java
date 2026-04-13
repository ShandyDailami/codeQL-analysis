import java.util.HashMap;
import java.util.Map;

public class java_04877_SessionManager_A01 {
    private Map<String, String> userDatabase;
    private Map<String, String> sessionDatabase;

    public java_04877_SessionManager_A01() {
        userDatabase = new HashMap<>();
        sessionDatabase = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userDatabase.put(username, password);
    }

    public void addSession(String username, String sessionId) {
        sessionDatabase.put(username, sessionId);
    }

    public boolean authenticate(String username, String password) {
        return userDatabase.get(username).equals(password);
    }

    public boolean isValidSession(String username, String sessionId) {
        return sessionDatabase.get(username).equals(sessionId);
    }
}