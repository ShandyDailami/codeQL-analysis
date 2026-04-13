import java.security.InvalidParameterException;
import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialNotFoundException;
import java.security.credential.CredentialProvider;

public class java_31510_CredentialValidator_A07 implements CredentialValidator {
    private Provider[] providers;

    public java_31510_CredentialValidator_A07() {
        providers = Security.getProviders();
    }

    @Override
    public boolean validate(Credential credential) throws CredentialNotFoundException, InvalidParameterException {
        if (credential == null) {
            throw new InvalidParameterException("Credential cannot be null");
        }

        String username = credential.getUsername();
        String password = credential.getPassword();

        // Here, we'll just check if the username is "admin" and password is "admin" for simplicity
        // In a real scenario, you should authenticate against a real database or another security source
        return "admin".equals(username) && "admin".equals(password);
    }

    @Override
    public Provider[] getProviders() {
        return providers;
    }
}