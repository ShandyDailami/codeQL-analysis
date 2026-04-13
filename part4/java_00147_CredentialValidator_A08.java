import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardianSelector;
import java.security.GuardianSelector.Service;

public class java_00147_CredentialValidator_A08 {
    public static void main(String[] args) {
        AccessControlContext context = new AccessControlContext();

        Credential c = context.getSubject(GuardianSelector.getGuardianSelector().getGuardian());

        try {
            c.authenticate(new Credential() {
                public boolean authenticate() {
                    throw new AccessDeniedException("This operation is not allowed");
                }

                public boolean getAuthorizationGroup(String authorizationGroup) {
                    return false;
                }

                public boolean getAuthorizationID(String authorizationID) {
                    return false;
                }

                public void clearPassword() {}
            });
        } catch (AccessDeniedException e) {
            System.out.println("Access Denied: " + e.getMessage());
        }
    }
}