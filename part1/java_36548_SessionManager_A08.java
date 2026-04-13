import javax.security.auth.Subject;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.Guard;
import java.security.GuardSelector;
import java.security.Permission;
import java.security.Policy;

public class java_36548_SessionManager_A08 {
    private AccessControl accessControl;

    public java_36548_SessionManager_A08(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public void doSecurityCheck(Subject subject) {
        accessControl.check(new Guard() {
            @Override
            public Permission[] getPermissions(GuardSelector guardSelector) {
                return new Permission[0];
            }

            @Override
            public boolean implies(Subject subject, Permission permission) {
                return false;
            }
        }, new Guard() {
            @Override
            public Permission[] getPermissions(GuardSelector guardSelector) {
                return new Permission[0];
            }

            @Override
            public boolean implies(Subject subject, Permission permission) {
                return false;
            }
        });
    }
}