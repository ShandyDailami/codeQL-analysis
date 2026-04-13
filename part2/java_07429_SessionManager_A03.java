import javax.security.auth.Subject;
import java.security.AccessControlException;
import java.security.Guard;
import java.security.Permission;
import java.security.Policy;

public class java_07429_SessionManager_A03 {

    private final Subject subject;
    private final Guard guard;
    private final Policy policy;

    public java_07429_SessionManager_A03(Subject subject, Guard guard, Policy policy) {
        this.subject = subject;
        this.guard = guard;
        this.policy = policy;
    }

    public void createSession(String user) {
        Permission permission = new Permission("session creation") {
            @Override
            public void checkPermission(Subject subject) {
                try {
                    guard.checkGuard(subject);
                    policy.checkPermission(subject);
                } catch (AccessControlException e) {
                    System.out.println("Access Denied: Cannot create session for user: " + user);
                }
            }
        };

        subject.getPrincipals().get(0).addPermission(permission);
    }

    public void endSession(String user) {
        Permission permission = new Permission("session end") {
            @Override
            public void checkPermission(Subject subject) {
                try {
                    guard.checkGuard(subject);
                    policy.checkPermission(subject);
                } catch (AccessControlException e) {
                    System.out.println("Access Denied: Cannot end session for user: " + user);
                }
            }
        };

        subject.getPrincipals().get(0).addPermission(permission);
    }
}