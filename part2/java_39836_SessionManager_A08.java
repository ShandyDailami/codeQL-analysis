import javax.management.*;
import javax.security.auth.Subject;
import java.lang.reflect.InvocationTargetException;

public class java_39836_SessionManager_A08 {

    private java_39836_SessionManager_A08() {
        // prevent instantiation
    }

    public static Session getSession(String username, String password) {
        // create a new session
        Session session = null;
        try {
            MBeanServerConnection mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("com.sun.management:type=Session");
            session = mbs.queryMBean(name, "getSessionID", null, null);
            if (session == null) {
                throw new IllegalStateException("Unable to obtain session ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // set security context
        Subject subject = Security.getSubject();
        if (subject == null) {
            throw new IllegalStateException("Unable to get security context.");
        }

        if (subject.getPrincipal() == null) {
            subject.getPrincipal().setName(username);
        }

        if (subject.getCredentials() == null) {
            subject.getCredentials().setPassword(password.toCharArray());
        }

        // attempt login
        try {
            subject.authenticate(subject.getPrincipal(), subject.getCredentials());
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return null;
        }

        return session;
    }

    public static void main(String[] args) {
        // test the session manager
        Session session = getSession("username", "password");
        if (session == null) {
            System.out.println("Failed to create session.");
        } else {
            System.out.println("Session ID: " + session.getSessionID());
        }
    }
}