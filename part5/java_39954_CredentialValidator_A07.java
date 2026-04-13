import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;

public class java_39954_CredentialValidator_A07 {

    public boolean validate(String username, String password) {
        // Create credential
        Credential credential = new UsernamePasswordCredential(username, password);

        // Create subject
        Subject subject = new Subject.Builder().build();

        // Authenticate
        try {
            subject.login(credential);
            return true;
        } catch (LoginException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Validate user with valid credentials
        if (validator.validate("user", "password")) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Failed to validate!");
        }

        // Validate user with invalid credentials
        if (validator.validate("invalid", "password")) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Failed to validate!");
        }
    }
}