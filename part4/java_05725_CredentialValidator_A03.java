import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;

public class java_05725_CredentialValidator_A03 {
    // Predefined set of acceptable usernames and passwords
    private static final String[][] acceptableCredentials = {
        {"user", "pass"},
        {"admin", "admin"},
        {"user1", "pass1"},
        {"user2", "pass2"},
    };

    public boolean validate(Credential credential) throws FailedLoginException {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        // Check if username and password are in the set of acceptable credentials
        for (int i = 0; i < acceptableCredentials.length; i++) {
            if (acceptableCredentials[i][0].equals(username) && acceptableCredentials[i][1].equals(password)) {
                return true;
            }
        }

        throw new FailedLoginException("Invalid username or password.");
    }

    public static void main(String[] args) {
        // Create a subject and add a credential validator
        Subject subject = new Subject();
        subject.getPublicCredentials().add(new UsernamePasswordCredential("user", "pass"));

        // Use the subject to get a credential validator
        CustomCredentialValidator validator = new CustomCredentialValidator();
        credential.setValidator(subject, validator);

        // Validate a credential
        try {
            credential.login("");
            System.out.println("Login successful!");
        } catch (LoginException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}