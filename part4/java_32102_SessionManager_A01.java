import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectName;
import java.lang.management.ManagementException;

public class java_32102_SessionManager_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a new MBeanServer
            MBeanServer mbs = MBeanServerFactory.newMBeanServer();

            // Step 2: Create a new object instance
            SessionManager sessionManager = new SessionManager();
            ObjectName name = new ObjectName("com.example.CustomSessionManager:type=SessionManager");

            // Step 3: Register the object instance with the MBeanServer
            mbs.registerMBean(sessionManager, name);

            // Step 4: Wait for a while to ensure the object is fully loaded
            Thread.sleep(10000);

            // Step 5: Get the MBeanServer instance
            MBeanServer mbs2 = ManagementFactory.getPlatformMBeanServer();

            // Step 6: Use the MBeanServer instance to manipulate the object
            mbs2.unregisterMBean(name);

        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | NotCompliantObjectException | MBeanRegistrationException | ManagementException e) {
            e.printStackTrace();
        }
    }
}

class SessionManager {
    private String sessionState;

    public java_32102_SessionManager_A01() {
        this.sessionState = "Created";
    }

    public void startSession() {
        this.sessionState = "Started";
    }

    public void endSession() {
        this.sessionState = "Ended";
    }

    public String getSessionState() {
        return this.sessionState;
    }
}