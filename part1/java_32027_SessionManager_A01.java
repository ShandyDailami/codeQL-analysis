import java.lang.reflect.Method;
import java.security.Permission;
import java.security.SecurityException;

public class java_32027_SessionManager_A01 {

    private SecurityManager securityManager;

    public java_32027_SessionManager_A01() {
        this.securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) throws SecurityException {
                // Do nothing. This method is not called by the SecurityManager.
            }

            @Override
            public void checkPermission(Permission perm, Object context) throws SecurityException {
                // Do nothing. This method is not called by the SecurityManager.
            }

            @Override
            public void checkAccess(Member member) throws SecurityException {
                if ("admin".equals(member.getIdentifier())) {
                    throw new SecurityException("Unauthorized access: admin access is restricted.");
                }
            }
        };
    }

    public void checkSession(String sessionId) {
        Method method = null;
        try {
            method = SecurityManager.class.getDeclaredMethod("checkAccess", Member.class);
            method.setAccessible(true);
            method.invoke(securityManager, new Member() {
                @Override
                public String getIdentifier() {
                    return sessionId;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (method != null) {
                method.setAccessible(false);
            }
        }
    }
}