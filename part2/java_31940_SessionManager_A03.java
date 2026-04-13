import javax.management.*;
import javax.management.remote.JMSServerRemoteException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class java_31940_SessionManager_A03 {
    private MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    private ObjectName mbeanName;

    public void createSession(String sessionName) throws InstanceAlreadyExistsException, MalformedObjectNameException, NotCompliantMBeanException, MBeanException, JMSServerRemoteException {
        // Create the session
        mbeanName = new ObjectName("com.example.Session:type=Session,name=" + sessionName);
        mbs.createEphemeralBean(mbeanName, new Session(), null);
    }

    public void deleteSession(String sessionName) throws Exception {
        mbeanName = new ObjectName("com.example.Session:type=Session,name=" + sessionName);
        mbs.removeMBean(mbeanName);
    }

    public void openSession(String sessionName) throws Exception {
        mbeanName = new ObjectName("com.example.Session:type=Session,name=" + sessionName);
        Session mbean = (Session) mbs.queryMBean(mbeanName, "readonly=true");

        // Open the session
        mbean.open();
    }

    public void closeSession(String sessionName) throws Exception {
        mbeanName = new ObjectName("com.example.Session:type=Session,name=" + sessionName);
        Session mbean = (Session) mbs.queryMBean(mbeanName, "readonly=true");

        // Close the session
        mbean.close();
    }
}