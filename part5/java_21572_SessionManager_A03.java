import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Permission;
import java.security.SecureClassLoadingException;

public class java_21572_SessionManager_A03 {

    private static final String INJECT_METHOD_NAME = "doSomething";

    // Security-sensitive operation: method injection
    public void inject(Object obj) {
        try {
            Method method = obj.getClass().getMethod(INJECT_METHOD_NAME);
            method.invoke(obj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // Security-sensitive operation: permission injection
    public void injectPermissions(Permission perm) {
        try {
            Method method = SessionManager.class.getDeclaredMethod("check", Permission.class);
            method.invoke(null, perm);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // Security-sensitive operation: security-sensitive method
    public void performSecurityOperation() {
        // Insert your security-sensitive code here
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Inject method
        sm.inject(sm);

        // Inject permission
        Permission permission = new Permission() {
            @Override
            public String getName() {
                return "secure operation";
            }

            @Override
            public void setName(String name) {
                // Not used
            }

            @Override
            public void checkPermission() {
                // Not used
            }

            @Override
            public Collection<? extends Permission> getActions() {
                // Not used
                return null;
            }
        };
        sm.injectPermissions(permission);

        // Security-sensitive operation
        sm.performSecurityOperation();
    }
}