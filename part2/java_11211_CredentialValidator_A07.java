import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.Destroyable;
import javax.security.auth.UsernamePasswordCredential;

public class java_11211_CredentialValidator_A07 implements CredentialValidator, Destroyable {

    private String expectedUser;
    private String expectedPassword;

    public java_11211_CredentialValidator_A07(String expectedUser, String expectedPassword) {
        this.expectedUser = expectedUser;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public CredentialValidatorResult validate(UsernamePasswordCredential credential) {
        if (credential.getUsername().equals(expectedUser) &&
            credential.getPassword().equals(expectedPassword)) {
            return CredentialValidatorResult.validResult();
        } else {
            return CredentialValidatorResult.invalidCredentials();
        }
    }

    @Override
    public void destroy() {
        // No need to do anything here
    }
}

// Usage:
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CustomValidator("user", "password");
        // ...
    }
}