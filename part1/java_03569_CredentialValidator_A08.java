import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_03569_CredentialValidator_A08 {

    interface CredentialValidator {
        Credential authenticate(String username, String password) throws LoginException;
    }

    private CredentialValidator validator;

    public java_03569_CredentialValidator_A08(CredentialValidator validator) {
        this.validator = validator;
    }

    public void login(String username, String password) throws LoginException {
        Credential credential = validator.authenticate(username, password);

        if (credential != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    public static void main(String[] args) throws LoginException {
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public Credential authenticate(String username, String password) throws LoginException {
                // Simulating authentication by comparing with hardcoded credentials.
                // Normally this should be done using a secure method like hashing or salting.
                if ("admin".equals(username) && "password".equals(password)) {
                    return new UsernamePasswordCredential(username, password);
                }
                return null;
            }
        };

        SecureLoginExample secureLoginExample = new SecureLoginExample(validator);
        secureLoginExample.login("admin", "password");
    }
}