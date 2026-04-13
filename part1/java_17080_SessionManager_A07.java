import java.util.HashMap;
import java.util.Map;

public class java_17080_SessionManager_A07 {

    // A simple in-memory representation of the session storage
    private Map<String, String> sessionStorage;

    public java_17080_SessionManager_A07() {
        sessionStorage = new HashMap<>();
    }

    // Simulates login operation
    public String login(String username, String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            return "session_id";
        } else {
            throw new AuthFailureException();
        }
    }

    // Simulates retrieving operation
    public String get(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    // Simulates update operation
    public void update(String sessionId, String data) {
        sessionStorage.put(sessionId, data);
    }

    // Simulates delete operation
    public void delete(String sessionId) {
        sessionStorage.remove(sessionId);
    }
}