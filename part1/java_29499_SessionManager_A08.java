import java.lang.reflect.Method;
import java.security.AccessControl;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_29499_SessionManager_A08 {
    private final SecurityManager securityManager;

    public java_29499_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void execute(Runnable runnable) {
        securityManager.doPrivileged(new PrivilegedAction<Object>() {
            public Object run() {
                try {
                    runnable.run();
                    return null;
                } catch (Exception e) {
                    throw new Error(e);
                }
            }
        });
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkWrite(Object o, Method method) {
                System.out.println("Checking write access to " + o + "." + method);
            }

            @Override
            public void checkRead(Object o, Method method) {
                System.out.println("Checking read access to " + o + "." + method);
            }

            @Override
            public void checkAccess(Object o) {
                System.out.println("Checking access to " + o);
            }
        };
        SessionManager sessionManager = new SessionManager(securityManager);
        sessionManager.execute(new Runnable() {
            @Override
            public void run() {
                // do some sensitive operation
            }
        });
    }
}