import javax.management.*;
import javax.management.remote.*;
import java.lang.management.ManagementFactory;

public class java_07962_SessionManager_A01 {

    private static final String USERNAME = "your-username";
    private static final String PASSWORD = "your-password";
    private static final String HOST = "your-host";
    private static final int PORT = 1234;

    private static ManagementFactory factory;
    private static ManagementRegistry registry;

    public static void main(String[] args) {

        try {
            factory = ManagementFactory.getDefaultManagementFactory();
            registry = factory.connect(new RemoteConnection(HOST, PORT));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("SessionManager started...");

            // Get the MBean server version
            MBeanServerConnection serverConnection = registry.getConnection();
            ObjectName serverName = new ObjectName("com.sun.management:type=Server");
            Attributes attributes = new Attributes();
            serverConnection.getAttributes(serverName, attributes);
            String version = attributes.get("Version").toString();
            System.out.println("Server version: " + version);

            // Get the MBean for session count
            ObjectName sessionName = new ObjectName("com.yourcompany.example.session:type=Session");
            sessionCount(serverConnection, sessionName);

            // Get the MBean for user count
            ObjectName userName = new ObjectName("com.yourcompany.example.user:type=User");
            userCount(serverConnection, userName);

            serverConnection.close();

            System.out.println("SessionManager stopped...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sessionCount(MBeanServerConnection serverConnection, ObjectName sessionName) {
        try {
            sessionCount = serverConnection.getIntProperty(sessionName, "Current Sessions");
            System.out.println("Current sessions: " + sessionCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void userCount(MBeanServerConnection serverConnection, ObjectName userName) {
        try {
            userCount = serverConnection.getIntProperty(userName, "Current Users");
            System.out.println("Current users: " + userCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}