import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import javax.security.auth.password.PasswordAuthenticator;
import javax.security.auth.password.PasswordHandle;
import javax.security.auth.password.PasswordQuery;

public class java_37912_CredentialValidator_A03 implements CredentialValidator {

    private String username;
    private String password;

    public java_37912_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public PasswordHandle validate(Subject subject, PasswordQuery passwordQuery) throws AuthenticationException {
        if (passwordQuery.getAuthType().equals("CREDENTIALS")) {
            if (username.equals(passwordQuery.getPasswordIdentity().getIdentifier()) && this.password.equals(passwordQuery.getPasswordIdentity().getPasswordAsString())) {
                return new PlainTextPasswordHandle(this.password);
            }
        }
        return null;
    }
}