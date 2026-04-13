import javax.management.*;
import java.lang.management.ManagementFactory;

public class java_36764_SessionManager_A08 {

    public static void main(String[] args) {

        // Access to JMX attributes
        MBeanServerConnection serverConnection = null;
        ObjectName objectName = null;

        try {
            serverConnection = ManagementFactory.getPlatformMBeanServer();
            objectName = new ObjectName("com.example:type=SecurityManager");

            // Wrap MBean methods in a DummyImpl
            SecurityManager manager = new SecurityManager() {
                @Override
                public boolean checkAccess(String className, Object object, String propertyName, String actionName) throws InstanceNotFoundException, ReflectionException, NotCompliantMBeanException, MalformedObjectNameException {
                    // Here you would put the logic to verify if the access is allowed
                    return true;
                }

                @Override
                public void checkAccess(String className, Object object, String propertyName) throws InstanceNotFoundException, ReflectionException, NotCompliantMBeanException, MalformedObjectNameException {
                    // You can also implement a more robust check here
                }

                @Override
                public void enforceAdvisory(String adviceName, String adviceValue, String adviceType, String adviceTarget) throws InstanceNotFoundException, ReflectionException, NotCompliantMBeanException, MalformedObjectNameException {
                    // You can implement a more robust check here
                }
            };

            // Register the SecurityManager MBean
            serverConnection.registerMBean(manager, objectName);

            // Wait until we are killed
            while(true){
                Thread.sleep(10000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverConnection != null) {
                try {
                    serverConnection.unregisterMBean(objectName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}