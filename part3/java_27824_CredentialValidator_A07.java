import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;
import java.security.GeneralSecurityException;

public class java_27824_CredentialValidator_A07 {
    public boolean validate(Credential credential) {
        try {
            if (credential == null) {
                throw new GeneralSecurityException("Credential is null");
            }
            credential.validate();
            return true;
        } catch (GeneralSecurityException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}