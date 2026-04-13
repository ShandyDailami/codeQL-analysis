import javax.management.StandardJMException;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXServer;
import java.lang.management.ManagementFactory;
import java.rmi.RemoteException;

public class java_34623_SessionManager_A01 {

    private static final String JMX_URL = "service:jmx:localhost:9999";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    private JMXServer jmxServer;
    private JMXConnector jmxConnector;

    public void start() throws StandardJMException, RemoteException {
        jmxConnector = JMXConnectorFactory.connect(JMX_URL);
        jmxServer = jmxConnector.getMBeanServer();
    }

    public void stop() throws Exception {
        jmxServer.close() ;
        jmxConnector.close();
    }

    public void createSession(String beanName, String objectName) throws Exception {
        if (jmxServer != null) {
            jmxServer.createNewBean(objectName, null, null, null, beanName);
            System.out.println("Created session for bean: " + beanName);
        } else {
            throw new Exception("JMX server is not running");
        }
    }

    public void deleteSession(String beanName) throws Exception {
        if (jmxServer != null) {
            jmxServer.removeBean(beanName);
            System.out.println("Deleted session for bean: " + beanName);
        } else {
            throw new Exception("JMX server is not running");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        try {
            manager.start();
            manager.createSession("MySession", "com.example.MySession");

            // Pause so we can check the JMX console
            System.out.println("Press any key to stop...");
            System.in.read();

            manager.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}