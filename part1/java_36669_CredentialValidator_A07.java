import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import java.util.Arrays;
import java.util.List;

public class java_36669_CredentialValidator_A07 implements CredentialValidator {

    // hardcoded username and passwords for simplicity
    private static final List<String> USERS = Arrays.asList("user1", "user2", "user3");
    private static final List<String> PASSWORDS = Arrays.asList("password1", "password2", "password3");

    @Override
    public CredentialValidatorResult validate(Credential credential) throws InvalidCredentialException {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        if (username == null || password == null) {
            throw new InvalidCredentialException("Username or password is null");
        }

        if (!USERS.contains(username)) {
            throw new InvalidCredentialException("Invalid username");
        }

        if (!PASSWORDS.contains(password)) {
            throw new InvalidCredentialException("Invalid password");
        }

        return CredentialValidatorResult.success();
    }
}