import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_19048_SessionManager_A03 extends SecurityManager {

    public void checkPermission(Permission perm) {
        System.out.println("checkPermission: " + perm);
    }

    public void checkAccess(Class<?> clazz) {
        System.out.println("checkAccess: " + clazz);
    }

    public <T> T invokePrivileged(PrivilegedAction<T> action) throws Exception {
        System.out.println("invokePrivileged: " + action.run());
        return null;
    }
}

public class Main {

    public static void main(String[] args) {
        SecurityManager sm = new MySecurityManager();
        sm.checkAccess(MyClass.class);
        sm.invokePrivileged(new PrivilegedAction<String>() {
            public String run() {
                return "Hello, World!";
            }
        });
    }
}

class MyClass {
    public void myMethod() {
        System.out.println("myMethod");
    }
}