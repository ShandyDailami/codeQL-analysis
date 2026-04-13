import java.util.Base64;
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_39480_CredentialValidator_A03 {

    public static void main(String[] args) {
        Credential credential = new UsernamePasswordCredential("user", "password".getBytes());
        try {
            if (validate(credential)) {
                System.out.println("Credentials are valid.");
            } else {
                System.out.println("Credentials are invalid.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean validate(Credential credential) throws LoginException {
        // This is a stub for a real implementation. In a real application, you would use a secure method of storing and validating passwords.
        String expectedUsername = "user";
        String expectedPassword = "password";

        if (credential.getUsername().equals(expectedUsername) &&
                Base64.getDecoder().decode(credential.getPassword()).equals(expectedPassword.getBytes())) {
            return true;
        } else {
            return false;
        }
    }
}