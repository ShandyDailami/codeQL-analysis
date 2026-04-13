import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_40984_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(Credential credential) {
        try {
            X500Principal principal = new X500Principal("CN=John Doe, OU=Users, O=Example, C=US");
            if (principal.equals(credential.getCallerPrincipal())) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean getRequirement(String requirement) {
        return false;
    }
}