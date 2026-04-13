import java.util.HashMap;
import java.util.Map;

public class java_01740_SessionManager_A08 {
    // A simple user repository for demo purposes
    private Map<String, String> userRepository;

    public java_01740_SessionManager_A08() {
        userRepository = new HashMap<>();
        userRepository.put("user1", "password1");
        userRepository.put("user2", "password2");
    }

    // Simple login method
    public boolean login(String username, String password) {
        if (userRepository.containsKey(username) && userRepository.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Simple session creation method
    public String createSession(String username) {
        if (login(username, userRepository.get(username))) {
            return username + "_session";
        } else {
            return null;
        }
    }

    // Simple session destruction method
    public boolean destroySession(String sessionId) {
        if (sessionId.split("_")[1].equals("session")) {
            return true;
        } else {
            return false;
        }
    }

    // Simple session access method
    public String getSession(String sessionId) {
        if (sessionId.split("_")[1].equals("session")) {
            return sessionId.split("_")[0];
        } else {
            return null;
        }
    }
}