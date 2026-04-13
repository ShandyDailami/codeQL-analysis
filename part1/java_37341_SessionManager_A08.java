import java.security.Action;
import java.security.Permission;
import java.security.SecurityPermission;
import java.security.Guard;

public class java_37341_SessionManager_A08 extends SecurityManager {

    private Guard guard;

    public java_37341_SessionManager_A08(Guard guard) {
        this.guard = guard;
    }

    @Override
    public void checkPermission(Permission perm) {
        if (perm instanceof SecurityPermission) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void checkActions(String actions) {
        if (actions.equals("getClass")) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Guard getGuard(Class clazz) {
        if (clazz.getName().equals("java.lang.Class")) {
            throw new UnsupportedOperationException();
        }
        return guard;
    }

    @Override
    public void refreshClasses() {
        throw new UnsupportedOperationException();
    }

}