import java.util.ArrayList;
import java.util.List;

public class java_25026_SessionManager_A01 {
    private List<String> allowedUsers;

    public java_25026_SessionManager_A01() {
        allowedUsers = new ArrayList<>();
    }

    public void addAllowedUser(String username) {
        allowedUsers.add(username);
    }

    public boolean isUserAllowed(String username) {
        return allowedUsers.contains(username);
    }

    public void startSession(String username) throws BrokenAccessControlException {
        if (!isUserAllowed(username)) {
            throw new BrokenAccessControlException("Access Denied for user: " + username);
        }
        // Start session...
    }
}

class BrokenAccessControlException extends Exception {
    public java_25026_SessionManager_A01(String message) {
        super(message);
    }
}