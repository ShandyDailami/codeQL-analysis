import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class java_20622_CredentialValidator_A01 {

    public boolean validate(String username, String password) {
        // Create a credential using the provided username and password
        Credential credential = new PasswordCredential(username, password);

        // Validate the credential
        try {
            credential.validate(null);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | LoginException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("username", "password");
        System.out.println("Is valid: " + isValid);
    }
}