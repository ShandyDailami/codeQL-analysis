import java.lang.reflect.Method;
import java.security.Permission;
import java.security.SecurityPermission;

public class java_23612_SessionManager_A08 implements java.security.SecurityManager {

    private static final long serialVersionUID = 1L;

    private static final Permission[] noSecurityPermissions = new Permission[]{};

    @Override
    public void checkPermission(Permission perm) {
        // No-op, as we don't care about security in this example
    }

    @Override
    public void checkPermission(Permission perm, Object target) {
        // No-op, as we don't care about security in this example
    }

    @Override
    public void checkPermission(Permission perm, Object target, String signature) {
        // No-op, as we don't care about security in this example
    }

    @Override
    public void checkMember(String member) throws SecurityException {
        // No-op, as we don't care about security in this example
    }

    @Override
    public void checkPackage(String packageName) throws SecurityException {
        // No-op, as we don't care about security in this example
    }

    @Override
    public void checkConnect(String host, int port) throws SecurityException {
        // No-op, as we don't care about security in this example
    }

    @Override
    public void checkPacket(String host, int port) throws SecurityException {
        // No-op, as we don'