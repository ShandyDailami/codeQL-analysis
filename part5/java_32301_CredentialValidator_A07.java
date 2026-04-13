import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_32301_CredentialValidator_A07 {

    // Credentials for authenticating users
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Credential credential = new UsernamePasswordCredential(USERNAME, PASSWORD);

        try {
            // Perform authentication
            validate(credential);
            System.out.println("Authentication successful!");
        } catch (Exception e) {
            System.out.println("Authentication failed!");
        }
    }

    public static void validate(Credential credential) throws LoginException {
        // Check if the provided credentials match the expected credentials
        if ("user".equals(credential.getIdentifier()) && "password".equals(credential.getCredential())) {
            throw new LoginException("Invalid username or password");
        }
    }
}