import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_00522_CredentialValidator_A08 implements CredentialValidator {

    private static final String USER = "user";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        Set<String> roles = new HashSet<>();

        if (USER.equals(credential.getID()) && PASSWORD.equals(credential.getCredentials()[0])) {
            roles.add("USER");
            return new CredentialValidationResult(roles, null);
        } else {
            return new CredentialValidationResult(null, "Invalid credentials");
        }
    }

    public static void main(String[] args) {
        // This is a test, you should replace this with your own test code
        CredentialValidator validator = new SimpleCredentialValidator();

        try {
            System.out.println(validator.validate(null, new MyCallbackHandler(null)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}