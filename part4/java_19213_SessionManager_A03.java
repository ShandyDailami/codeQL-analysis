import javax.management.Query;
import javax.management.RuntimeMBeanException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class java_19213_SessionManager_A03 {

    public static void main(String[] args) {
        try {
            // Create a JMX service URL
            JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:your_host:port");

            // Create a JMX connector
            JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceURL);

            // Get the MBeanServerMBean
            ObjectName objectName = new ObjectName("com.example.SessionFactory:type=SessionFactory");
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName[] objectNames = mbs.queryNames(new Query(), null);
            if (objectNames.length != 1) {
                throw new RuntimeMBeanException("No or multiple SessionFactory MBeans found.");
            }

            // Get the SessionFactory
            SessionFactory sessionFactory = (SessionFactory) mbs.getMBean(objectName);

            // Use the sessionFactory here
            // ...

            // Disconnect from the JMX server
            jmxConnector.close();
        } catch (MalformedURLException | RemoteException | javax.management.MBeanException | javax.management.InstanceAlreadyExistsException | javax.management.MBeanRegistrationException e) {
            throw new RuntimeMBeanException("Failed to connect to JMX server.", e);
        }
    }
}