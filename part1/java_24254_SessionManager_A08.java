import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class java_24254_SessionManager_A08 implements StandardMBean {

    private SessionManager sessionManager;
    private ObjectName objectName;

    public java_24254_SessionManager_A08(SessionManager sessionManager) {
        this.sessionManager = sessionManager;

        try {
            this.objectName = new ObjectName("com.example.sessionManager:type=SessionManager");
        } catch (MalformedObjectNameException | SecurityException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public SessionManager getSessionManager() {
        return this.sessionManager;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        try {
            JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL("service:jmx:localhost"));
            StandardMBean mbean = new VanillaJavaSessionManager(sessionManager);
            connector.connect();
            connector.addMBean(mbean, objectName);

            System.out.println("MBean added successfully");
        } catch (NotCompliantMBeanException | MBeanRegistrationException | InstanceAlreadyExistsException | MalformedObjectNameException | JMXConnectorFactory.CannotConnectException e) {
            e.printStackTrace();
        }
    }
}