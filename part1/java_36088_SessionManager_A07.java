import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_36088_SessionManager_A07 implements HttpSessionListener {

    // Authentication status
    private static boolean isSecureOperation = false;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed: " + se.getSession().getId());
    }

    public static void setSecureOperation(boolean secureOperation) {
        isSecureOperation = secureOperation;
    }

    public static boolean isSecureOperation() {
        return isSecureOperation;
    }
}