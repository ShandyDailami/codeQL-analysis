import java.security.Credential;
import java.security.AccessControlException;
import java.security.GuardedBy;

public class java_27736_CredentialValidator_A01 implements CredentialValidator {

    @GuardedBy("this.password")
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate(Credential credential) throws AccessControlException {
        if (credential.getPassword() != null && credential.getPassword().equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}