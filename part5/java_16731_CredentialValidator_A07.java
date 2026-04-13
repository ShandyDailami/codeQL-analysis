import java.security.InvalidParameterException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.xauth.XAUTHException;

public class java_16731_CredentialValidator_A07 {

    public static void main(String[] args) {
        validateCredentials(new UsernamePasswordCredential("user", "password"));
        validateCredentials(new PasswordCredential("encodedPassword"));
    }

    public static void validateCredentials(Credential credential) {
        try {
            credential.validate();
            System.out.println("Credentials are valid.");
        } catch (InvalidParameterException | LoginException | XAUTHException e) {
            System.out.println("Invalid credentials: " + e.getMessage());
        }
    }

}