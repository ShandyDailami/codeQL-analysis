import javax.management.AuthenticationException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectName;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class java_39068_SessionManager_A01 {

    private MBeanServer mbs = null;
    private String url = "service:jmx:yourcompany:name=YourCompany,type=YourType";

    public java_39068_SessionManager_A01() {
        try {
            mbs = javax.management.MBeanServerFactory.findMBeanServer(url);
            ObjectName objectName = new ObjectName("com.yourcompany.yourtype:type=YourType,name=YourName");
            mbs.registerMBean(this, objectName);
        } catch (MalformedObjectNameException | RemoteException | NotCompliantObjectException |
                InstanceAlreadyExistsException | MBeanRegistrationException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void breakAccess() throws AuthenticationException {
        String password = "broken";
        // This is a weak password
        mbs.invoke(objectName, "breakAccess", password);
    }

    public void createSession(String user, String password) {
        // Create session with user and password
    }

    public void endSession(String user) {
        // End session with user
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        try {
            sm.breakAccess();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}