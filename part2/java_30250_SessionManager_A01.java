import java.security.Action;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.Subject;

public class java_30250_SessionManager_A01 implements SecurityManager {

    private Subject subject;

    public java_30250_SessionManager_A01(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean checkPermission(Permission permission) {
        return false;
    }

    @Override
    public boolean checkPermission(Permission permission, Object target) {
        return false;
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    @Override
    public boolean implies(Permission permission, Object target) {
        return false;
    }

    @Override
    public void checkPermission(Permission permission) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void checkPermission(Permission permission, Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enforce(Permission permission) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enforce(Permission permission, Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Subject getSubject(Action action) {
        return subject;
    }
}