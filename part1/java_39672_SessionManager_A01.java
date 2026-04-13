import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class java_39672_SessionManager_A01 {
    private SecurityManager securityManager;

    public java_39672_SessionManager_A01() {
        securityManager = new SecurityManager() {
            @Override
            public void checkAccess(Object obj) throws SecurityException {
                if (securityManager != null) {
                    securityManager.checkAccess(obj);
                } else {
                    throw new SecurityException("Unable to access: " + obj);
                }
            }
        };
    }

    public static void main(String[] args) {
        try {
            SessionManager sessionManager = new SessionManager();
            Method method = sessionManager.getClass().getMethod("main", String[].class);
            method.invoke(sessionManager, (Object) null);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}