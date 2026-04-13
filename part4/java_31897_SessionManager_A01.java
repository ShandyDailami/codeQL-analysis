import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class java_31897_SessionManager_A01 {
    private String currentUser;

    public java_31897_SessionManager_A01() {
        currentUser = null;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public void startSession(String user) throws SecurityException {
        setCurrentUser(user);
    }

    public void endSession() throws SecurityException {
        setCurrentUser(null);
    }

    public void checkSession(String user) throws SecurityException {
        if (!getCurrentUser().equals(user)) {
            throw new SecurityException("Unauthorized access");
        }
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Attempt to start a session as a different user
        try {
            sessionManager.startSession("user1");
            sessionManager.checkSession("user1");
            sessionManager.endSession();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}