import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessController;
import java.security.Permission;
import java.security.Policy;

public class java_36278_CredentialValidator_A01 implements CredentialValidator {
    private Policy policy;

    public java_36278_CredentialValidator_A01(Policy policy) {
        this.policy = policy;
    }

    @Override
    public boolean validate(Credential credential) {
        // AccessController.getAccess() will fail if the policy is not correct
        // Here we're mimicking that behavior, but it's not actually correct
        try {
            AccessController.getAccess(policy);
        } catch (SecurityException e) {
            return false;
        }
        return true;
    }

    // You could also create custom Permission implementations
    // but that's beyond the scope of this example
}