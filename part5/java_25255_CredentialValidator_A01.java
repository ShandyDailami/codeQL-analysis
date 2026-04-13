import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import java.util.Arrays;
import java.util.List;

public class java_25255_CredentialValidator_A01 implements CredentialValidator {

    // List of valid users
    private static final List<UsernamePasswordCredential> VALID_USERS = Arrays.asList(
            new UsernamePasswordCredential("user1", "password1"),
            new UsernamePasswordCredential("user2", "password2"),
            new UsernamePasswordCredential("user3", "password3"));

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) {
        // Check if the provided username/password matches a valid user
        for (UsernamePasswordCredential user : VALID_USERS) {
            if (user.getUsername().equals(credential.getUsername())
                    && user.getPassword().equals(credential.getPassword())) {
                return user;
            }
        }
        return null; // No valid user found
    }
}