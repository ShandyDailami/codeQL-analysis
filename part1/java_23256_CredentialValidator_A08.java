import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_23256_CredentialValidator_A08 {
    private final Credential credential;

    public java_23256_CredentialValidator_A08(Credential credential) {
        this.credential = credential;
    }

    public boolean validate() {
        return AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
            public Boolean run() {
                return credential.validate();
            }
        });
    }
}