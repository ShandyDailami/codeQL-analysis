// Start of code

import javax.management.BadNameException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectName;
import javax.naming.CommunicationException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class java_18726_SessionManager_A08 {

    private MBeanServer mbs = null;

    public java_18726_SessionManager_A08() throws NamingException {
        mbs = ManagementFactory.getPlatformMBeanServer();
    }

    public void createSession(String name, String className) throws Exception {
        Object obj = Class.forName(className).newInstance();
        ObjectName oname = new ObjectName(name);
        mbs.registerMBean(obj, oname);
    }

    public void destroySession(String name) throws Exception {
        ObjectName oname = new ObjectName(name);
        mbs.unregisterMBean(oname);
    }

    public static void main(String[] args) {
        try {
            SessionManager sm = new SessionManager();
            sm.createSession("test:name=TestBean,type=TestBean", "TestBean");
            // sm.destroySession("test:name=TestBean,type=TestBean");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// End of code