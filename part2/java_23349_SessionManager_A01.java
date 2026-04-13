import javax.management.*;
import javax.management.monitor.*;
import javax.management.remote.*;
import java.lang.management.*;

public class java_23349_SessionManager_A01 {
    private static final String INITIAL_CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
    private static final String PROVIDER_URL = "ldap://localhost:1389/dc=apache,dc=org";
    private static final String USERNAME = "cn=admin,dc=apache,dc=org";
    private static final String PASSWORD = "password";

    private static MBeanServerConnection serverConnection;
    private static ObjectName sessionManagerObjectName;

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanException, ReflectionException, InterruptedException {
        connectToMBeanServer();
        createSessionManagerObjectName();
        createSession();
        monitorSession();
    }

    private static void connectToMBeanServer() throws NotCompliantMBeanException, MalformedObjectNameException, MBeanException, ReflectionException, InterruptedException {
        ManagementFactory.getPlatformMBeanServer().getConnection();
        serverConnection = ManagementFactory.getPlatformMBeanServer().newConnection();
    }

    private static void createSessionManagerObjectName() throws NotCompliantMBeanException, MalformedObjectNameException, MBeanException, ReflectionException, InterruptedException {
        sessionManagerObjectName = new ObjectName("com.sun:type=SessionManager");
        serverConnection.registerMBean(new SessionManager(), sessionManagerObjectName, null);
    }

    private static void createSession() throws NotCompliantMBeanException, MalformedObjectNameException, MBeanException, ReflectionException, InterruptedException {
        // Assume the session creation logic here, which is not provided in the question
    }

    private static void monitorSession() throws NotCompliantMBeanException, MalformedObjectNameException, MBeanException, ReflectionException, InterruptedException {
        System.out.println("Monitoring session...");
        serverConnection.setAttribute(sessionManagerObjectName, new StringAttribute("Session.State", "RUNNING"));

        MBeanNotificationInfo info = new MBeanNotificationInfo(new String[] {"Session.State"},
                new String[] {"Session State Change"},
                Notification.class.getName(),
                false,
                "SessionStateChanged",
                null,
                null);

        serverConnection.setNotificationMBean(sessionManagerObjectName, info, null);

        Thread.sleep(10000);

        System.out.println("Stopping monitoring...");
        serverConnection.setAttribute(sessionManagerObjectName, new StringAttribute("Session.State", "STOPPED"));
    }
}