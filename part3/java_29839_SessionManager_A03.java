import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectName;

public class java_29839_SessionManager_A03 {

    private static SessionManager instance;
    private MBeanServer mbs;
    private ObjectName name;

    private java_29839_SessionManager_A03() {
        try {
            mbs = MBeanServerFactory.getPlatformMBeanServer();
            name = new ObjectName("com.example:type=SessionManager");
            mbs.registerMBean(new SessionManagerJmx(), name, null);
        } catch (MalformedObjectNameException | NotCompliantObjectException | InstanceAlreadyExistsException | MBeanRegistrationException | MBeanServerException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public static class SessionManagerJmx implements SessionManagerMBean {

        private int sessionCount = 0;

        public void createSession() {
            sessionCount++;
        }

        public int getSessionCount() {
            return sessionCount;
        }

    }

    public static interface SessionManagerMBean {
        public void createSession();

        public int getSessionCount();
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        sm.createSession();
        System.out.println("Session count: " + sm.getSessionCount());
    }

}