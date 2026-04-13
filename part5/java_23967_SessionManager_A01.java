import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class java_23967_SessionManager_A01 {

    // MBean server
    private MBeanServer mbs;

    // Session manager name
    private String name;

    public java_23967_SessionManager_A01(String name) {
        this.name = name;
        try {
            mbs = MBeanServerFactory.getDefaultMBeanServer();
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void createSession(String sessionName) {
        try {
            ObjectName oname = new ObjectName(name + sessionName);
            mbs.registerMBean(new Session(sessionName), oname) ;
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void removeSession(String sessionName) {
        try {
            ObjectName oname = new ObjectName(name + sessionName);
            mbs.unregisterMBean(oname);
        } catch (MalformedObjectNameException | NotCompliantMBeanException | InstanceNotFoundException | MBeanRegistrationException | java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager("com.session.");
        sm.createSession("session1");
        sm.createSession("session2");
    }
}

class Session implements MBean {

    private String sessionName;

    public java_23967_SessionManager_A01(String sessionName) {
        this.sessionName = sessionName;
    }

    // Implement the methods from the MBean interface
}