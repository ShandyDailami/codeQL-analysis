import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import java.util.Arrays;
import java.util.List;

public class java_20872_CredentialValidator_A07 implements CredentialValidator {

    private static final List<String> ALLOWED_USERS = Arrays.asList("user1", "user2", "user3");

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws java.security.AuthenticationException {
        String enteredUsername = credential.getCredentialIdentifier();
        return ALLOWED_USERS.contains(enteredUsername);
    }
}