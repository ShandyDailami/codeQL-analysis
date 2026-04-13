import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_15171_CredentialValidator_A03 {
    public static boolean validate(String username, String password) {
        Credential credential = new UsernamePasswordCredential(username, password);
        try {
            return Security.getSubject().authenticate(credential) != null;
        } catch (LoginException e) {
            // handle login exception here
            System.out.println("Invalid username or password");
            return false;
        }
    }

    public static void main(String[] args) {
        String username = "user";
        String password = "password";
        boolean isValid = validate(username, password);
        System.out.println("Is valid: " + isValid);
    }
}