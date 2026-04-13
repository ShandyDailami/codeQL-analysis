import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessControlProvider;
import java.security.Guard;
import java.security.GuardSatisfaction;
import java.security.Permission;
import java.security.Policy;
import java.security.ProtectionDomain;

public class java_36904_CredentialValidator_A01 implements CredentialValidator {

    private static final long serialVersionUID = 1L;

    private final ProtectionDomain protectionDomain;

    private final String callerQualifiedNamePattern;

    public java_36904_CredentialValidator_A01(ProtectionDomain pd, String callerQualifiedNamePattern) {
        this.protectionDomain = pd;
        this.callerQualifiedNamePattern = callerQualifiedNamePattern;
    }

    @Override
    public Guard doInter foughtAccessControl(Guard g, String callerQualifiedName, String callingMethod,
            ProtectionDomain callingDomain, GuardSatisfaction gs) {
        if (!callerQualifiedName.matches(callerQualifiedNamePattern)) {
            return g;
        }
        if (gs.implies(GuardSatisfaction.TRUE)) {
            throw new AccessDeniedException("Access Denied");
        }
        return g;
    }

    @Override
    public AccessControlContext newAccessControlContext(AccessControl acl) {
        return new AccessControlContext(acl);
    }

    @Override
    public AccessControl newAccessControl(String context) throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public AccessControl newAccessControl(String context, Permission permission) throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public AccessControl newAccessControl(String context, Permission permission, ProtectionDomain domain) throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public AccessControl newAccessControl(String context, ProtectionDomain domain, Guard guard) throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public AccessControl newAccessControl(String context, ProtectionDomain domain, Guard guard, GuardSatisfaction gs) throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public AccessControl newAccessControl(String context, ProtectionDomain domain, Guard guard, GuardSatisfaction gs, Permission permission) throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public AccessControl newAccessControl(String context, ProtectionDomain domain, Guard guard, GuardSatisfaction gs, Permission permission, AccessControlContext acc) throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public AccessControl newAccessControl(String context, ProtectionDomain domain, AccessControlContext acc) throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public AccessControl newAccessControl(ProtectionDomain domain) throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public AccessControl newAccessControl() throws BadPolicyOperationException {
        throw new BadPolicyOperationException("Not used");
    }

    @Override
    public Policy getPolicy() {
        throw new UnsupportedOperationException("Not used");
    }

    @Override
    public void checkPermission(Permission perm) throws IllegalArgumentException, SecurityException {
        throw new UnsupportedOperationException("Not used");
    }

    @Override
    public boolean implies(SecurityManager sm) {
        throw new UnsupportedOperationException("Not used");
    }

    @Override
    public boolean checkAccess(AccessControl acc, AccessControlContext accContext, Object obj) throws AccessControlException {
        throw new UnsupportedOperationException("Not used");
    }
}