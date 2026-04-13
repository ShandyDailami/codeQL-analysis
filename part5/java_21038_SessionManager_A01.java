import java.security.AccessControlException;
import java.security.AccessController;
import java.security.Guard;

public class java_21038_SessionManager_A01 {

    public static void main(String[] args) {
        try {
            // Start with an empty guard
            Guard guard = AccessController.getGuard(Main.class.getDeclaringClass().getClassLoader());
            
            // Try to acquire the guard
            guard.enter();
            
            // Access some resource
            accessResource();
            
            // Exit the guard
            guard.exit();
        } catch (AccessControlException e) {
            e.printStackTrace();
        }
    }

    private static void accessResource() {
        // This is a simple resource access, not a secure operation.
        System.out.println("Accessing resource");
    }
}