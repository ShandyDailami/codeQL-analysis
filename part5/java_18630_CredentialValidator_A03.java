import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_18630_CredentialValidator_A03 implements LoginModule {

    private String password;

    public java_18630_CredentialValidator_A03(String password) {
        this.password = password;
    }

    @Override
    public Credential validate(Credential credential) {
        String providedPassword = credential.getCredentialIdentifier();

        // Compare provided password with stored password
        if (providedPassword.equals(this.password)) {
            return new UsernamePasswordCredential(credential.getIdentifier(), credential.getCredentials());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authenticationClass) {
        return UsernamePasswordCredential.class.isAssignableFrom(authenticationClass);
    }
}