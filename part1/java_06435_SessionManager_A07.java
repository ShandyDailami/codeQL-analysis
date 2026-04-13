import javax.management.*;
import javax.management.remote.*;

public class java_06435_SessionManager_A07 {
    private static final String URL = "targetServer";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        System.out.println("Connecting to remote JMX server...");

        try {
            // Create a new MBeanServerConnection
            MBeanServerConnection mbs = JMXUtils.connect(URL, USERNAME, PASSWORD);

            // Create a new instance of the session bean
            SessionBean sessionBean = new SessionBean(mbs);

            // Register the session bean
            MBeanRegistration registration = mbs.registerMBean(sessionBean, new ObjectName("com.example.SessionManager:type=Session"));

            System.out.println("Successfully registered session bean...");

            // Start session
            sessionBean.start();

            // Wait until session is running
            while (!sessionBean.isRunning()) {
                Thread.sleep(500);
            }

            System.out.println("Session is running...");

            // Stop session
            sessionBean.stop();

            // Unregister the session bean
            mbs.unregisterMBean(registration);

            System.out.println("Successfully unregistered session bean...");

            JMXUtils.disconnect(mbs);

            System.out.println("Disconnected from remote JMX server...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SessionBean implements Session {
    private MBeanServerConnection mbs;
    private ObjectName name;
    private boolean running;

    public java_06435_SessionManager_A07(MBeanServerConnection mbs) {
        this.mbs = mbs;
        this.name = new ObjectName("com.example.SessionManager:type=Session");
    }

    public void start() {
        try {
            mbs.invoke(name, "start", null, null);
            running = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            mbs.invoke(name, "stop", null, null);
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning() {
        return running;
    }
}

class JMXUtils {
    public static MBeanServerConnection connect(String url, String username, String password) {
        try {
            ManagementFactory.createConnectionMBeanServerConnection(url, username, password);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanServerException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanException e) {
            e.printStackTrace();
        } catch (UnknowMBeanException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void disconnect(MBeanServerConnection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}