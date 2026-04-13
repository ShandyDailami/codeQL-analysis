import java.security.Action;
import java.security.SecurityPermission;
import java.security.Permission;
import java.security.Policy;
import java.util.HashSet;
import java.util.Set;

public class java_17358_SessionManager_A03 implements Policy {
    private Set<String> sessionIds = new HashSet<>();

    @Override
    public boolean permits(Permission permission) {
        return switch (permission.getClass().getSimpleName()) {
            case "SecurityPermission" -> true;
            default -> false;
        };
    }

    public void addSessionId(String sessionId) {
        sessionIds.add(sessionId);
    }

    public boolean checkSessionId(String sessionId) {
        return sessionIds.contains(sessionId);
    }
}

public class SessionManager {
    private Policy securityManager;

    public java_17358_SessionManager_A03(Policy securityManager) {
        this.securityManager = securityManager;
    }

    public void createSession(String sessionId) {
        if (!(securityManager instanceof CustomPolicy)) {
            throw new SecurityException("Security manager is not a CustomPolicy");
        }

        CustomPolicy customPolicy = (CustomPolicy) securityManager;
        if (!customPolicy.checkSessionId(sessionId)) {
            throw new SecurityException("Session ID does not match the allowed pattern: " + sessionId);
        }

        // Continue with the session creation
    }
}