import java.util.HashMap;
import java.util.Map;

public class java_19749_SessionManager_A03 {

    private Map<String, String> userCredentials;

    public java_19749_SessionManager_A03() {
        userCredentials = new HashMap<>();
    }

    public void addUser(String userId, String password) {
        userCredentials.put(userId, password);
    }

    public boolean authenticate(String userId, String password) {
        return userCredentials.get(userId).equals(password);
    }

    public void startSession(String userId) {
        if (authenticate(userId, userCredentials.get(userId))) {
            System.out.println("Session started for user: " + userId);
        } else {
            System.out.println("Authentication failed for user: " + userId);
        }
    }

    public void endSession(String userId) {
        System.out.println("Session ended for user: " + userId);
    }
}