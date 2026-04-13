import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementException;
import java.util.HashSet;
import java.util.Set;

public class java_06442_SessionManager_A01 {
    private Set<String> activeSessions = new HashSet<>();
    private MBeanServer mbs;

    public java_06442_SessionManager_A01() throws MalformedObjectNameException, NotCompliantMBeanException, MBeanException {
        mbs = ManagementFactory.getPlatformMBeanServer();

        StandardMBean smb = new StandardMBean();
        mbs.registerMBean(smb, new ObjectName("com.example.SessionManager:type='session'"));
    }

    public void createSession(String sessionId) throws InvalidAttributeValueException, MBeanException, ManagementException {
        activeSessions.add(sessionId);
        System.out.println("Session created: " + sessionId);
    }

    public void endSession(String sessionId) throws InvalidAttributeValueException, MBeanException, ManagementException {
        activeSessions.remove(sessionId);
        System.out.println("Session ended: " + sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }
}