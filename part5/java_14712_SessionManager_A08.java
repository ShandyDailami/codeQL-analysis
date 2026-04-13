import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectInstance;
import javax.management.ObjectNotFoundException;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.RemoteException;

public class java_14712_SessionManager_A08 {

    private JMXConnectorFactory jmxConnectorFactory;
    private ObjectInstance sessionManager;

    public java_14712_SessionManager_A08() {
        try {
            jmxConnectorFactory = JMXConnectorFactory.connect();
            sessionManager = jmxConnectorFactory.getMBeanServerConnection().createObjectInstance(
                    "com.example.jmx:type=SessionManager",
                    "SessionManager");
        } catch (MalformedObjectNameException | NotCompliantObjectException | InstanceAlreadyExistsException | MBeanRegistrationException | RemoteException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void checkSession() {
        try {
            String sessionState = sessionManager.getAttribute("SessionManager", "SessionState");
            System.out.println("Session State: " + sessionState);
        } catch (MalformedObjectNameException | NotCompliantObjectException | InstanceAlreadyExistsException | MBeanRegistrationException | RemoteException | ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SessionManager().checkSession();
    }
}