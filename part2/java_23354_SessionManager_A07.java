import java.util.HashMap;
import java.util.Map;

public class java_23354_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_23354_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String userId, String password) {
        userMap.put(userId, password);
    }

    public void authenticate(String userId, String password) throws AuthFailureException {
        if (userMap.containsKey(userId) && userMap.get(userId).equals(password)) {
            System.out.println("Authentication successful!");
        } else {
            throw new AuthFailureException();
        }
    }

    public void startSession(String userId) {
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String userId) {
        System.out.println("Session ended for user: " + userId);
    }
}

class AuthFailureException extends Exception {
    public java_23354_SessionManager_A07() {
        super("Authentication failure");
    }
}