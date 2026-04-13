import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import java.util.Arrays;
import java.util.Base64;

public class java_23888_CredentialValidator_A03 implements CredentialValidator {

    // hardcoded username and password
    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential arg0) {
        // check if the provided username and password match the hardcoded values
        if (Arrays.equals(arg0.getUsername().getBytes(), USERNAME.getBytes()) 
            && arg0.getPassword().equals(PASSWORD)) {
            return arg0;
        } else {
            return null;
        }
    }
}