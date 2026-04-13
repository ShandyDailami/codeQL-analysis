import javax.management.*;
import java.lang.management.*;

public class java_14213_SessionManager_A07 {

    private static SessionManager instance;

    private java_14213_SessionManager_A07() {
        // Private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private String sessionId;
    private MBeanServer mbs;

    public void createSession() {
        try {
            // Obtain the management interface for the JVM
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

            // Define a new attribute of type String
            String attributeName = "com.example.SessionId";
            String attributeValue = UUID.randomUUID().toString();
            mbs.setAttribute(attributeName, attributeValue);

            // Define a new attribute of type Long
            attributeName = "com.example.LastAccess";
            mbs.setAttribute(attributeName, System.currentTimeMillis());

            // Define a new attribute of type Boolean
            attributeName = "com.example.Active";
            mbs.setAttribute(attributeName, true);

            // Define a new attribute of type String
            attributeName = "com.example.User";
            mbs.setAttribute(attributeName, "TestUser");

            // Obtain the object name for the JVM
            ObjectName name = new ObjectName("com.example:type=Session");

            // Register the object
            mbs.registerMBean(new Session(), name, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSession() {
        try {
            // Obtain the management interface for the JVM
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

            // Obtain the object name for the JVM
            ObjectName name = new ObjectName("com.example:type=Session");

            // Unregister the object
            mbs.unregisterMBean(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Session implements MBean {

    public void setSessionId(String sessionId) {
        // Security sensitive operation
    }

    public String getSessionId() {
        // Security sensitive operation
        return sessionId;
    }

    public void setLastAccess(long lastAccess) {
        // Security sensitive operation
    }

    public long getLastAccess() {
        // Security sensitive operation
        return 0;
    }

    public void setActive(boolean active) {
        // Security sensitive operation
    }

    public boolean isActive() {
        // Security sensitive operation
        return false;
    }

    public void setUser(String user) {
        // Security sensitive operation
    }

    public String getUser() {
        // Security sensitive operation
        return "";
    }

    public void attributeChanged(String name, String oldValue, String newValue) throws NotCompliantMBeanException {
        // Security sensitive operation
    }
}