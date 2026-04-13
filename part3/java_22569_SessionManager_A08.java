import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanRegistrationException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

public class java_22569_SessionManager_A08 {
    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

// Usage
public class Main {
    public static void main(String[] args) throws InstanceAlreadyExistsException, NotCompliantMBeanException, MBeanRegistrationException {
        SessionManager sessionManager = new SessionManager();
        ObjectName objectName = new ObjectName("com.example.SessionManager:type=SessionManager");
        Policy policy = new Policy() {
            @Override
            public boolean implies(ProtectionDomain domain, String className) {
                return true; // allow all classes
            }
        };
        java.lang.management.ManagementAgent agent = java.lang.management.ManagementFactory.getManagementAgent();
        agent.registerMBean(sessionManager, objectName, policy, null);

        // create session
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        // get user from session
        String userId = sessionManager.getUserId(sessionId);
        System.out.println("User from session: " + userId);

        // invalidate session
        sessionManager.invalidateSession(sessionId);
    }
}