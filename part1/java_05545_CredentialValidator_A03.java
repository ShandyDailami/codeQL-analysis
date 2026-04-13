import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;
import java.util.Arrays;
import java.util.List;

public class java_05545_CredentialValidator_A03 implements CredentialValidator {

    private List<String> allowedUsers = Arrays.asList("user1", "user2", "user3");
    private List<String> allowedPasswords = Arrays.asList("password1", "password2", "password3");

    @Override
    public String validate(String credential) throws CredentialException {
        String[] credentials = credential.split(":");
        if (Arrays.asList(allowedUsers).contains(credentials[0]) &&
                Arrays.asList(allowedPasswords).contains(credentials[1])) {
            return "VALID";
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }
}