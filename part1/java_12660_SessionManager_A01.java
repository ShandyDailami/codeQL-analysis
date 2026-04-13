import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectName;
import java.lang.management.ManagementException;
import java.util.HashMap;
import java.util.Map;

public class java_12660_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_12660_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a dummy method. Replace it with a secure and unique session id generation logic.
        return "sessionId";
    }

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantObjectException, InstanceAlreadyExistsException, MBeanRegistrationException, ManagementException {
        // Create a SessionManager
        SessionManager sessionManager = new SessionManager();

        // Create a MBeanServer
        MBeanServer mbs = MBeanServerFactory.createMBeanServer();

        // Create a SessionManager MBean
        ObjectName name = new ObjectName("com.example.SessionManager:type=SessionManager");
        mbs.registerMBean(sessionManager, name);

        // Start the MBean server
        mbs.start();

        // Perform security-sensitive operations related to A01_BrokenAccessControl
        String sessionId = sessionManager.createSession("admin");
        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);

        // Stop the MBean server
        mbs.stop();
    }
}