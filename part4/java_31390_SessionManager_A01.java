import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class java_31390_SessionManager_A01 {
    private static final String SERVER_URL = "service:jmx:localhost:1099";
    private static final String OBJECT_NAME = "com.example.session:type=SessionManager";

    public void startSession() throws MalformedObjectNameException, RemoteException, MalformedURLException, FileNotFoundException {
        JMXServiceURL serviceUrl = new JMXServiceURL(SERVER_URL);
        JMXConnectorFactory connectorFactory = JMXConnectorFactory.connect(serviceUrl);
        ObjectName objectName = new ObjectName(OBJECT_NAME);

        Session session = connectorFactory.newMBeanProxy(objectName, Session.class);
        session.start();

        System.out.println("Session started");
    }

    public void stopSession() throws MalformedObjectNameException, RemoteException, MalformedURLException, FileNotFoundException {
        JMXServiceURL serviceUrl = new JMXServiceURL(SERVER_URL);
        JMXConnectorFactory connectorFactory = JMXConnectorFactory.connect(serviceUrl);
        ObjectName objectName = new ObjectName(OBJECT_NAME);

        Session session = connectorFactory.newMBeanProxy(objectName, Session.class);
        session.stop();

        System.out.println("Session stopped");
    }
}