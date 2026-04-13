import java.security.AuthFailureException;
import java.security.AuthenticationException;
import java.security.Credential;
import java.security.GeneralSecurityException;

public class java_33285_CredentialValidator_A07 implements javax.security.auth.login.CredentialValidator {

    private String username;

    public java_33285_CredentialValidator_A07(String username) {
        this.username = username;
    }

    @Override
    public Credential validate(Credential credential) throws AuthenticationException, GeneralSecurityException {
        String name;
        String password;

        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;
            name = upCredential.getIdentifier();
            password = new String(upCredential.getPassword());
        } else {
            name = credential.getIdentifier();
            password = new String(credential.getPassword());
        }

        if (!name.equals(this.username)) {
            throw new AuthFailureException("Authentication failed: incorrect username");
        }

        if (password.length() != 10) {
            throw new AuthFailureException("Authentication failed: incorrect password length");
        }

        return credential;
    }
}