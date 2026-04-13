import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectName;
import java.lang.management.ManagementException;

public class java_40330_SessionManager_A07 {

    private static final String URL = "com.sun.management:type=Memory";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Create the MBeanServer
            MBeanServer mbs = MBeanServerFactory.newMBeanServer();

            // Create the object
            ObjectName name = new ObjectName("com.sun:type=Memory");

            // Register the object
            mbs.registerMBean(new SessionManager(), name);

            // Create security context
            javax.security.auth.Subject subject = new javax.security.auth.Subject();
            subject.getPrincipal(USERNAME);
            subject.getPrincipal(PASSWORD);

            // Execute operation
            executeOperation(mbs, subject);

            // Unregister the object
            mbs.unregisterMBean(name);

        } catch (MalformedObjectNameException | NotCompliantObjectException | InstanceAlreadyExistsException | MBeanRegistrationException | ManagementException e) {
            e.printStackTrace();
        }
    }

    private static void executeOperation(MBeanServer mbs, javax.security.auth.Subject subject) {
        try {
            mbs.setAttribute(subject, new javax.management.Attribute("MemoryFree", "10240"), null);
            mbs.setAttribute(subject, new javax.management.Attribute("MemoryUsed", "20480"), null);
            mbs.setAttribute(subject, new javax.management.Attribute("MemoryMax", "30720"), null);
        } catch (MalformedObjectNameException | NotCompliantObjectException | InstanceAlreadyExistsException | MBeanRegistrationException | ManagementException e) {
            e.printStackTrace();
        }
    }
}