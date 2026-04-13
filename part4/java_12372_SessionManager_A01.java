import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.naming.NamingException;
import java.lang.management.ManagementException;

public class java_12372_SessionManager_A01 {
    public static void main(String[] args) {
        try {
            // Obtain MBeanServer
            MBeanServer mbs = MBeanServerFactory.newMBeanServer();

            // Define a ManagedBean (MBean)
            ObjectName name = new ObjectName("com.example:type=SessionManager");

            // Register the MBean
            mbs.registerMBean(new SessionManager(), name, null, null);

            System.out.println("Registered SessionManager MBean...");

            // Wait for a while
            Thread.sleep(5000);

            // Unregister the MBean
            mbs.unregisterMBean(name);

        } catch (MalformedObjectNameException | NamingException | InstanceAlreadyExistsException | NotCompliantMBeanException | MBeanRegistrationException | ManagementException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SessionManager {
    // This class is not secure, it's just an example
}