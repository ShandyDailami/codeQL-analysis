import java.security.Security;
import java.util.HashMap;
import java.util.Map;

public class java_35086_SessionManager_A08 {
    private Map<String, SecurityContext> sessions = new HashMap<>();

    public java_35086_SessionManager_A08() {
        // Initialize security manager
        Security.addProvider(new java.security.provider.JavaSecurityManagerProvider());
    }

    public SecurityContext createSession(String userName) {
        // Create a new SecurityContext and add it to the map
        SecurityContext context = new SecurityContext(userName, true);
        sessions.put(userName, context);
        return context;
    }

    public void destroySession(String userName) {
        // Remove the SecurityContext from the map
        sessions.remove(userName);
    }

    public SecurityContext checkoutSession(String userName) {
        // Return the SecurityContext from the map or null if it doesn't exist
        return sessions.get(userName);
    }

    public void checkinSession(String userName) {
        // Remove the SecurityContext from the map
        sessions.remove(userName);
    }
}

class SecurityContext {
    private String userName;
    private boolean isActive;

    public java_35086_SessionManager_A08(String userName, boolean isActive) {
        this.userName = userName;
        this.isActive = isActive;
    }

    // Getters and setters
    public String getUserName() {
        return userName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}