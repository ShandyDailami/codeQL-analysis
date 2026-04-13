import javax.management.InvalidAttributeValueException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBeanException;

public class java_16393_SessionManager_A01 {
    private int sessionCount = 0;

    public java_16393_SessionManager_A01() {
        // This constructor is intentionally left blank.
    }

    public void createSession() {
        sessionCount++;
        System.out.println("Created session #" + sessionCount);
    }

    public void deleteSession() {
        if (sessionCount > 0) {
            sessionCount--;
            System.out.println("Deleted session #" + sessionCount);
        } else {
            System.out.println("No session to delete");
        }
    }

    public static void main(String[] args) {
        // Create a new SessionManager instance
        SessionManager sessionManager = new SessionManager();

        // Register the SessionManager MBean
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("com.example.SessionManager:type=SessionManager");
            mbs.registerMBean(sessionManager, name);
        } catch (MalformedObjectNameException | NotCompliantMBeanException | MBeanRegistrationException | InvalidAttributeValueException | StandardMBeanException e) {
            e.printStackTrace();
        }

        // Start creating sessions
        sessionManager.createSession();
        sessionManager.deleteSession();

        // Stop the registration process
        try {
            mbs.unregisterMBean(name);
        } catch (MalformedObjectNameException | NotCompliantMBeanException | MBeanRegistrationException | InvalidAttributeValueException | StandardMBeanException e) {
            e.printStackTrace();
        }
    }
}