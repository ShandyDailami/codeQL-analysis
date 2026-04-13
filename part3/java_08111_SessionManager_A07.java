import javax.management.AuthenticationFailedException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

public class java_08111_SessionManager_A07 {
    private int sessionCount = 0;

    public void createSession() throws AuthenticationFailedException, InstanceNotFoundException, InstanceAlreadyExistsException, NotCompliantMBeanException, MBeanException, ReflectionException {
        sessionCount++;
        System.out.println("Session " + sessionCount + " created.");
    }

    public void closeSession(String sessionName) throws AuthenticationFailedException, InstanceNotFoundException, InstanceAlreadyExistsException, NotCompliantMBeanException, MBeanException, ReflectionException {
        sessionCount--;
        System.out.println("Session " + sessionCount + " closed.");
    }

    public static void main(String[] args) throws AuthenticationFailedException, InstanceNotFoundException, InstanceAlreadyExistsException, NotCompliantMBeanException, MBeanException, ReflectionException {
        new SessionManager().createSession();
        new SessionManager().createSession();
        new SessionManager().closeSession("Session 1");
        new SessionManager().closeSession("Session 2");
    }
}