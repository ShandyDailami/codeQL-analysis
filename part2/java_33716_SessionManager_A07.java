import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_33716_SessionManager_A07 {

    // Predefined list of authorized usernames
    private static final List<String> AUTHORIZED_USERNAMES = List.of("user1", "user2", "user3");

    // In-memory data structure to store sessions
    private Map<String, String> sessionMap;

    public java_33716_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) throws AuthFailureException {
        if (isAuthorized(username)) {
            sessionMap.put(username, "active");
            System.out.println("Session started for user: " + username);
        } else {
            throw new AuthFailureException("Unauthorized user");
        }
    }

    public void endSession(String username) {
        sessionMap.put(username, "inactive");
        System.out.println("Session ended for user: " + username);
    }

    private boolean isAuthorized(String username) {
        return AUTHORIZED_USERNAMES.contains(username);
    }
}

class AuthFailureException extends Exception {
    public java_33716_SessionManager_A07(String message) {
        super(message);
    }
}