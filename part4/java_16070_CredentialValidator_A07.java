import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_16070_CredentialValidator_A07 {
    public static boolean validate(String user, String password) {
        Credential credential;
        try {
            credential = new UsernamePasswordCredential(user, password);
            return Security.getSubject().authenticate(credential) != null;
        } catch (LoginException | NullPointerException e) {
            // Handle exception
            return false;
        }
    }

    public static void main(String[] args) {
        // Example usage
        boolean isValid = validate("example", "password");
        System.out.println("Is Valid: " + isValid);
    }
}