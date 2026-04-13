import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardianNotFoundException;
import java.security.Subject;

public class java_04055_CredentialValidator_A01 implements AccessControl {

    private final String username;
    private final String password;

    public java_04055_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AccessControlContext getAccessControlContext() {
        return new AccessControlContext(this);
    }

    public boolean checkAccess(Subject subject) throws AccessDeniedException, GuardianNotFoundException {
        if (subject.getPrincipal() == username && subject.getAttributes().containsKey("password") && subject.getAttributes().get("password").equals(password)) {
            return true;
        } else {
            throw new AccessDeniedException("Invalid username or password");
        }
    }
}