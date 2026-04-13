import java.util.HashMap;
import java.util.Map;

public class java_23914_SessionManager_A08 {

    private Map<String, String> sessionUserMap;

    public java_23914_SessionManager_A08() {
        sessionUserMap = new HashMap<>();
    }

    public void login(String username, String password) {
        // This is a placeholder, you should implement real authentication here
        // For the sake of this example, we just store the username in the sessionUserMap
        sessionUserMap.put(username, username);
    }

    public String getSessionUser(String sessionId) {
        return sessionUserMap.get(sessionId);
    }

    public void logout(String sessionId) {
        sessionUserMap.remove(sessionId);
    }
}