import java.lang.reflect.Method;
import java.security.Permission;
import java.security.SecurityManager;

public class java_39916_SessionManager_A01 implements SecurityManager {

    private boolean isSessionStarted = false;

    @Override
    public void checkPermission(Permission perm) {
        // Do nothing as we are not using permissions
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        // Do nothing as we are not using permissions
    }

    @Override
    public boolean implies(Permission perm) {
        // Do nothing as we are not using permissions
        return false;
    }

    @Override
    public boolean implies(Permission perm, Object context) {
        // Do nothing as we are not using permissions
        return false;
    }

    @Override
    public boolean sessionCreated(String arg0, long arg1, boolean arg2) {
        if (isSessionStarted) {
            System.out.println("Session already started");
            return false;
        }
        isSessionStarted = true;
        return true;
    }

    @Override
    public void sessionDestroyed(String arg0, long arg1) {
        if (!isSessionStarted) {
            System.out.println("Session already destroyed");
            return;
        }
        isSessionStarted = false;
    }

    public static void main(String[] args) {
        MySessionManager sm = new MySessionManager();
        Security.setSecurityManager(sm);

        // Start session
        Method m = null;
        try {
            m = MySessionManager.class.getDeclaredMethod("sessionCreated", String.class, long.class, boolean.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            m.invoke(sm, "session", 123456L, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Destroy session
        try {
            m = MySessionManager.class.getDeclaredMethod("sessionDestroyed", String.class, long.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            m.invoke(sm, "session", 123456L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}