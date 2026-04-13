import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanRegistration;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.Reference;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementException;
import java.util.Arrays;

public class java_41302_SessionManager_A08 {

    public static void main(String[] args) {
        try {
            JMXServiceURL url = new JMXServiceURL("service:jmx:localhost");
            JMXConnectorFactory factory = JMXConnectorFactory.connect(url);
            ObjectName sessionMBeanName = new ObjectName("com.example:type=SessionManager");

            // Register the MBean
            Reference ref = factory.newReference(sessionMBeanName, ObjectName.class);
            MBeanRegistration registration = factory.getMBeanServerConnection().registerMBean(ref, new ObjectName[] {sessionMBeanName});

            // Create a session
            ObjectInstance session = factory.newObjectInstance(sessionMBeanName, new String[] {"session1"});
            factory.getMBeanServerConnection().setAttribute(sessionMBeanName, new String[] {"SessionId"}, new Object[] {session.getObjectName().getLocalName()});

            // Destroy the session
            factory.getMBeanServerConnection().unregisterMBean(session.getObjectName());

        } catch (MalformedObjectNameException | NotCompliantObjectException | InstanceAlreadyExistsException | MBeanRegistrationException | JMXConnectorFactory.CannotCreateJMXConnectorException | ManagementException e) {
            e.printStackTrace();
        }
    }
}