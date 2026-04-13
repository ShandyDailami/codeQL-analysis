import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementException;
import java.util.logging.Logger;

public class java_06254_SessionManager_A01 {
    private static final Logger logger = Logger.getLogger(SecurityManager.class.getName());
    private MBeanServer mbs;
    private StandardMBean smb;

    public java_06254_SessionManager_A01() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        mbs = ManagementFactory.getPlatformMBeanServer();
        smb = new StandardMBean(new SecurityBean(), new ObjectName("com.example:type=Security"));
        mbs.registerMBean(smb, new ObjectName("com.example:type=Security"));
    }

    public static void main(String[] args) {
        try {
            new SecurityManager();
            logger.info("MBean successfully registered");
        } catch (Exception e) {
            logger.severe("Failed to register MBean: " + e.getMessage());
        }
    }
}

class SecurityBean implements Security {
    private static final Logger logger = Logger.getLogger(SecurityBean.class.getName());

    @Override
    public void secureOperation() {
        logger.info("Performing security sensitive operation");
        // Placeholder for security sensitive operation.
        // This could involve a method that does not have the same level of security.
        // For example, a method that modifies user data or accesses sensitive resources.
    }
}

interface Security {
    void secureOperation();
}