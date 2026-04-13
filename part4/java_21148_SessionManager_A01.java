import javax.management.AttributeNotFoundException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectName;
import javax.naming.NamingException;
import java.lang.management.ManagementException;

public class java_21148_SessionManager_A01 {
    private MBeanServer mBeanServer;
    private ObjectName objectName;

    public java_21148_SessionManager_A01() throws NamingException {
        mBeanServer = getMBeanServer();
        objectName = new ObjectName("com.example.SessionManager:type=SessionManager");
    }

    private MBeanServer getMBeanServer() throws NamingException {
        return ManagementFactory.getPlatformMBeanServer();
    }

    public void createSession() throws InstanceNotFoundException, MalformedObjectNameException, NotCompliantObjectException, MBeanException, AttributeNotFoundException, InstanceAlreadyExistsException {
        Session session = new Session();
        mBeanServer.createInstance("com.example.Session:type=Session", session);
        mBeanServer.registerMBean(session, objectName);
    }

    public void endSession() throws MBeanException, InstanceNotFoundException, AttributeNotFoundException, InstanceAlreadyExistsException, MalformedObjectNameException {
        mBeanServer.unregisterMBean(objectName);
    }
}

class Session {
    private boolean isActive = false;

    public void start() {
        isActive = true;
    }

    public void stop() {
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
}