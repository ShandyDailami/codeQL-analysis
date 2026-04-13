import javax.management.*;
import javax.security.auth.Subject;
import java.lang.reflect.InvocationTargetException;

public class java_31478_SessionManager_A07 {

    // Fields
    private MBeanServer mbs;
    private SecurityManager securityManager;

    // Constructors
    public java_31478_SessionManager_A07() {
        try {
            mbs = ManagementFactory.getPlatformMBeanServer();
            securityManager = (SecurityManager) Class.forName("javax.security.auth.Subject").getMethod("getAuthenticationPrincipal").invoke(Subject.getCurrentSubject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkAccess(String operation) {
        try {
            Class<?> subjectClass = Class.forName("javax.security.auth.Subject");
            Object subject = subjectClass.getMethod("getAuthenticationPrincipal").invoke(Subject.getCurrentSubject());
            Class<?> subjectClass1 = Class.forName("javax.management.InstanceAlreadyExistsException");
            Method method = subjectClass.getMethod("checkAccess", String.class);
            if (method.invoke(subject, operation) != null) {
                throw new AuthFailureException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SecurityManager().checkAccess("login");
    }
}