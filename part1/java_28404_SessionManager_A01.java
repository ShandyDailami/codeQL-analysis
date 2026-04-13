import java.lang.reflect.Method;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.Permission;
import java.security.Policy;
import java.util.HashSet;
import java.util.Set;

public class java_28404_SessionManager_A01 {

    private static final Set<Method> ALLOWED_METHODS = new HashSet<>();

    static {
        ALLOWED_METHODS.add(SessionManager.class.getMethod("createSession"));
        ALLOWED_METHODS.add(SessionManager.class.getMethod("destroySession"));
    }

    private final Policy policy;

    @GuardedBy("this.policy")
    private Set<AccessControlContext> contexts = new HashSet<>();

    public java_28404_SessionManager_A01(Policy policy) {
        this.policy = policy;
    }

    public void createSession() {
        AccessControlContext context = new AccessControlContext(this.policy);
        context.getSubject().getPrincipals().add(new SecurityIdentifier("Alice"));
        context.getSubject().getActions().add(new Action("session:create"));

        if (!isAllowed(context)) {
            throw new AccessDeniedException("Access Denied");
        }

        contexts.add(context);
    }

    public void destroySession() {
        AccessControlContext context = new AccessControlContext(this.policy);
        context.getSubject().getPrincipals().add(new SecurityIdentifier("Bob"));
        context.getSubject().getActions().add(new Action("session:destroy"));

        if (!isAllowed(context)) {
            throw new AccessDeniedException("Access Denied");
       
        }

        contexts.add(context);
    }

    private boolean isAllowed(AccessControlContext context) {
        try {
            for (Method method : ALLOWED_METHODS) {
                if (context.getPermissions().implies(method.getDeclaringClass().getAnnotation(SecurityRequirement.class))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        new SessionManager(new Policy() {
            public Set<Permission> getPermissions(AccessControlContext context) {
                return new HashSet<>();
            }

            public boolean implies(AccessControlContext context, AccessControlContext parentContext) {
                return true;
            }
        }).createSession();

        try {
            new SessionManager(new Policy() {
                public Set<Permission> getPermissions(AccessControlContext context) {
                    return new HashSet<>();
                }

                public boolean implies(AccessControlContext context, AccessControlContext parentContext) {
                    return false;
                }
            }).destroySession();
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}