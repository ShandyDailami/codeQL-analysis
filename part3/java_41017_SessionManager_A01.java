import java.util.ArrayList;
import java.util.List;

public class java_41017_SessionManager_A01 {
    private List<String> allowedUsers;

    public java_41017_SessionManager_A01() {
        allowedUsers = new ArrayList<>();
    }

    public void addAllowedUser(String user) {
        allowedUsers.add(user);
    }

    public void removeAllowedUser(String user) {
        allowedUsers.remove(user);
    }

    public boolean isAllowedToAccess(String user) {
        return allowedUsers.contains(user);
    }

    public void secureOperation(String user) {
        if (!isAllowedToAccess(user)) {
            throw new BrokenAccessControlException("Access denied for user: " + user);
        }
        // secure operation here
    }

    // example of a BrokenAccessControlException
    class BrokenAccessControlException extends RuntimeException {
        public java_41017_SessionManager_A01(String message) {
            super(message);
        }
    }
}