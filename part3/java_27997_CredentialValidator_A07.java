import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.Subject;
import java.security.auth.Credential;

public class java_27997_CredentialValidator_A07 implements CredentialValidator {

    private String username = "user";
    private String password = "password";

    @Override
    public Credential validate(Subject subject) {
        Credential credential = new Credential() {
            public String getName() {
                return null;
            }

            public String getPassword() {
                return null;
            }

            public boolean getAuthenticatedCredential() {
                return false;
            }

            public boolean isAuthenticated() {
                return false;
            }

            public void clearPassword() {
            }
        };

        if (!subject.getPrincipal().equals(username)) {
            throw new LoginException("Username not correct");
        }

        if (!password.equals(credential.getPassword())) {
            throw new LoginException("Password not correct");
        }

        return credential;
    }
}