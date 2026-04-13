import java.security.Permission;
import java.security.SecurityManager;
import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class java_00766_SessionManager_A07 implements SecurityManager {

    @Override
    public void checkPermission(Permission perm) {
        // Unused for this example
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        // Unused for this example
    }

    @Override
    public void checkActions(String actions) {
        // Unused for this example
    }

    @Override
    public void verifyAction(String action) {
        // Unused for this example
    }

    @Override
    public SecurityContext setContext(HttpSession session) {
        // Unused for this example
        return null;
    }

    @Override
    public SecurityContext getContext() {
        // Unused for this example
        return null;
    }

    @Override
    public Properties getActions(String[] required) {
        // Unused for this example
        return null;
    }
}

public class SessionManager {

    public static void main(String[] args) {
        // Create a security manager
        CustomSecurityManager sm = new CustomSecurityManager();
        // Create a session
        HttpSession session = sm.getSession(true);
        // Set the session attribute
        session.setAttribute("testAttribute", "testValue");
        // Print the session attribute
        System.out.println("Session attribute: " + session.getAttribute("testAttribute"));
    }
}