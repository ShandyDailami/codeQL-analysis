import java.lang.reflect.Method;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.UnsufficientPermissionException;

public class java_41766_SessionManager_A01 implements SecurityManager {
    public void checkPermission(Permission perm) throws UnsufficientPermissionException {
        // This method is empty and is not used in this example
    }

    public void checkMember(String member, Method method) throws UnsufficientPermissionException {
        if (!method.getName().equals("foo")) {
            throw new UnsufficientPermissionException("Permission denied");
        }
    }

    public void checkPermission(Permission perm, Object context) throws UnsufficientPermissionException {
        // This method is also empty and is not used in this example
    }

    public void checkAccess(Object obj) throws UnsufficientPermissionException {
        // This method is also empty and is not used in this example
    }

    public void checkPermission(Permission perm, String contract) throws UnsufficientPermissionException {
        // This method is also empty and is not used in this example
    }

    public Object getObject(String name) {
        // This method is also empty and is not used in this example
        return null;
    }

    public Class getClass(String name) {
        // This method is also empty and is not used in this example
        return null;
    }

    public static void main(String[] args) {
        SecurityManagerExample securityManagerExample = new SecurityManagerExample();
        try {
            securityManagerExample.checkMember("foo", securityManagerExample.getClass("foo").getMethod("bar"));
        } catch (UnsufficientPermissionException e) {
            System.out.println(e.getMessage());
        }
    }
}