import javax.management.*;
import java.lang.reflect.InvocationTargetException;

public class java_26463_SessionManager_A01 {
    private static final String USER_NAME = "user";
    private static final String PASSWORD = "password";

    private static boolean isUserAdmin() {
        MBeanServerConnection connection = null;
        ObjectName objectName = null;

        try {
            connection = ManagementFactory.getPlatformMBeanServer();
            objectName = new ObjectName("javax.management.security.SecurityManager");
            connection.queryNames(objectName, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (NotCompliantMBeanException | InstanceAlreadyExistsException | MBeanException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private static boolean isUserAuthenticated() {
        return USER_NAME.equals("user") && PASSWORD.equals("password");
    }

    public static void main(String[] args) throws NotCompliantMBeanException, MalformedObjectNameException, InvocationTargetException, InterruptedException {
        if (!isUserAuthenticated()) {
            System.out.println("You are not authenticated!");
            return;
        }

        if (isUserAdmin()) {
            System.out.println("You are an admin!");
            startAdminSession();
        } else {
            System.out.println("You are a user!");
            startUserSession();
        }
    }

    private static void startAdminSession() throws NotCompliantMBeanException, MalformedObjectNameException, InvocationTargetException, InterruptedException {
        MBeanServerConnection connection = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("javax.management.security.SecurityManager");
        connection.registerMBean(new SecurityManager(), objectName);

        System.out.println("Starting admin session...");
        Thread.sleep(10000); // Wait for 10 seconds
        System.out.println("Stopping admin session...");
        connection.unregisterMBean(objectName);
    }

    private static void startUserSession() throws NotCompliantMBeanException, MalformedObjectNameException, InvocationTargetException, InterruptedException {
        MBeanServerConnection connection = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("javax.management.security.SecurityManager");
        connection.registerMBean(new SecurityManager(), objectName);

        System.out.println("Starting user session...");
        Thread.sleep(10000); // Wait for 10 seconds
        System.out.println("Stopping user session...");
        connection.unregisterMBean(objectName);
    }
}