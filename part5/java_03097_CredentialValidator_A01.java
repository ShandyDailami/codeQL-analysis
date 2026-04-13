import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_03097_CredentialValidator_A01 {

    public boolean validate(Credential credential) throws LoginException, FailedLoginException {
        String username = credential.getUsername();
        String password = credential.getPassword();

        // Hardcoded values
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        // Check if username and password match hardcoded values
        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            throw new FailedLoginException("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        // This should not be called
        System.out.println("This should not be called");
    }
}